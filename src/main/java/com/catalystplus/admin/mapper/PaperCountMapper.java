package com.catalystplus.admin.mapper;

import com.catalystplus.admin.entity.Paper;
import com.catalystplus.admin.entity.PaperCount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 文献总量计数 Mapper 接口
 * </p>
 *
 * @author qls
 * @since 2022-11-25
 */
public interface PaperCountMapper extends BaseMapper<PaperCount> {

//    @Select("insert into paper_count (type,area_id,subject_id,paper_total,journal_total,today_journal,today_paper) " +
//            "VALUES (#{type},#{areaId},)")
//    Void insertPaperCount(Long type,Long areaId,Long subjectId,Long paperTotal,Long todayJournal,Long todayPaper);

    @Select("SELECT * FROM `paper_count` WHERE type = 3 ORDER BY created_time desc limit 1")
    PaperCount getTotalPaperJournal();

    @Select("SELECT *  FROM paper_count WHERE type = 1 AND area_id = #{areaId} ORDER BY created_time desc limit 1")
    PaperCount getTotalPaperJournalByArea(Long areaId);

    @Select("SELECT * from paper_count WHERE type = 2 AND area_id = #{areaId} AND subject_id = #{subjectId} " +
            "ORDER BY created_time desc LIMIT 1")
    PaperCount getTotalPaperJournalBySubject(Long areaId, Long subjectId);

//    @Select("INSERT INTO paper_count (type,journal_total,paper_total,today_journal,today_paper) " +
//            "VALUES (1,#{journalTotal},#{paperTotal},#{todayJournal},#{todayPaper})")
//    void insertPaperCount(Long journalTotal,Long paperTotal,Long todayJournal,Long todayPaper);
//
//    @Select("INSERT INTO paper_count (type,area_id,journal_total,paper_total,today_journal,today_paper) " +
//            "VALUES (#{journalTotal},#{paperTotal},#{todayJournal},#{todayPaper})")
//    void insertPaperCountByArea(Long areaId,Long journalTotal,Long paperTotal,Long todayJournal,Long todayPaper);



}
