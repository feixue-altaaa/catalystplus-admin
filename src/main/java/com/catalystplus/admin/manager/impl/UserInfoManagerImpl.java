package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.entity.UserInfoEducation;
import com.catalystplus.admin.manager.UserInfoManager;
import com.catalystplus.admin.response.user.UserInfoResponse;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.service.UserInfoEducationService;
import com.catalystplus.admin.util.RedisKeyUtil;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.catalystplus.admin.constant.AdminUserConstant.*;

@Slf4j
@Service
public class UserInfoManagerImpl implements UserInfoManager {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserInfoEducationService userInfoEducationService;

    @Override
    public List<UserInfoResponse> getNewUsersByEducation(String dateTime) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();

        // 获取昨天的日期
        String lastDate = getLastDate(dateTime);

        String key = RedisKeyUtil.getUserEducationInfoKey(dateTime);

        // 1. 统计本科生
        UserInfoResponse undergraduateInfoResponse = new UserInfoResponse();
        undergraduateInfoResponse.setId(UNDERGRADUATE);
        // 1.1 今日新增本科生数量
        Long undergraduateAddNumber = (Long) redisUtil.getHashValue(key, UNDERGRADUATE);
        undergraduateInfoResponse.setAddNumber(undergraduateAddNumber);
        // 1.2 截至今日本科生数量 = 今日新增本科生数量 + 截至昨日本科生数量
        QueryWrapper<UserInfoEducation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", lastDate).eq("education", UNDERGRADUATE);
        Long undergraduateTotalNumber = undergraduateAddNumber + userInfoEducationService.getOne(queryWrapper).getTotalNumber();
        undergraduateInfoResponse.setTotalNumber(undergraduateTotalNumber);
        userInfoResponses.add(undergraduateInfoResponse);

        // 2. 统计硕士生
        UserInfoResponse masterInfoResponse = new UserInfoResponse();
        masterInfoResponse.setId(MASTER);
        // 2.1 今日新增硕士生数量
        Long masterAddNumber = (Long) redisUtil.getHashValue(key, MASTER);
        masterInfoResponse.setAddNumber(masterAddNumber);
        // 2.2 截至今日硕士生数量 = 今日新增硕士生数量 + 截至昨日硕士生数量
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", lastDate).eq("education", MASTER);
        Long masterTotalNumber = masterAddNumber + userInfoEducationService.getOne(queryWrapper).getTotalNumber();
        undergraduateInfoResponse.setTotalNumber(masterTotalNumber);
        userInfoResponses.add(masterInfoResponse);


        // TODO 3. 统计博士生
        UserInfoResponse doctorInfoResponse = new UserInfoResponse();
        doctorInfoResponse.setId("doctor");

        // TODO 4. 统计老师
        UserInfoResponse teacherInfoResponse = new UserInfoResponse();
        teacherInfoResponse.setId("teacher");

        return  userInfoResponses;
    }

    @Override
    public void recordNewUsersByEducationToday(Long userId, String dateTime) {
        SysUser sysUser = sysUserService.getById(userId);
        log.info("sysUser is {}", sysUser);
        if (sysUser == null) {
            throw new RuntimeException("用户不存在");
        }
        if (UNDERGRADUATE.equals(sysUser.getJob())) {
            redisUtil.hashValueIncrement(RedisKeyUtil.getUserEducationInfoKey(dateTime), UNDERGRADUATE);
        } else if (MASTER.equals(sysUser.getJob())) {
            redisUtil.hashValueIncrement(RedisKeyUtil.getUserEducationInfoKey(dateTime), MASTER);
        } else if (DOCTOR.equals(sysUser.getJob())) {
            redisUtil.hashValueIncrement(RedisKeyUtil.getUserEducationInfoKey(dateTime), DOCTOR);
        } else if (TEACHER.equals(sysUser.getJob())) {
            redisUtil.hashValueIncrement(RedisKeyUtil.getUserEducationInfoKey(dateTime), TEACHER);
        }
    }

    // 根据今日日期获取昨日日期
    private String getLastDate(String dateTime) {
        String[] split = dateTime.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        LocalDate localDate = LocalDate.of(year, month, day);
        localDate = localDate.minusDays(1);
        return localDate.toString();
    }

}
