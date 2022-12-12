package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserConcurrentResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;

import java.util.List;

public interface UserActiveManager {

    // 获取全部用户数量
    Long getTotalNumberOfUsers();

    // 记录今日新增用户（使用Bitmap）
    void recordNewUsersToday(Long userId, String createdTime);

    // 获取今日新增用户数量
    Long getNewUsersToday(String dateTime);

    // 记录用户活跃信息（使用Bitmap）
    void recordActiveUsersInfo(Long userId, String loginTime);

    // 获取用户活跃信息
    List<UserActiveResponse> getActiveUsersInfo(String dateTime);

    // 记录用户在线情况
    void recordConcurrentUsersInfo(Long userId, Integer onlineFlag);

    // 获取用户在线信息
    List<UserConcurrentResponse> getConcurrentUsersInfo();

    // 获取用户留存信息
    List<UserRetainedResponse> getRetainedUsersInfo(String dateTime);

}
