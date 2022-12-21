package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.entity.UserInfo;
import com.catalystplus.admin.entity.UserInfoEducation;
import com.catalystplus.admin.entity.UserInfoUniversity;
import com.catalystplus.admin.manager.UserInfoManager;
import com.catalystplus.admin.mapper.UserInfoMapper;
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
import java.util.*;

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

    // 记录用户今日新增的所有信息
    // 记录用户今天新增的数目信息 对redis中的 job discipline major 以及学校类别 计数进行 +1
    @Override
    public void recordNewUsersInfoToday(Long userId, String dateTime) {
        SysUser sysUser = sysUserService.getById(userId);
        // 获取用户的学历，用英文表示，比如undergraduate、master、doctor
        String job = sysUser.getJob();
        // 获取用户的学校信息
        String institution = sysUser.getInstitution();
        // 获取用户的学科编号
        String discipline = sysUser.getDiscipline();
        // 获取用户的专业编号
        String major = sysUser.getMajor();

        // 保存用户信息数据的redis的哈希键
        String key = RedisKeyUtil.getUserInfoKey(dateTime);

        // 对redis中的 job discipline major 以及学校类别 计数进行 +1

        // 记录用户的学历信息
        redisUtil.hashValueIncrement(key, job);
        // 记录用户的学科信息
        redisUtil.hashValueIncrement(key, discipline);
        // 记录用户的专业信息
        redisUtil.hashValueIncrement(key, major);

        // 判断用户学校的类型，比如C9、985、211、其他
        String institutionKey;
        if (Arrays.asList(LIST_C9).contains(institution)) {
            institutionKey = UNIVERSITY_TYPE[0];
        } else if (Arrays.asList(LIST_985).contains(institution)) {
            institutionKey = UNIVERSITY_TYPE[1];
        } else if (Arrays.asList(LIST_211).contains(institution)) {
            institutionKey = UNIVERSITY_TYPE[2];
        } else {
            institutionKey = UNIVERSITY_TYPE[3];
        }
        // 记录用户的学校信息
        redisUtil.hashValueIncrement(key, institutionKey);
    }

    // 按学历划分获取用户信息
    @Override
    public List<UserInfoResponse> getUsersInfoByEducation(String dateTime) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();
        //获取昨日日期
        String lastDate = getLastDate(dateTime);
        // 获取记录用户信息的redis哈希键
        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);

        for (int i = 0; i < EDUCATION.length; i++) {
            UserInfoResponse userInfoResponse = new UserInfoResponse();
            userInfoResponse.setId(EDUCATION[i]);
            // 今日新增数量
            Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, EDUCATION[i]);
            userInfoResponse.setAddNumber(addNumber);
            // 今日总数量 = 今日新增 + 昨日总数量
            userInfoResponse.setTotalNumber(addNumber + getTotalNumByEducationAndDate(EDUCATION[i], lastDate));
            userInfoResponses.add(userInfoResponse);
        }

        return userInfoResponses;
    }

    // 按学校划分获取用户信息
    @Override
    public List<UserInfoResponse> getUsersInfoByUniversity(String dateTime) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();
        //获取昨日日期
        String lastDate = getLastDate(dateTime);
        // 获取记录用户信息的redis哈希键
        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);

        for (int i = 0; i < 4; i++) {
            UserInfoResponse userInfoResponse = new UserInfoResponse();
            userInfoResponse.setId(UNIVERSITY_TYPE[i]);
            // 今日新增数量
            Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, UNIVERSITY_TYPE[i]);
            userInfoResponse.setAddNumber(addNumber);
            // 今日总数量 = 今日新增 + 昨日总数量
            userInfoResponse.setTotalNumber(addNumber + getTotalNumByUniversityAndDate(UNIVERSITY_TYPE[i], lastDate));
            userInfoResponses.add(userInfoResponse);
        }

        return userInfoResponses;
    }

    @Override
    public Map<String, Object> getUsersInfoByDiscipline(String dateTime) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();
        //获取昨日日期
        String lastDate = getLastDate(dateTime);
        // 获取记录用户信息的redis哈希键
        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);
        long totalMax = 0L;
        long addMax = 0L;
        for (int i = 0; i < 14; i++) {
            UserInfoResponse userInfoResponse = new UserInfoResponse();
            userInfoResponse.setId(DISCIPLINE[i]);
            // 今日新增数量
//                  test                                           admin:user:info:2022-12-19  01
            Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, DISCIPLINE_CODE[i]);
            addMax = Math.max(addMax, addNumber);
            userInfoResponse.setAddNumber(addNumber);
            // 今日总数量 = 今日新增 + 昨日总数量
            Integer todaySumNumber = addNumber + getTotalNumByDisciplineAndDate(DISCIPLINE_CODE[i], lastDate);
            userInfoResponse.setTotalNumber(todaySumNumber);
            totalMax = Math.max(totalMax, todaySumNumber);
            userInfoResponses.add(userInfoResponse);
        }
        Map<String, Object> re = new HashMap<>();
        re.put("userInfoResponses", userInfoResponses);
        re.put("addNumberMax", addMax);
        re.put("totalMax", totalMax);
        return re;
    }

    @Override
    public List<UserInfoResponse> getUsersInfoByMajor(String dateTime) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();
        //获取昨日日期
        String lastDate = getLastDate(dateTime);
        // 获取记录用户信息的redis哈希键
        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);
        for (String s : MAJOR_CODE) {
            UserInfoResponse userInfoResponse = new UserInfoResponse();
            userInfoResponse.setId(s);
            // 今日新增数量
            Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, s);
            userInfoResponse.setAddNumber(addNumber);
            // 今日总数量 = 今日新增 + 昨日总数量
            userInfoResponse.setTotalNumber(addNumber + getTotalNumByDisciplineAndDate(s, lastDate));
            userInfoResponses.add(userInfoResponse);
        }

        return userInfoResponses;
    }

    @Override
    public List<UserInfoResponse> getUsersInfoByMajorByPage(String dateTime, int startIndex, int endIndex) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();
        //获取昨日日期
        String lastDate = getLastDate(dateTime);
        // 获取记录用户信息的redis哈希键
        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);
        for (int i = startIndex; i < endIndex; i++) {
            UserInfoResponse userInfoResponse = new UserInfoResponse();
            // 获取对应Major的编号
            userInfoResponse.setId(MAJOR_CODE.get(i));
            // 今日新增数量
            Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, MAJOR_CODE.get(i));
            userInfoResponse.setAddNumber(addNumber);
            // 今日总数量 = 今日新增 + 昨日总数量
            userInfoResponse.setTotalNumber(addNumber + getTotalNumByDisciplineAndDate(MAJOR_CODE.get(i), lastDate));
            userInfoResponses.add(userInfoResponse);
        }

        return userInfoResponses;
    }

    /**
     * 获取所有专业中总人数的最大值
     * @param dateTime
     * @return
     */
    @Override
    public Long getMaxNumberInfoByMajor(String dateTime) {
        long res = 0L;
        //获取昨日日期
        String lastDate = getLastDate(dateTime);
        // 获取记录用户信息的redis哈希键
        String userInfoKey = RedisKeyUtil.getUserInfoKey(dateTime);
        for (String s : MAJOR_CODE) {
            // 获取该专业的今日总人数
            // 该专业今日新增人数
            Integer addNumber = (Integer) redisUtil.getHashValue(userInfoKey, s);
            int totalNumber = addNumber + getTotalNumByMajorAndDate(s, lastDate);
            res = Math.max(res, totalNumber);
        }
        return res;
    }


    // 获取昨日的日期
    private String getLastDate(String dateTime) {
        String[] split = dateTime.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return LocalDate.of(year, month, day).minusDays(1).toString();
    }

    private Integer getTotalNumByEducationAndDate(String education, String dateTime) {
//        MyBatisPlus操作的方法
        QueryWrapper<UserInfoEducation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", dateTime).eq("education", education);
        return Math.toIntExact(userInfoEducationService.getOne(queryWrapper).getTotalNumber());
    }

    private Integer getTotalNumByUniversityAndDate(String university, String dateTime) {
        QueryWrapper<UserInfoUniversity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", dateTime).eq("university", university);
        return Math.toIntExact(userInfoUniversityService.getOne(queryWrapper).getTotalNumber());
    }

    private Integer getTotalNumByDisciplineAndDate(String discipline, String dateTime) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        log.info(dateTime + " " + discipline);
        queryWrapper.eq("date_time", dateTime).eq("discipline", discipline);
        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        int sum = 0;
        for (UserInfo userInfo : userInfos) {
            sum += Math.toIntExact(userInfo.getTotalNumber());
        }
        log.info("The Sum is : " + sum + " ");
        return sum;
    }

    private Integer getTotalNumByMajorAndDate(String major, String dateTime) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_time", dateTime).eq("major", major);
        return Math.toIntExact(userInfoMapper.selectOne(queryWrapper).getTotalNumber());
    }
}
