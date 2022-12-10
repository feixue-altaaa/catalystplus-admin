package com.catalystplus.admin.quartz;

import com.catalystplus.admin.entity.UserActive;
import com.catalystplus.admin.manager.impl.UserActiveManagerImpl;
import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;
import com.catalystplus.admin.service.UserActiveService;
import com.catalystplus.admin.util.RedisKeyUtil;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
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
public class UserActiveDataJob {

    @Autowired
    private UserActiveService userActiveService;

    @Autowired
    private UserActiveManagerImpl userActiveManager;

    @Autowired
    private RedisUtil redisUtil;

    // 每天定时持久化用户活跃数据
    @Scheduled(cron = "0 59 23 * * ?")
    @Transactional
    public void persistUserActiveData() {
        // 获取今日的日期，如2022-11-12
        String dateTime = LocalDate.now().toString();

        UserActive userActive = new UserActive();

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
            } else {
                userActive.setMau(userActiveResponse.getNum());
                userActive.setPmau(userActiveResponse.getPercent());
            }
        }
        List<UserRetainedResponse> retainedUsersInfo = userActiveManager.getRetainedUsersInfo(dateTime);
        for (UserRetainedResponse userRetainedResponse : retainedUsersInfo) {
            if ("wnru".equals(userRetainedResponse.getId())) {
                userActive.setWnru(userRetainedResponse.getNum());
                userActive.setWurr(userRetainedResponse.getRate());
            } else {
                userActive.setMnru(userRetainedResponse.getNum());
                userActive.setMurr(userRetainedResponse.getRate());
            }
        }

        userActiveService.save(userActive);

        String oneMonthBefore = LocalDate.now().minusMonths(1).toString();

        redisUtil.delete(RedisKeyUtil.getUserActiveNNUTKey(oneMonthBefore));
        redisUtil.delete(RedisKeyUtil.getUserActiveDAUKey(dateTime));
        redisUtil.delete(RedisKeyUtil.getUserActiveMNRUKey(dateTime));
        redisUtil.delete(RedisKeyUtil.getUserActiveWNRUKey(dateTime));

    }

    // 每周的最后一天定时删除
    @Scheduled(cron = "0 59 23 ? * L")
    public void deleteUserActiveWAUKey() {
        LocalDate parse = LocalDate.parse(LocalDate.now().toString());
        // 获得本周的起始日期和结束日期
        String weekStartDate = parse.with(DayOfWeek.MONDAY).toString();
        String weekEndDate = parse.with(DayOfWeek.SUNDAY).toString();
        redisUtil.delete(RedisKeyUtil.getUserActiveWAUKey(weekStartDate, weekEndDate));
    }

    // 每月的最后一天定时删除
    @Scheduled(cron = "0 59 23 L * ?")
    public void deleteUserActiveMAUKey() {
        LocalDate parse = LocalDate.parse(LocalDate.now().toString());
        // 获得本月的起始日期和结束日期
        String monthStartDate = parse.with(TemporalAdjusters.firstDayOfMonth()).toString();
        String monthEndDate = parse.with(TemporalAdjusters.lastDayOfMonth()).toString();
        redisUtil.delete(RedisKeyUtil.getUserActiveMAUKey(monthStartDate, monthEndDate));
    }
}
