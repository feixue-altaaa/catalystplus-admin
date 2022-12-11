package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.entity.UserInfo;
import com.catalystplus.admin.entity.UserInfoEducation;
import com.catalystplus.admin.entity.UserInfoUniversity;
import com.catalystplus.admin.manager.UserInfoManager;
import com.catalystplus.admin.mapper.UserInfoMapper;
import com.catalystplus.admin.response.user.UserInfoMajorResponse;
import com.catalystplus.admin.response.user.UserInfoResponse;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.service.UserInfoEducationService;
import com.catalystplus.admin.service.UserInfoUniversityService;
import com.catalystplus.admin.util.RedisKeyUtil;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    private UserInfoUniversityService userInfoUniversityService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void recordNewUsersInfoToday(Long userId, String dateTime) {
        SysUser sysUser = sysUserService.getById(userId);
        String job = sysUser.getJob();
        String institution = sysUser.getInstitution();
        String majorCode = sysUser.getMajorCode();

        String key = RedisKeyUtil.getUserInfoKey(dateTime);

        // 判断用户学校的类型，比如C9、985、211、其他
        String institutionKey;
        if (Arrays.asList(LIST_C9).contains(institution)) {
            institutionKey = "c9";
        } else if (Arrays.asList(LIST_985).contains(institution)) {
            institutionKey = "985";
        } else if (Arrays.asList(LIST_211).contains(institution)) {
            institutionKey = "211";
        } else {
            institutionKey = "other";
        }

        redisUtil.hashValueIncrement(key, institutionKey);
        redisUtil.hashValueIncrement(key, job);
        redisUtil.hashValueIncrement(key, majorCode);
    }

    @Override
    public List<UserInfoResponse> getUsersInfoByEducation(String dateTime) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();

        String lastDate = getLastDate(dateTime);

        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);

        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setId("本科生");
        // 1.1 今日本科生新增数
        Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "undergraduate");
        userInfoResponse.setAddNumber(addNumber);
        // 1.2 本科生总数 = 今日新增 + 昨日总数
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByEducation("undergraduate", lastDate));
        userInfoResponses.add(userInfoResponse);

        userInfoResponse.setId("硕士生");
        // 2.1 今日研究生新增数
        addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "master");
        userInfoResponse.setAddNumber(addNumber);
        // 2.2 研究生总数 = 今日新增 + 昨日总数
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByEducation("master", lastDate));
        userInfoResponses.add(userInfoResponse);

        userInfoResponse.setId("博士");
        // 3.1 今日博士生新增数
        addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "doctor");
        userInfoResponse.setAddNumber(addNumber);
        // 3.2 博士生总数 = 今日新增 + 昨日总数
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByEducation("doctor", lastDate));
        userInfoResponses.add(userInfoResponse);

        userInfoResponse.setId("老师");
        // 4.1 今日老师新增数
        addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "teacher");
        userInfoResponse.setAddNumber(addNumber);
        // 4.2 老师总数 = 今日新增 + 昨日总数
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByEducation("teacher", lastDate));
        userInfoResponses.add(userInfoResponse);

        return userInfoResponses;
    }

    @Override
    public List<UserInfoResponse> getUsersInfoByUniversity(String dateTime) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();

        String lastDate = getLastDate(dateTime);

        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);
        UserInfoResponse userInfoResponse = new UserInfoResponse();

        userInfoResponse.setId("c9院校");
        Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "c9");
        userInfoResponse.setAddNumber(addNumber);
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByUniversity("c9", lastDate));
        userInfoResponses.add(userInfoResponse);

        userInfoResponse.setId("985院校");
        addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "985");
        userInfoResponse.setAddNumber(addNumber);
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByUniversity("985", lastDate));
        userInfoResponses.add(userInfoResponse);

        userInfoResponse.setId("211院校");
        addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "211");
        userInfoResponse.setAddNumber(addNumber);
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByUniversity("211", lastDate));
        userInfoResponses.add(userInfoResponse);

        userInfoResponse.setId("其他院校");
        addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "other");
        userInfoResponse.setAddNumber(addNumber);
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByUniversity("other", lastDate));
        userInfoResponses.add(userInfoResponse);

        return userInfoResponses;
    }

    @Override
    public List<UserInfoResponse> getUsersInfoByDiscipline(String dateTime) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();

        String lastDate = getLastDate(dateTime);

        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);
        UserInfoResponse userInfoResponse = new UserInfoResponse();

        userInfoResponse.setId("01哲学");
        Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, "01");
        userInfoResponse.setAddNumber(addNumber);
        userInfoResponse.setTotalNumber(addNumber + getTotalNumByDiscipline("c9", lastDate));
        userInfoResponses.add(userInfoResponse);



        return userInfoResponses;
    }

    @Override
    public List<UserInfoMajorResponse> getUsersInfoByMajor(String dateTime, int pageNo, int pageSize) {
        return null;
    }

    // 获取昨日的日期
    private String getLastDate(String dateTime) {
        String[] split = dateTime.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return LocalDate.of(year, month, day).minusDays(1).toString();
    }

    private Integer getTotalNumByEducation(String education, String dateTime) {
        QueryWrapper<UserInfoEducation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", dateTime).eq("education", education);
        return Math.toIntExact(userInfoEducationService.getOne(queryWrapper).getTotalNumber());
    }

    private Integer getTotalNumByUniversity(String university, String dateTime) {
        QueryWrapper<UserInfoUniversity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", dateTime).eq("university", university);
        return Math.toIntExact(userInfoUniversityService.getOne(queryWrapper).getTotalNumber());
    }

    private Integer getTotalNumByDiscipline(String discipline, String dateTime) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", dateTime).eq("discipline", discipline);
        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        int sum = 0;
        for (UserInfo userInfo : userInfos) {
            sum += Math.toIntExact(userInfo.getTotalNumber());
        }
        return sum;
    }

    private Integer getTotalNumByMajor(String major, String dateTime) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", dateTime).eq("major", major);
        return Math.toIntExact(userInfoMapper.selectOne(queryWrapper).getTotalNumber());
    }
}
