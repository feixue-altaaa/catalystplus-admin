package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.RankTop;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lanran
* @description 针对表【rank_top_ten(后台文章期刊十大排行表)】的数据库操作Service
* @createDate 2022-12-01 10:00:55
*/
public interface RankTopService extends IService<RankTop> {

    void deleteByType(Long type);

    List<Long> getTypeIdByCategory(String category,Long number);

}
