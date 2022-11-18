package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.journal.JournalSimpleResponse;
import com.catalystplus.admin.vo.journal.*;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/10/24 10:32
 * @Version 1.1
 */

public interface JournalManager {

    List<JournalSimpleResponse> getJournalBySubjectId(JournalBySubjectIdVo journalBySubjectIdVo);

    void updateJournalBySubjectId(ModifySubjectVo modifySubjectVo);

    void updateJournalByPublisherId(ModifyPublisherVo modifyPublisherVo);

    void updateJournal(ModifyJournalVo modifyJournalVo);

    List<JournalResponse> getJournal(JournalBySubjectIdVo journalBySubjectIdVo);

    JournalResponse getJournalByJournalName(JournalByJournalNameVo journalByJournalNameVo);

    List<JournalSimpleResponse> getJournalByFuzzyQuery(JournalByJournalNameVo journalByJournalNameVo);
}
