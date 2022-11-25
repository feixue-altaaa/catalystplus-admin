package com.catalystplus.admin.constant;

/**
 * 用户数据有关的常量
 */
public class AdminUserConstant {

    // TODO: 2022/11/24 所有data改成admin 
    // TODO: 2022/11/24 常量类不是用接口，用静态终类变量 
    // TODO: 2022/11/24 常量里面写上注释 

    /**
     * 分隔符
     */
    public static final String SPLIT = ":";

    /**
     * 统计今日新增用户数的redis键前缀
     */
    public static final String PREFIX_ADMIN_NNUT = "admin:nnut";

    /**
     * 统计日活跃用户数的redis键前缀
     */
    public static final String PREFIX_ADMIN_DAU = "admin:dau";

    /**
     * 统计周活跃用户数的redis键前缀
     */
    public static final String PREFIX_ADMIN_WAU = "admin:wau";

    /**
     * 统计月活跃用户数的redis键前缀
     */
    public static final String PREFIX_ADMIN_MAU = "admin:mau";

    /**
     * 统计同时在线活跃用户数的redis键前缀
     */
    public static final String PREFIX_ADMIN_NACU = "admin:nacu";

    /**
     * 统计同时在线新用户数的redis键前缀
     */
    public static final String PREFIX_ADMIN_NNCU = "admin:nncu";

    /**
     * 统计七天前用户留存数的redis键前缀
     */
    public static final String PREFIX_ADMIN_WNRU = "admin:wnru";

    /**
     * 统计一个月前用户留存数的redis键前缀
     */
    public static final String PREFIX_ADMIN_MNRU = "admin:mnru";

}
