package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.manager.UserDataManager;
import com.catalystplus.admin.response.user.AUResponse;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.util.RedisKeyUtil;
import com.catalystplus.admin.vo.user.AUByDateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public Long getNNUT(AUByDateVo auByDateVo) {
        String redisKey = RedisKeyUtil.getNNUTKey(auByDateVo.getDateKey());
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(redisKey.getBytes()));
    }

    @Override
    public void recordNNUT(String dateKey, Integer userId) {
        String redisKey = RedisKeyUtil.getNNUTKey(dateKey);
        redisTemplate.opsForValue().setBit(redisKey, userId, true);
    }

    @Override
    public List<AUResponse> getDWMAU(AUByDateVo auByDateVo) {
        String dauKey = RedisKeyUtil.getDAUKey(auByDateVo.getDateKey());
        Map<String, String> dateInfo = getDateInfo(auByDateVo.getDateKey());
        String wauKey = RedisKeyUtil.getWAUKey(dateInfo.get("weekStart"), dateInfo.get("weekEnd"));
        String mauKey = RedisKeyUtil.getMAUKey(dateInfo.get("monthStart"), dateInfo.get("monthEnd"));
        return getAUInfo(dauKey, wauKey, mauKey);
    }

    private List<AUResponse> getAUInfo(String dauKey, String wauKey, String mauKey) {
        Long dau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(dauKey.getBytes()));
        Long wau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(wauKey.getBytes()));
        Long mau = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(mauKey.getBytes()));
        Long tnu = getTNU();
        Double pdau = null, pwau = null, pmau = null;
        if (dau != null && wau != null && mau != null) {
            pdau = Double.parseDouble(String.format("%.2f", dau.doubleValue() / tnu.doubleValue()));
            pwau = Double.parseDouble(String.format("%.2f", wau.doubleValue() / tnu.doubleValue()));
            pmau = Double.parseDouble(String.format("%.2f", mau.doubleValue() / tnu.doubleValue()));
        }
        List<AUResponse> list = new ArrayList<>();
        AUResponse dauResponse = new AUResponse(), wauResponse = new AUResponse(), mauResponse = new AUResponse();
        dauResponse.setId("dau"); dauResponse.setNum(dau); dauResponse.setPercent(pdau);
        wauResponse.setId("wau"); wauResponse.setNum(wau); wauResponse.setPercent(pwau);
        mauResponse.setId("mau"); mauResponse.setNum(mau); mauResponse.setPercent(pmau);
        list.add(dauResponse); list.add(wauResponse); list.add(mauResponse);
        return list;
    }

    @Override
    public void recordDWMAU(String dateKey, Integer userId) {
        String dauKey = RedisKeyUtil.getDAUKey(dateKey);
        Map<String, String> dateInfo = getDateInfo(dateKey);
        String wauKey = RedisKeyUtil.getWAUKey(dateInfo.get("weekStart"), dateInfo.get("weekEnd"));
        String mauKey = RedisKeyUtil.getMAUKey(dateInfo.get("monthStart"), dateInfo.get("monthEnd"));
        // 统计
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

    private Map<String, String> getDateInfo(String dateKey) {
        // 1.获取日期的年、月、日
        String[] split = dateKey.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        // 2.构造当前日期
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate parse = LocalDate.parse(date.toString());
        // 3.根据当前日期获取所在周和所在月的起始和结束日期
        String weekStart = parse.with(DayOfWeek.MONDAY).toString();
        String weekEnd = parse.with(DayOfWeek.SUNDAY).toString();
        String monthStart = parse.with(TemporalAdjusters.firstDayOfMonth()).toString();
        String monthEnd = parse.with(TemporalAdjusters.lastDayOfMonth()).toString();
        // 4.返回结果
        Map<String, String> map = new HashMap<>();
        map.put("weekStart", weekStart);
        map.put("weekEnd", weekEnd);
        map.put("monthStart", monthStart);
        map.put("monthEnd", monthEnd);
        return map;
    }

}
