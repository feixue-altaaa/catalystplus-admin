package com.catalystplus.admin.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.catalystplus.admin.constant.AdminUserConstant.*;

/**
 * 用于生成redis的key的工具类
 */
public final class RedisKeyUtil {

    /**
     * 获取统计今日新增用户数的key
     * @param localDateTime 当日日期
     * @return
     */
    public static String getNNUTKey(LocalDateTime localDateTime) {
        return PREFIX_ADMIN_NNUT + SPLIT + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取统计日活跃用户数的key
     * @param localDateTime 当日日期
     */
    public static String getDAUKey(LocalDateTime localDateTime) {
        return PREFIX_ADMIN_DAU + SPLIT + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取统计周活跃用户数的key
     * @param weekStart 周起始日期
     * @param weekEnd 周结束日期
     */
    public static String getWAUKey(LocalDateTime weekStart, LocalDateTime weekEnd) {
        return PREFIX_ADMIN_WAU + SPLIT + weekStart.format(DateTimeFormatter.ISO_LOCAL_DATE) + SPLIT + weekEnd.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取统计月活跃用户数的key
     * @param monthStart 月起始日期
     * @param monthEnd 月结束日期
     */
    public static String getMAUKey(LocalDateTime monthStart, LocalDateTime monthEnd) {
        return PREFIX_ADMIN_MAU + SPLIT + monthStart.format(DateTimeFormatter.ISO_LOCAL_DATE) + SPLIT + monthEnd.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取统计同时在线活跃用户数的key
     */
    public static String getNACUKey() {
        return PREFIX_ADMIN_NACU;
    }

    /**
     * 获取统计同时在线新用户数的key
     */
    public static String getNNCUKey() {
        return PREFIX_ADMIN_NNCU;
    }

    /**
     * 获取统计七天前用户的留存数的key
     * @param localDateTime 当日日期
     */
    public static String getWNRUKey(LocalDateTime localDateTime) {
        return  PREFIX_ADMIN_WNRU + SPLIT + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取统计一个月前用户的留存数的key
     * @param localDateTime 当日日期
     */
    public static String getMNRUKey(LocalDateTime localDateTime) {
        return  PREFIX_ADMIN_MNRU + SPLIT + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
