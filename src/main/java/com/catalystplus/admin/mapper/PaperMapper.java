package com.catalystplus.admin.mapper;

import com.catalystplus.admin.entity.Paper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author lanran
 * @description 针对表【paper0(文献详细表)】的数据库操作Mapper
 * @createDate 2022-11-04 13:15:12
 * @Entity com.catalystplus.admin.entity.Paper
 */

public interface PaperMapper extends BaseMapper<Paper> {

    @Select("SELECT COUNT(*) from paper")
    Long getpaperTotal();

    @Select("SELECT COUNT(*) from paper0 WHERE TO_DAYS(NOW()) - TO_DAYS(created_time) <= 1")
    Long getTodayPaperTotal();


    @Select("SELECT COUNT(*) from paper0 where journal_id in " +
            "(SELECT journal_id from subject_journal where subject_id in " +
            "(SELECT subject_id from `subject` WHERE area_id = #{areaId} GROUP BY subject_id))")
    Long getPaperTotalByArea(Long areaId);


    @Select("SELECT COUNT(*) from paper0 where journal_id in " +
            "(SELECT journal_id from subject_journal where subject_id in " +
            "(SELECT subject_id from `subject` WHERE area_id = #{areaId} GROUP BY subject_id))" +
            "and TO_DAYS(NOW()) - TO_DAYS(created_time) <= 1")
    Long getTodayPaperTotalByArea(Long areaId);

    @Select("SELECT COUNT(*) from paper where journal_id IN " +
            "(SELECT journal_id from subject_journal where subject_id = #{subjectId}) " +
            "and TO_DAYS(NOW()) - TO_DAYS(created_time) <= 1")
    Long getTodayPaperTotalBySubject(Long subjectId);

    @Select("SELECT COUNT(*) from paper where journal_id IN " +
            "(SELECT journal_id from subject_journal where subject_id = #{subjectId})")
    Long getPaperTotalBySubject(Long subjectId);

}




