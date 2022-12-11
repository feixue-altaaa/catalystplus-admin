package com.catalystplus.admin.constant;

/**
 * 用户数据有关的常量
 */
public final class AdminUserConstant {

    // TODO: 2022/11/24 所有data改成admin 
    // TODO: 2022/11/24 常量类不是用接口，用静态终类变量 
    // TODO: 2022/11/24 常量里面写上注释 

    /**
     * C9院校
     */
    public static final String[] LIST_C9 = {};

    /**
     * 985院校
     */
    public static final String[] LIST_985 = {};

    /**
     * 211院校
     */
    public static final String[] LIST_211 = {};

    /**
     * 冒号分隔符
     */
    public static final String SPLIT = ":";

    /**
     * 今日新增用户数
     */
    public static final String ADMIN_USER_ACTIVE_NNUT = "admin:user:active:nnut";

    /**
     * 日活跃用户数
     */
    public static final String ADMIN_USER_ACTIVE_DAU = "admin:user:active:dau";

    /**
     * 周活跃用户数
     */
    public static final String ADMIN_USER_ACTIVE_WAU = "admin:user:active:wau";

    /**
     * 月活跃用户数
     */
    public static final String ADMIN_USER_ACTIVE_MAU = "admin:user:active:mau";

    /**
     * 同时在线活跃用户数
     */
    public static final String ADMIN_USER_ACTIVE_NACU = "admin:user:active:nacu";

    /**
     * 同时在线新用户数
     */
    public static final String ADMIN_USER_ACTIVE_NNCU = "admin:user:active:nncu";

    /**
     * 七天前用户留存数
     */
    public static final String ADMIN_USER_ACTIVE_WNRU = "admin:user:active:wnru";

    /**
     * 一个月前用户留存数
     */
    public static final String ADMIN_USER_ACTIVE_MNRU = "admin:user:active:mnru";


    /**
     * 用户信息
     */
    public static final String ADMIN_USER_INFO = "admin:user:info";


    /**
     * 今日期刊订阅用户数
     */
    public static final String ADMIN_USER_TODAY_SUBSCRIPTION = "admin:user:today:subscription";

    /**
     * 今日阅读文章用户总数
     */
    public static final String ADMIN_USER_TODAY_READ = "admin:user:today:read";

    /**
     * 今日文章收藏用户总数
     */
    public static final String ADMIN_USER_TODAY_COLLECT = "admin:user:today:collect";

    /**
     * 今日打标签用户总数
     */
    public static final String ADMIN_USER_TODAY_TAG = "admin:user:today:tag";

    /**
     * 今日做笔记用户总数
     */
    public static final String ADMIN_USER_TODAY_NOTE = "admin:user:today:note";

    /**
     * 今日文章总点赞用户热度
     */
    public static final String ADMIN_USER_TODAY_GOOD = "admin:user:today:good";
}
