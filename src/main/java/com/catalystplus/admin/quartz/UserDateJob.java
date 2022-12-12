package com.catalystplus.admin.quartz;

import com.catalystplus.admin.entity.UserActive;
import com.catalystplus.admin.entity.UserInfo;
import com.catalystplus.admin.entity.UserInfoEducation;
import com.catalystplus.admin.entity.UserInfoUniversity;
import com.catalystplus.admin.manager.impl.UserActiveManagerImpl;
import com.catalystplus.admin.manager.impl.UserInfoManagerImpl;
import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserInfoResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;
import com.catalystplus.admin.service.UserActiveService;
import com.catalystplus.admin.service.UserInfoEducationService;
import com.catalystplus.admin.service.UserInfoService;
import com.catalystplus.admin.service.UserInfoUniversityService;
import com.catalystplus.admin.util.RedisKeyUtil;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Slf4j
@Component
public class UserDateJob {

    @Autowired
    private UserActiveService userActiveService;

    @Autowired
    private UserActiveManagerImpl userActiveManager;

    @Autowired
    private UserInfoManagerImpl userInfoManager;

    @Autowired
    private UserInfoEducationService userInfoEducationService;

    @Autowired
    private UserInfoUniversityService userInfoUniversityService;

    @Autowired
    private UserInfoService userInfoService;


    @Autowired
    private RedisUtil redisUtil;

    /**
     * 每天的23:59执行定时任务
     */
    @Scheduled(cron = "0 59 23 * * ?")
    public void executeUserJobEveryday() {
        // 1. 持久化用户活跃信息
        ((UserDateJob) AopContext.currentProxy()).saveUserActiveInfoAndDeleteKey();
        // 2. 持久化用户信息
        ((UserDateJob) AopContext.currentProxy()).saveUserInfoAndDeleteKey();
    }

    /**
     * 每周的最后一天的23:59执行定时任务
     */
    @Scheduled(cron = "0 59 23 ? * L")
    public void executeUserJobEveryweek() {
        deleteUserActiveWauKey();
    }

    /**
     * 每月的最后一天的23:59执行定时任务
     */
    @Scheduled(cron = "0 59 23 L * ?")
    public void executeUserJobEverymonth() {
        deleteUserActiveMauKey();
    }

    /**
     * 持久化用户活跃信息，并删除redis中对应的键
     */
    @Transactional
    protected void saveUserActiveInfoAndDeleteKey() {
        UserActive userActive = new UserActive();
        String dateTime = LocalDate.now().toString();
        userActive.setDateTime(dateTime);
        Long totalNumberOfUsers = userActiveManager.getTotalNumberOfUsers();
        userActive.setTnu(totalNumberOfUsers);
        Long newUsersToday = userActiveManager.getNewUsersToday(dateTime);
        userActive.setNnut(newUsersToday);
        List<UserActiveResponse> activeUsersInfo = userActiveManager.getActiveUsersInfo(dateTime);
        for (UserActiveResponse userActiveResponse : activeUsersInfo) {
            if ("dau".equals(userActiveResponse.getId())) {
                userActive.setDau(userActiveResponse.getNum());
                userActive.setPdau(userActiveResponse.getPercent());
            } else if ("wau".equals(userActiveResponse.getId())) {
                userActive.setWau(userActiveResponse.getNum());
                userActive.setPwau(userActiveResponse.getPercent());
            } else if ("mau".equals(userActiveResponse.getId())) {
                userActive.setMau(userActiveResponse.getNum());
                userActive.setPmau(userActiveResponse.getPercent());
            }
        }
        List<UserRetainedResponse> retainedUsersInfo = userActiveManager.getRetainedUsersInfo(dateTime);
        for (UserRetainedResponse userRetainedResponse : retainedUsersInfo) {
            if ("wnru".equals(userRetainedResponse.getId())) {
                userActive.setWnru(userRetainedResponse.getNum());
                userActive.setWurr(userRetainedResponse.getRate());
            } else if ("mnru".equals(userRetainedResponse.getId())) {
                userActive.setMnru(userRetainedResponse.getNum());
                userActive.setMurr(userRetainedResponse.getRate());
            }
        }
        userActiveService.save(userActive);
        String oneMonthLast = LocalDate.now().minusMonths(1).toString();
        redisUtil.delete(RedisKeyUtil.getUserActiveNNUTKey(oneMonthLast));
        redisUtil.delete(RedisKeyUtil.getUserActiveDAUKey(dateTime));
        redisUtil.delete(RedisKeyUtil.getUserActiveMNRUKey(dateTime));
        redisUtil.delete(RedisKeyUtil.getUserActiveWNRUKey(dateTime));
    }

