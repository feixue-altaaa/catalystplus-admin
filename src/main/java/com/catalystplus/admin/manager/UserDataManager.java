package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.user.AUResponse;
import com.catalystplus.admin.vo.user.AUByDateVo;

import java.util.List;

/**
 * 统计用户数据的所有业务操作接口
 */
public interface UserDataManager {

    // 获取TNU
    Long getTNU();

    // 获取NNUT
    Long getNNUT(AUByDateVo auByDateVo);

    // 统计NNUT
    void recordNNUT(String dateKey, Integer userId);

    List<AUResponse> getDWMAU(AUByDateVo auByDateVo);

    void recordDWMAU(String dateKey, Integer userId);

    void recordNNACU(Integer userId, Integer status);

    Long getNACU();

    Long getNNCU();
}
