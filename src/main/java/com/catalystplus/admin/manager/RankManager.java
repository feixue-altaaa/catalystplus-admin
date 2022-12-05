package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.vo.rank.RankVo;

import java.util.List;

public interface RankManager {

    void updateJournalTotal(String type,Long number,String key);

    void updatePaperTotal(String type,Long number,String key);

    void updateRankTodayTop();

    void updateRankTotalTop();

    void updateMySQLPaperCountToday();

    void updateMySQLJournalCountToday();

    void updateMySQLPaperCountTotal();

    void updateMySQLJournalCountTotal();

    List<PaperResponse> getTopPaper(RankVo rankVo);

    List<JournalResponse> getTopJournal(RankVo rankVo);
}
