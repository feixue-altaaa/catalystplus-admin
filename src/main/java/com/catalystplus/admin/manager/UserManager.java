package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserConcurrentResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface UserManager {

    /**
     *
     * @return 获取截至今日用户总数
     */
    Long getTotalNumberOfUsers();

    /**
     * 记录今日新增用户数
     * @param userId 新注册用户id
     * @param createdTime 注册时间
     */
    void recordNewUsersToday(Long userId, LocalDateTime createdTime);

    /**
     * 根据日期获取今日新增用户数
     * @param dateTime 日期
     */
    Long getNewUsersToday(String dateTime);

    /**
     * 记录日活跃用户数、周活跃用户数、月活跃用户数、日活占比、周活占比、月活占比
     * @param userId 登录用户id
     * @param loginTime 登录时间
     */
    void recordActiveUsersInfo(Long userId, LocalDateTime loginTime);

    /**
     * 根据日期获取日活跃用户数、周活跃用户数、月活跃用户数、日活占比、周活占比、月活占比
     * @param dateTime 日期
     */
    List<UserActiveResponse> getActiveUsersInfo(String dateTime);

    /**
     * 记录用户（或者新用户）的在线情况
     * @param userId 用户id
     * @param onlineFlag 在线标志位（0：下线，1：在线）
     */
    void recordConcurrentUsersInfo(Long userId, Integer onlineFlag);

    /**
     * 获取同时在线用户（或者新用户）数
     */
    List<UserConcurrentResponse> getConcurrentUsersInfo();

    /**
     * 根据日期获取七天前用户留存数、七天前用户留存率、一个月前用户留存数、一个月前用户留存率
     * @param dateTime 日期
     */
    List<UserRetainedResponse> getRetainedUsersInfo(String dateTime);

}
