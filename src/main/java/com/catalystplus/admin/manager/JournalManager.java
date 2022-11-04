package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/10/24 10:32
 * @Version 1.1
 */

public interface JournalManager {

    List<JournalResponse> getJournalBySubjectId(JournalBySubjectIdVo journalBySubjectIdVo);

    void updateJournalBySidOrPid(Long journalId, Long subjectId, Long publisherId);

    List<JournalResponse> getJournal(JournalBySubjectIdVo journalBySubjectIdVo);
}
