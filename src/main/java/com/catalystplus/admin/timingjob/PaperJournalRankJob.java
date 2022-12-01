package com.catalystplus.admin.timingjob;


import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.manager.RankManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
public class PaperJournalRankJob {

    @Autowired
    RankManager rankManager;

    @Scheduled(cron = "0 42 17 ? * *")
    public void updateJournal(){

        //更新期刊订阅总量
        rankManager.updateJournalTotal
                (AdminRankConstant.SUBSCRIPTION_TOTAL,10L,AdminRankConstant.ADMIN_RANK_SUBSCRIPTION_TOTAL);
    }


    @Scheduled(cron = "0 42 17 ? * *")
    public void updatePaper(){

        //更新文章收藏、打标签、做笔记、点赞总量
        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,10L,AdminRankConstant.ADMIN_RANK_COLLECT_TOTAL);
        rankManager.updatePaperTotal(AdminRankConstant.TAG_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TAG_TOTAL);
        rankManager.updatePaperTotal(AdminRankConstant.NOTE_TOTAL,10L,AdminRankConstant.ADMIN_RANK_NOTE_TOTAL);
        rankManager.updatePaperTotal(AdminRankConstant.GOOD_TOTAL,10L,AdminRankConstant.ADMIN_RANK_GOOD_TOTAL);
    }

}
