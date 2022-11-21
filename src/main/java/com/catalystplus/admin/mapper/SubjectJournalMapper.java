package com.catalystplus.admin.mapper;

import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.entity.SubjectJournal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【subject_journal(主题与期刊关联表)】的数据库操作Mapper
 * @createDate 2022-11-04 13:15:30
 * @Entity com.catalystplus.admin.entity.SubjectJournal
 */
public interface SubjectJournalMapper extends BaseMapper<SubjectJournal> {

    @Select("select journal_id from subject_journal where subject_id = #{subjectId}")
    List<Long> getJournalIdBySubjectId(Long subjectId);

    @Select("select * from subject_journal where journal_id = #{journalId}")
    List<SubjectJournal> getSubjectJournalByJournalId(Long journalId);

    @Select("select subject_id from subject_journal where journal_id = #{journalId} group by journal_id")
    Long getSubjectIdByJournalId(Long journalId);
}




