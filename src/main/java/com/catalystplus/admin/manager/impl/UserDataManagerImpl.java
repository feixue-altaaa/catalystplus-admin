package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.manager.UserDataManager;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.util.RedisKeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
    public Map<String, Object> getDWMAU(String dateKey) {
        Map<String, Object> res = new HashMap<>();

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

        Long tnu = getTNU();
        DecimalFormat df = new DecimalFormat("0.00");
        String pdau = df.format(dau / (double) tnu);
        String pwau = df.format(wau / (double) tnu);
        String pmau = df.format(mau / (double) tnu);
        res.put("dau", dau);
        res.put("wau", wau);
        res.put("mau", mau);
        res.put("pdau", pdau);
        res.put("pwau", pwau);
        res.put("pmau", pmau);

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

    @Override
    public void recordNNACU(Integer userId, Integer status) {
        SysUser user = sysUserService.getById(userId);
        String nncuKey = null;
        if (LocalDate.now().toString().equals(user.getCreatedTime().toString())) {
            // 新用户
            nncuKey = RedisKeyUtil.getNNCUKey();
        }
        String nacuKey = RedisKeyUtil.getNACUKey();

        if (status == 1) {
            // 用户上线
            if (nncuKey != null) {
                redisTemplate.opsForValue().setBit(nncuKey, userId, true);
            }
            redisTemplate.opsForValue().setBit(nacuKey, userId, true);
        } else if (status == 0) {
            // 用户下线
            if (nncuKey != null) {
                redisTemplate.opsForValue().setBit(nncuKey, userId, false);
            }
            redisTemplate.opsForValue().setBit(nacuKey, userId, false);
        }
    }

    @Override
    public Long getNACU() {
        String nacuKey = RedisKeyUtil.getNACUKey();
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(nacuKey.getBytes()));
    }

    @Override
    public Long getNNCU() {
        String nncuKey = RedisKeyUtil.getNNCUKey();
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(nncuKey.getBytes()));
    }

}
