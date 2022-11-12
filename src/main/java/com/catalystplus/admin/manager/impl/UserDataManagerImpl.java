package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.manager.UserDataManager;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.util.RedisKeyUtil;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserDataManagerImpl implements UserDataManager {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SysUserService sysUserService;


    @Override
    public Long getTNU() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id").eq("status", 1);
        int count = sysUserService.count(queryWrapper);
        return (long) count;
    }

    @Override
    public Long getNNUT(String dateKey) {
        String redisKey = RedisKeyUtil.getNNUTKey(dateKey);
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(redisKey.getBytes()));
    }

    @Override
    public void recordNNUT(String dateKey, Integer userId) {
        String redisKey = RedisKeyUtil.getNNUTKey(dateKey);
        redisTemplate.opsForValue().setBit(redisKey, userId, true);
    }

    @Override
    public Map<String, Long> getDWMAU(String dateKey) {
        Map<String, Long> res = new HashMap<>();

        String dauKey = RedisKeyUtil.getDAUKey(dateKey);

        String[] split = dateKey.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        LocalDate date = LocalDate.of(year, month, day);
        LocalDate parse = LocalDate.parse(date.toString());

        String weekStart = parse.with(DayOfWeek.MONDAY).toString();
        String weekEnd = parse.with(DayOfWeek.SUNDAY).toString();
        String wauKey = RedisKeyUtil.getWAUKey(weekStart, weekEnd);

        String monthStart = parse.with(TemporalAdjusters.firstDayOfMonth()).toString();
        String monthEnd = parse.with(TemporalAdjusters.lastDayOfMonth()).toString();
        String mauKey = RedisKeyUtil.getMAUKey(monthStart, monthEnd);

        Long dau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(dauKey.getBytes()));
        Long wau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(wauKey.getBytes()));
        Long mau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(mauKey.getBytes()));

        res.put("dau", dau);
        res.put("wau", wau);
        res.put("mau", mau);

        return res;
    }

    @Override
    public void recordDWMAU(String dateKey, Integer userId) {
        String dauKey = RedisKeyUtil.getDAUKey(dateKey);

        String[] split = dateKey.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        LocalDate date = LocalDate.of(year, month, day);
        LocalDate parse = LocalDate.parse(date.toString());

        String weekStart = parse.with(DayOfWeek.MONDAY).toString();
        String weekEnd = parse.with(DayOfWeek.SUNDAY).toString();
        String wauKey = RedisKeyUtil.getWAUKey(weekStart, weekEnd);

        String monthStart = parse.with(TemporalAdjusters.firstDayOfMonth()).toString();
        String monthEnd = parse.with(TemporalAdjusters.lastDayOfMonth()).toString();
        String mauKey = RedisKeyUtil.getMAUKey(monthStart, monthEnd);

        redisTemplate.opsForValue().setBit(dauKey, userId, true);
        redisTemplate.opsForValue().setBit(wauKey, userId, true);
        redisTemplate.opsForValue().setBit(mauKey, userId, true);

    }


}
