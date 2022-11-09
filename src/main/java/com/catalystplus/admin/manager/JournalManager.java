package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;
import com.catalystplus.admin.vo.journal.ModifyPublisherVo;
import com.catalystplus.admin.vo.journal.ModifySubjectVo;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/10/24 10:32
 * @Version 1.1
 */

public interface JournalManager {

    List<JournalResponse> getJournalBySubjectId(JournalBySubjectIdVo journalBySubjectIdVo);

    void updateJournalBySubjectId(ModifySubjectVo modifySubjectVo);

    void updateJournalByPublisherId(ModifyPublisherVo modifyPublisherVo);

    List<JournalResponse> getJournal(JournalBySubjectIdVo journalBySubjectIdVo);

    JournalResponse getJournalByJournalName(JournalByJournalNameVo journalByJournalNameVo);

}
