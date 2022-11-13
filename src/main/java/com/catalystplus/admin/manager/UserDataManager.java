package com.catalystplus.admin.manager;

import java.util.Map;

/**
 * 统计用户数据的所有业务操作接口
 */
public interface UserDataManager {

    // 获取TNU
    Long getTNU();

    // 获取NNUT
    Long getNNUT(String dateKey);

    // 统计NNUT
    void recordNNUT(String dateKey, Integer userId);

    Map<String, Object> getDWMAU(String dateKey);

    void recordDWMAU(String dateKey, Integer userId);

    void recordNNACU(Integer userId, Integer status);

    Long getNACU();

    Long getNNCU();
}