    /**
     * 删除redis中的统计周活跃信息的键
     */
    private void deleteUserActiveWauKey() {
        LocalDate parse = LocalDate.parse(LocalDate.now().toString());
        String weekStart = parse.with(DayOfWeek.MONDAY).toString();
        String weekEnd = parse.with(DayOfWeek.SUNDAY).toString();
        redisUtil.delete(RedisKeyUtil.getUserActiveWAUKey(weekStart, weekEnd));
    }

    /**
     * 删除redis中的统计月活跃信息的键
     */
    private void deleteUserActiveMauKey() {
        LocalDate parse = LocalDate.parse(LocalDate.now().toString());
        String monthStart = parse.with(TemporalAdjusters.firstDayOfMonth()).toString();
        String monthEnd = parse.with(TemporalAdjusters.lastDayOfMonth()).toString();
        redisUtil.delete(RedisKeyUtil.getUserActiveMAUKey(monthStart, monthEnd));
    }

    // 持久化统计用户信息数据，并删除redis中对应的键
    @Transactional
    protected void saveUserInfoAndDeleteKey() {
        String dateTime = LocalDate.now().toString();
        // 1.持久化用户信息按学历
        List<UserInfoResponse> usersInfoByEducation = userInfoManager.getUsersInfoByEducation(dateTime);
        for (UserInfoResponse userInfoResponse : usersInfoByEducation) {
            UserInfoEducation userInfoEducation = new UserInfoEducation();
            userInfoEducation.setEducation(userInfoResponse.getId());
            userInfoEducation.setAddNumber(Long.valueOf(userInfoResponse.getAddNumber()));
            userInfoEducation.setTotalNumber(Long.valueOf(userInfoResponse.getTotalNumber()));
            userInfoEducation.setDateTime(dateTime);
            userInfoEducationService.save(userInfoEducation);
        }
        // 2.持久化用户信息按学校
        List<UserInfoResponse> usersInfoByUniversity = userInfoManager.getUsersInfoByUniversity(dateTime);
        for (UserInfoResponse userInfoResponse : usersInfoByUniversity) {
            UserInfoUniversity userInfoUniversity = new UserInfoUniversity();
            userInfoUniversity.setUniversity(userInfoResponse.getId());
            userInfoUniversity.setAddNumber(Long.valueOf(userInfoResponse.getAddNumber()));
            userInfoUniversity.setTotalNumber(Long.valueOf(userInfoResponse.getTotalNumber()));
            userInfoUniversity.setDateTime(dateTime);
            userInfoUniversityService.save(userInfoUniversity);
        }

        // 3.持久化用户信息按学科和专业
        List<UserInfoResponse> usersInfoByMajor = userInfoManager.getUsersInfoByMajor(dateTime);
        for (UserInfoResponse userInfoResponse : usersInfoByMajor) {
            UserInfo userInfo = new UserInfo();
            userInfo.setDiscipline(userInfoResponse.getId().substring(0, 2));
            userInfo.setMajor(userInfoResponse.getId());
            userInfo.setAddNumber(Long.valueOf(userInfoResponse.getAddNumber()));
            userInfo.setTotalNumber(Long.valueOf(userInfoResponse.getTotalNumber()));
            userInfo.setDateTime(dateTime);
            userInfoService.save(userInfo);
        }

        // 删除redis中的键
        redisUtil.delete(RedisKeyUtil.getUserInfoKey(dateTime));

    }

}
