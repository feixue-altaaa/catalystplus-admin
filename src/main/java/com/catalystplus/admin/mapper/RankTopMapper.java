package com.catalystplus.admin.mapper;

import com.catalystplus.admin.entity.RankTop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
* @author lanran
* @description 针对表【rank_top_ten(后台文章期刊十大排行表)】的数据库操作Mapper
* @createDate 2022-12-01 10:00:55
* @Entity com.catalystplus.admin.entity.RankTopTen
*/
public interface RankTopMapper extends BaseMapper<RankTop> {

    @Select("DELETE FROM `rank_top` WHERE type = #{type}")
    void deleteByType(Long type);

}




