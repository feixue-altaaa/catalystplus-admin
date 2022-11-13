package com.catalystplus.admin.util;

import static com.catalystplus.admin.constant.Constant.*;

public final class RedisKeyUtil {

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

    public static String getNACUKey() {
        return PREFIX_DATA_NACU;
    }

    public static String getNNCUKey() {
        return PREFIX_DATA_NNCU;
    }


}
