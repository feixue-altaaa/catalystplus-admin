package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.manager.UserActiveManager;
import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserConcurrentResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.util.RedisKeyUtil;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserActiveManagerImpl implements UserActiveManager {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public Long getTotalNumberOfUsers() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id").eq("status", 1);
        return (long) sysUserService.count(queryWrapper);
    }

    @Override
    public void recordNewUsersToday(Long userId, String createdTime) {
        String key = RedisKeyUtil.getUserActiveNNUTKey(createdTime);
        redisUtil.setBit(key, userId, true);
    }

    @Override
    public Long getNewUsersToday(String dateTime) {
        String key = RedisKeyUtil.getUserActiveNNUTKey(dateTime);
        return redisUtil.bitCount(key);
    }

    @Override
    public void recordActiveUsersInfo(Long userId, String loginTime) {
        Map<String, String> map = getWeekAndMonthDate(loginTime);
        String dauKey = RedisKeyUtil.getUserActiveDAUKey(loginTime);
        String wauKey = RedisKeyUtil.getUserActiveWAUKey(map.get("weekStart"), map.get("weekEnd"));
        String mauKey = RedisKeyUtil.getUserActiveMAUKey(map.get("monthStart"), map.get("monthEnd"));
        redisUtil.setBit(dauKey, userId, true);
        redisUtil.setBit(wauKey, userId, true);
        redisUtil.setBit(mauKey, userId, true);
    }

    @Override
    public List<UserActiveResponse> getActiveUsersInfo(String dateTime) {
        List<UserActiveResponse> userAu = new ArrayList<>();
        Map<String, String> map = getWeekAndMonthDate(dateTime);
        String dauKey = RedisKeyUtil.getUserActiveDAUKey(dateTime);
        String wauKey = RedisKeyUtil.getUserActiveWAUKey(map.get("weekStart"), map.get("weekEnd"));
        String mauKey = RedisKeyUtil.getUserActiveMAUKey(map.get("monthStart"), map.get("monthEnd"));

        Long dau = redisUtil.bitCount(dauKey);
        Long wau = redisUtil.bitCount(wauKey);
        Long mau = redisUtil.bitCount(mauKey);
        Long tnu = getTotalNumberOfUsers();
        Double pdau = Double.parseDouble(String.format("%.2f", dau.doubleValue() / tnu.doubleValue()));
        Double pwau = Double.parseDouble(String.format("%.2f", wau.doubleValue() / tnu.doubleValue()));
        Double pmau = Double.parseDouble(String.format("%.2f", mau.doubleValue() / tnu.doubleValue()));

        UserActiveResponse dauResponse = new UserActiveResponse(), wauResponse = new UserActiveResponse(), mauResponse = new UserActiveResponse();
        dauResponse.setId("dau");
        dauResponse.setNum(dau);
        dauResponse.setPercent(pdau);
        wauResponse.setId("wau");
        wauResponse.setNum(wau);
        wauResponse.setPercent(pwau);
        mauResponse.setId("mau");
        mauResponse.setNum(mau);
        mauResponse.setPercent(pmau);
        userAu.add(dauResponse);
        userAu.add(wauResponse);
        userAu.add(mauResponse);
        return userAu;
    }

    @Override
    public void recordConcurrentUsersInfo(Long userId, Integer onlineFlag) {
        // 获取用户
        SysUser sysUser = sysUserService.getById(userId);
        String nacuKey = RedisKeyUtil.getUserActiveNACUKey();
        String nncuKey = RedisKeyUtil.getUserActiveNNCUKey();
        if (onlineFlag == 1) {
            // 用户上线
            redisUtil.setBit(nacuKey, userId, true);
            if (LocalDate.now().toString().equals(sysUser.getCreatedTime().format(DateTimeFormatter.ISO_LOCAL_DATE))) {
                // 该用户为新用户
                redisUtil.setBit(nncuKey, userId, true);
            }
        } else {
            // 用户下线
            redisUtil.setBit(nacuKey, userId, false);
            if (LocalDate.now().toString().equals(sysUser.getCreatedTime().format(DateTimeFormatter.ISO_LOCAL_DATE))) {
                // 该用户为新用户
                redisUtil.setBit(nncuKey, userId, false);
            }
        }
    }

    @Override
    public List<UserConcurrentResponse> getConcurrentUsersInfo() {
        List<UserConcurrentResponse> userCu = new ArrayList<>();
        String nacuKey = RedisKeyUtil.getUserActiveNACUKey();
        String nncuKey = RedisKeyUtil.getUserActiveNNCUKey();
        Long nacu = redisUtil.bitCount(nacuKey);
        Long nncu = redisUtil.bitCount(nncuKey);

        UserConcurrentResponse nacuResponse = new UserConcurrentResponse(), nncuResponse = new UserConcurrentResponse();
        nacuResponse.setId("nacu");
        nacuResponse.setNum(nacu);
        nncuResponse.setId("nncu");
        nncuResponse.setNum(nncu);
        userCu.add(nacuResponse);
        userCu.add(nncuResponse);
        return userCu;
    }

    @Override
    public List<UserRetainedResponse> getRetainedUsersInfo(String dateTime) {
        List<UserRetainedResponse> userRetention = new ArrayList<>();
        String[] split = dateTime.split("-");
        LocalDate localDate = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        // 七天前日期
        LocalDate SevenDaysBefore = localDate.minusDays(7);
        // 一个月前日期
        LocalDate oneMonthBefore = localDate.minusMonths(1);

        // 1.获取七天前用户留存数
        String wnruKey = RedisKeyUtil.getUserActiveWNRUKey(dateTime);
        String key1 = RedisKeyUtil.getUserActiveNNUTKey(SevenDaysBefore.toString());
        String key2 = RedisKeyUtil.getUserActiveDAUKey(dateTime);
        Long wnru = redisUtil.bitOperationAnd(wnruKey, key1, key2);

        // 2.获取七天前用户留存率
        double wurr = Double.parseDouble(String.format("%.2f",
                wnru.doubleValue() / getNewUsersToday(SevenDaysBefore.toString()).doubleValue()));

        // 3.获取一个月前用户留存数
        String mnruKey = RedisKeyUtil.getUserActiveMNRUKey(dateTime);
        key1 = RedisKeyUtil.getUserActiveNNUTKey(oneMonthBefore.toString());
        Long mnru = redisUtil.bitOperationAnd(mnruKey, key1, key2);

        // 4.获取一个月前用户留存率
        double murr = Double.parseDouble(String.format("%.2f",
                mnru.doubleValue() / getNewUsersToday(oneMonthBefore.toString()).doubleValue()));

        UserRetainedResponse wnruResponse = new UserRetainedResponse();
        wnruResponse.setId("wnru");
        wnruResponse.setNum(wnru);
        wnruResponse.setRate(wurr);
        UserRetainedResponse mnruResponse = new UserRetainedResponse();
        mnruResponse.setId("mnru");
        mnruResponse.setNum(mnru);
        mnruResponse.setRate(murr);
        userRetention.add(wnruResponse);
        userRetention.add(mnruResponse);
        return userRetention;
    }

    // 根据日期获取其所在周和月的起始日期和结束日期
    private Map<String, String> getWeekAndMonthDate(String dateTime) {
        Map<String, String> map = new HashMap<>();
        String[] split = dateTime.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate parse = LocalDate.parse(date.toString());
        String weekStart = parse.with(DayOfWeek.MONDAY).toString();
        String weekEnd = parse.with(DayOfWeek.SUNDAY).toString();
        String monthStart = parse.with(TemporalAdjusters.firstDayOfMonth()).toString();
        String monthEnd = parse.with(TemporalAdjusters.lastDayOfMonth()).toString();
        map.put("weekStart", weekStart);
        map.put("weekEnd", weekEnd);
        map.put("monthStart", monthStart);
        map.put("monthEnd", monthEnd);
        return map;
    }
}
