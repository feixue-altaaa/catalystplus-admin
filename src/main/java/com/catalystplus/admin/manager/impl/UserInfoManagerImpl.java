package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.entity.UserInfo;
import com.catalystplus.admin.manager.UserInfoManager;
import com.catalystplus.admin.response.user.UserInfoResponse;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.service.UserInfoService;
import com.catalystplus.admin.util.RedisKeyUtil;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserInfoManagerImpl implements UserInfoManager {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public List<UserInfoResponse> getNewUsersByEducation(String dateTime) {
        List<UserInfoResponse> userInfoByEducationResponses = new ArrayList<>();

        // 查询昨日的记录
        String lastDate = getLastDate(dateTime);
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", lastDate);
        UserInfo userInfo = userInfoService.getOne(queryWrapper);

        // 1.1 今日新增本科生数
        Long undergraduatesAddNumber = (Long) redisUtil.getHashKey(RedisKeyUtil.getUserEducationInfoKey(dateTime), "undergraduates");
        // 1.2 截至今日本科生数
        Long undergraduatesTotalNumber = undergraduatesAddNumber + userInfo.getTnu();
        // 1.3 组装响应
        UserInfoResponse undergraduatesResponse = new UserInfoResponse();
        undergraduatesResponse.setId("undergraduates");
        undergraduatesResponse.setAddNumber(undergraduatesAddNumber);
        undergraduatesResponse.setTotalNumber(undergraduatesTotalNumber);

        // 2.1 今日新增研究生数
        Long mastersAddNumber = (Long) redisUtil.getHashKey(RedisKeyUtil.getUserEducationInfoKey(dateTime), "masters");
        // 2.2 截至今日研究生数
        Long mastersTotalNumber = mastersAddNumber + userInfo.getTnm();
        // 2.3 组装响应
        UserInfoResponse mastersResponse = new UserInfoResponse();
        mastersResponse.setId("masters");
        mastersResponse.setAddNumber(mastersAddNumber);
        mastersResponse.setTotalNumber(mastersTotalNumber);

        return  userInfoByEducationResponses;
    }

    @Override
    public void recordNewUsersByEducationToday(Long userId, String dateTime) {
        SysUser sysUser = sysUserService.getById(userId);
        if ("undergraduates".equals(sysUser.getJob())) {
            redisUtil.hashIncrement(RedisKeyUtil.getUserEducationInfoKey(dateTime), "undergraduates");
        } else if ("masters".equals(sysUser.getJob())) {
            redisUtil.hashIncrement(RedisKeyUtil.getUserEducationInfoKey(dateTime), "masters");
        } else if ("doctors".equals(sysUser.getJob())) {
            redisUtil.hashIncrement(RedisKeyUtil.getUserEducationInfoKey(dateTime), "doctors");
        } else if ("teachers".equals(sysUser.getJob())) {
            redisUtil.hashIncrement(RedisKeyUtil.getUserEducationInfoKey(dateTime), "teachers");
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
