package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserConcurrentResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface UserManager {

    /**
     *
     * @return 截至今日用户总数
     */
    Long queryUserTNU();

    /**
     * 统计今日新增用户数
     * @param userId 新注册的用户id
     * @param createdTime 用户的注册时间
     */
    void recordUserNNUT(Long userId, LocalDateTime createdTime);

    /**
     * 根据当日日期查询今日新增用户数
     * @param dateTime 当日日期
     * @return 今日新增用户数
     */
    Long queryUserNNUT(LocalDateTime dateTime);

    /**
     * 统计日活跃数、周活跃数、月活跃数、日活跃占比、周活跃占比、月活跃占比
     * @param userId 登录用户的id
     * @param loginTime 用户的登录时间
     */
    void recordUserAU(Long userId, LocalDateTime loginTime);

    /**
     * 根据当日日期查询日活跃数、周活跃数、月活跃数、日活跃占比、周活跃占比、月活跃占比
     * @param dateTime 当日日期
     * @return 日活跃数、周活跃数、月活跃数、日活跃占比、周活跃占比、月活跃占比
     */
    List<UserActiveResponse> queryUserAU(LocalDateTime dateTime);

    /**
     * 统计同时在线活跃用户数和同时在线新用户数
     * @param userId 用户id
     * @param onlineFlag 用户在线标志
     */
    void recordUserCU(Long userId, Integer onlineFlag);

    /**
     * 查询同时在线活跃用户数和同时在线新用户数
     * @return 同时在线活跃用户数和同时在线新用户数
     */
    List<UserConcurrentResponse> queryUserCU();

    /**
     * 根据当日日期查询七天前用户留存数、留存率和一周前用户留存数和留存率
     * @param dateTime 当日日期
     * @return 七天前用户留存数、留存率和一周前用户留存数和留存率
     */
    List<UserRetainedResponse> queryUserRU(LocalDateTime dateTime);

}
