package com.catalystplus.admin.util;

import static com.catalystplus.admin.constant.AdminUserConstant.*;

/**
 * 用于生成redis的key的工具类
 */
public final class RedisKeyUtil {

    // 获取今日新增用户的key(比如：admin:active:nnut:2022-11-22)
    public static String getUserActiveNNUTKey(String dateTime) {
        return ADMIN_USER_ACTIVE_NNUT + SPLIT + dateTime;
    }

    // 获取日活跃用户数的key(比如：admin:active:dau:2022-11-22)
    public static String getUserActiveDAUKey(String dateTime) {
        return ADMIN_USER_ACTIVE_DAU + SPLIT + dateTime;
    }

    // 获取周活跃用户数的key(比如：admin:active:wau:2022-11-21:2022-11-27)
    public static String getUserActiveWAUKey(String weekStartDate, String weekEndDate) {
        return ADMIN_USER_ACTIVE_WAU + SPLIT + weekStartDate + SPLIT + weekEndDate;
    }

    // 获取月活跃用户数的key(比如：admin:active:mau:2022-11-01:2022-11-30)
    public static String getUserActiveMAUKey(String monthStartDate, String monthEndDate) {
        return ADMIN_USER_ACTIVE_MAU + SPLIT + monthStartDate + SPLIT + monthEndDate;
    }

    // 获取同时在线活跃用户数的key
    public static String getUserActiveNACUKey() {
        return ADMIN_USER_ACTIVE_NACU;
    }

    // 获取同时在线新用户的key
    public static String getUserActiveNNCUKey() {
        return ADMIN_USER_ACTIVE_NNCU;
    }

    // 获取七天前用户留存数的key(比如：admin:active:wnru:2022-11-22)
    public static String getUserActiveWNRUKey(String dateTime) {
        return  ADMIN_USER_ACTIVE_WNRU + SPLIT + dateTime;
    }

    // 获取一个月前用户留存数的key(比如：admin:active:mnru:2022-11-22)
    public static String getUserActiveMNRUKey(String dateTime) {
        return  ADMIN_USER_ACTIVE_MNRU + SPLIT + dateTime;
    }

    public static String getUserInfoKey(String dateTime) {
        return  ADMIN_USER_INFO + SPLIT + dateTime;
//        admin:user:info:2022-12-19
    }

}
