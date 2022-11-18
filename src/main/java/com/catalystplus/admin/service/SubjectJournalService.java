package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.SubjectJournal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【subject_journal(主题与期刊关联表)】的数据库操作Service
 * @createDate 2022-11-04 13:15:30
 */
public interface SubjectJournalService extends IService<SubjectJournal> {

    void updateJournalBySubjectId(long journalId, List<Long> sourceSubjectIds,List<Long> targetSubjectIds);

}
