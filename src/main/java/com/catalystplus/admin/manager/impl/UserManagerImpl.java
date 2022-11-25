package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.manager.UserManager;
import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserConcurrentResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.util.RedisKeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public Long queryUserTNU() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id").eq("status", 1);
        return (long) sysUserService.count(queryWrapper);
    }

    @Override
    public void recordUserNNUT(Long userId, LocalDateTime createdTime) {
        String redisKey = RedisKeyUtil.getNNUTKey(createdTime);
        // 当userId超过Integer的范围，会报错
        redisTemplate.opsForValue().setBit(redisKey, userId, true);
    }

    @Override
    public Long queryUserNNUT(LocalDateTime dateTime) {
        String redisKey = RedisKeyUtil.getNNUTKey(dateTime);
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(redisKey.getBytes()));
    }

    @Override
    public void recordUserAU(Long userId, LocalDateTime loginTime) {
        Map<String, String> weekAndMonth = getWeekAndMonth(loginTime);
        String dauKey = RedisKeyUtil.getDAUKey(loginTime);
        String wauKey = RedisKeyUtil.getWAUKey(weekAndMonth.get("weekStart"), weekAndMonth.get("weekEnd"));
        String mauKey = RedisKeyUtil.getMAUKey(weekAndMonth.get("monthStart"), weekAndMonth.get("monthEnd"));
        redisTemplate.opsForValue().setBit(dauKey, userId, true);
        redisTemplate.opsForValue().setBit(wauKey, userId, true);
        redisTemplate.opsForValue().setBit(mauKey, userId, true);
    }

    @Override
    public List<UserActiveResponse> queryUserAU(LocalDateTime dateTime) {
        List<UserActiveResponse> userAu = new ArrayList<>();
        Map<String, String> weekAndMonth = getWeekAndMonth(dateTime);
        String dauKey = RedisKeyUtil.getDAUKey(dateTime);
        String wauKey = RedisKeyUtil.getWAUKey(weekAndMonth.get("weekStart"), weekAndMonth.get("weekEnd"));
        String mauKey = RedisKeyUtil.getMAUKey(weekAndMonth.get("monthStart"), weekAndMonth.get("monthEnd"));
        Long dau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(dauKey.getBytes()));
        Long wau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(wauKey.getBytes()));
        Long mau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(mauKey.getBytes()));
        Long tnu = queryUserTNU();
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
    public void recordUserCU(Long userId, Integer onlineFlag) {
        SysUser sysUser = sysUserService.getById(userId);
        String nacuKey = RedisKeyUtil.getNACUKey();
        String nncuKey = RedisKeyUtil.getNNCUKey();
        if (onlineFlag == 1) {
            // 用户上线
            redisTemplate.opsForValue().setBit(nacuKey, userId, true);
            // 判断是否是新用户
            if (LocalDate.now().toString().equals(sysUser.getCreatedTime().toString())) {
                redisTemplate.opsForValue().setBit(nncuKey, userId, true);
            }
        } else {
            // 用户下线
            redisTemplate.opsForValue().setBit(nacuKey, userId, false);
            if (LocalDate.now().toString().equals(sysUser.getCreatedTime().toString())) {
                redisTemplate.opsForValue().setBit(nncuKey, userId, false);
            }
        }
    }

    @Override
    public List<UserConcurrentResponse> queryUserCU() {
        List<UserConcurrentResponse> userCu = new ArrayList<>();
        String nacuKey = RedisKeyUtil.getNACUKey();
        String nncuKey = RedisKeyUtil.getNNCUKey();
        Long nacu = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(nacuKey.getBytes()));
        Long nncu = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(nncuKey.getBytes()));
        UserConcurrentResponse nacuResponse = new UserConcurrentResponse();
        UserConcurrentResponse nncuResponse = new UserConcurrentResponse();
        nacuResponse.setId("nacu");
        nacuResponse.setNum(nacu);
        nncuResponse.setId("nncu");
        nncuResponse.setNum(nncu);
        userCu.add(nacuResponse);
        userCu.add(nncuResponse);
        return userCu;
    }

    @Override
    public List<UserRetainedResponse> queryUserRU(LocalDateTime dateTime) {
        List<UserRetainedResponse> userRetention = new ArrayList<>();
        // 1.获取七天前用户留存数
        String wnruKey = RedisKeyUtil.getWNRUKey(dateTime);

        Long wnru = redisTemplate.execute((RedisCallback<Long>) redisConnection -> {
            redisConnection.bitOp(RedisStringCommands.BitOperation.AND,
                    wnruKey.getBytes(),
                    RedisKeyUtil.getNNUTKey(dateTime.minusDays(7)).getBytes(),
                    RedisKeyUtil.getDAUKey(dateTime).getBytes());
            return redisConnection.bitCount(wnruKey.getBytes());
        });

        // 2.获取七天前用户留存率
        // 2.1 获取七天前新注册的用户数
        Long nnut = queryUserNNUT(dateTime.minusDays(7));
        // 2.2 计算七天前用户留存率
        double wurr = Double.parseDouble(String.format("%.2f", wnru.doubleValue() / nnut.doubleValue()));

        // 3.获取一个月前用户留存数
        String mnruKey = RedisKeyUtil.getMNRUKey(dateTime);
        Long mnru = redisTemplate.execute((RedisCallback<Long>) redisConnection -> {
            redisConnection.bitOp(RedisStringCommands.BitOperation.AND,
                    mnruKey.getBytes(),
                    RedisKeyUtil.getNNUTKey(dateTime.minusMonths(1)).getBytes(),
                    RedisKeyUtil.getDAUKey(dateTime).getBytes());
            return redisConnection.bitCount(mnruKey.getBytes());
        });

        // 4.获取一个月前用户留存率
        // 4.1 获取一个月前新注册的用户数
        nnut = queryUserNNUT(dateTime.minusMonths(1));
        // 4.2 计算一个月前用户留存率
        double murr = Double.parseDouble(String.format("%.2f", mnru.doubleValue() / nnut.doubleValue()));

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


    /**
     * 根据当日日期获得所在周和月的起始和结束日期
     *
     * @param dateTime 当日日期
     * @return 日所在周和月的起始日期和结束日期
     */
    private Map<String, String> getWeekAndMonth(LocalDateTime dateTime) {
        Map<String, String> map = new HashMap<>();
        String[] split = dateTime.toString().split("-");
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
