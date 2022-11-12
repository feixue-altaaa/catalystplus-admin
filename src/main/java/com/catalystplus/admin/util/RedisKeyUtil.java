package com.catalystplus.admin.util;

public final class RedisKeyUtil {
    private static final String SPLIT = ":";
    private static final String PREFIX_DATA_NNUT = "data:nnut";
    private static final String PREFIX_DATA_DAU = "data:dau";
    private static final String PREFIX_DATA_WAU = "data:wau";
    private static final String PREFIX_DATA_MAU = "data:mau";

    public static String getNNUTKey(String dateKey) {
        return PREFIX_DATA_NNUT + SPLIT + dateKey;
    }

    public static String getDAUKey(String dateKey) {
        return PREFIX_DATA_DAU + SPLIT + dateKey;
    }

    public static String getWAUKey(String weekStart, String weekEnd) {
        return PREFIX_DATA_WAU + SPLIT + weekStart + SPLIT + weekEnd;
    }

    public static String getMAUKey(String monthStart, String monthEnd) {
        return PREFIX_DATA_MAU + SPLIT + monthStart + SPLIT + monthEnd;
    }


}
