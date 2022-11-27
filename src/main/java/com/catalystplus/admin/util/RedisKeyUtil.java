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

    // 获取今日新增本科生数的key
    public static String getUserInfoNNUTKey(String dateTime) {
        return ADMIN_USER_INFO_NNUT + SPLIT + dateTime;
    }

    // 获取今日新增硕士生数的key
    public static String getUserInfoNNMTKey(String dateTime) {
        return ADMIN_USER_INFO_NNMT + SPLIT + dateTime;
    }

    // 获取今日新增博士生数的key
    public static String getUserInfoNNDTKey(String dateTime) {
        return ADMIN_USER_INFO_NNDT + SPLIT + dateTime;
    }

    // 获取今日新增老师数的key
    public static String getUserInfoNNTTKey(String dateTime) {
        return ADMIN_USER_INFO_NNTT + SPLIT + dateTime;
    }

    // 获取今日新增C9用户数的key
    public static String getUserInfoNNC9UTKey(String dateTime) {
        return ADMIN_USER_INFO_NNC9UT + SPLIT + dateTime;
    }

    // 获取今日新增985用户数的key
    public static String getUserInfoNN985UTKey(String dateTime) {
        return ADMIN_USER_INFO_NN985UT + SPLIT + dateTime;
    }

    // 获取今日新增211用户数的key
    public static String getUserInfoNN211UTKey(String dateTime) {
        return ADMIN_USER_INFO_NN211UT + SPLIT + dateTime;
    }

    // 获取今日新增一本院校用户数的key
    public static String getUserInfoNNFBUUKey(String dateTime) {
        return ADMIN_USER_INFO_NNFBUU + SPLIT + dateTime;
    }

    // 获取今日新增其他院校用户数的key
    public static String getUserInfoNNOUUTKey(String dateTime) {
        return ADMIN_USER_INFO_NNOUUT + SPLIT + dateTime;
    }

}
