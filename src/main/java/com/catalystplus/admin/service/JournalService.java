package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.Journal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import com.catalystplus.admin.vo.journal.ModifyJournalVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【journal(期刊信息表)】的数据库操作Service
 * @createDate 2022-10-24 10:39:49
 */
public interface JournalService extends IService<Journal> {

    List<Journal> getJournalBySubjectId(long subjectId, int pageNo, int pageSize);

    void updateJournalByPublisherId(long journalId, long publisherId);

    void updateJournal(ModifyJournalVo modifyJournalVo);

    Journal getJournalByJournalName(String journalName);

    List<Journal> getJournalByFuzzyQuery(JournalByJournalNameVo journalByJournalNameVo);

    Long getJournalTotal();

    Long getTodayJournalTotal();

    Long getTodayJournalTotalByArea(Long areaId);

    Long getJournalTotalByArea(Long areaId);

    Long getJournalTotalBySubject(Long subjectId);

    Long getTodayJournalTotalBySubject(Long subjectId);

    List<Journal> getJournalByJournalIds(List<Long> journalIds);

}
