package com.catalystplus.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.entity.Journal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【journal(期刊信息表)】的数据库操作Mapper
 * @createDate 2022-10-24 10:39:49
 * @Entity com.catalystplus.admin.entity.Journal
 */
public interface JournalMapper extends BaseMapper<Journal> {


    /* publisher不用再xml文件定义，可以直接返回到Journal实体类，里面添加一个同名字段就可以, publisher_id可以加索引
    explain SELECT j.*, pub.name AS publisher, s.ch_name AS subjectName FROM journal j
    LEFT JOIN publisher pub ON pub.id = j.publisher_id
    LEFT JOIN subject s ON s.id = j.subject_id
    WHERE j.subject_id = 643
    */
//    @Select({"SELECT j.*, pub.name AS publisher, s.ch_name AS subjectName FROM journal j",
//            "LEFT JOIN publisher pub ON pub.id = j.publisher_id",
//            "LEFT JOIN subject s ON s.id = j.subject_id",
//            "WHERE j.subject_id = #{subjectId}"})
    @Select({"SELECT j.*, s.subject_id AS sid, pub.name AS publisher, s.ch_name AS subjectName FROM journal j",
            "LEFT JOIN publisher pub ON pub.id = j.publisher_id",
            "JOIN subject_journal sj ON sj.journal_id = j.journal_id",
            "JOIN subject s ON s.subject_id = j.subject_id",
            "WHERE sj.subject_id = #{subjectId}",
            "GROUP BY j.journal_id"})
    Page<Journal> getJournalBySubjectId(Page<Journal> page, Long subjectId);


    /**
     * 返回具有相同journalID的journal
     * @param journalId
     * @return
     */
    @Select({
            "SELECT * from journal where journal_id = #{journalId}"
            })
    List<Journal> getJournalByJournalId(Long journalId);

    @Select("SELECT COUNT(*) from (SELECT * from journal GROUP BY journal_id) as j")
    Long getJournalTotal();

    @Select("SELECT COUNT(*) from (SELECT * FROM journal WHERE TO_DAYS(NOW()) - TO_DAYS(created_time) <= 1) as j")
    Long getTodayJournalTotal();

    @Select("SELECT COUNT(*) FROM journal where journal_id IN " +
            "(SELECT journal_id from subject_journal WHERE subject_id in " +
            "(SELECT subject_id from `subject` WHERE area_id = #{areaId} GROUP BY subject_id))")
    Long getTodayJournalTotalByArea(Long areaId);

    @Select("SELECT COUNT(*) FROM journal where journal_id IN " +
            "(SELECT journal_id from subject_journal WHERE subject_id in " +
            "(SELECT subject_id from `subject` WHERE area_id = #{areaId} GROUP BY subject_id))" +
            "and TO_DAYS(NOW()) - TO_DAYS(created_time) <= 1")
    Long getJournalTotalByArea(Long areaId);

    @Select("SELECT COUNT(*) from journal where journal_id IN " +
            "(SELECT journal_id from subject_journal where subject_id = #{subjectId})")
    Long getJournalTotalBySubject(Long subjectId);

    @Select("SELECT COUNT(*) from journal where journal_id IN " +
            "(SELECT journal_id from subject_journal where subject_id = #{subjectId}) " +
            "and TO_DAYS(NOW()) - TO_DAYS(created_time) <= 1")
    Long getTodayJournalTotalBySubject(Long subjectId);

}




