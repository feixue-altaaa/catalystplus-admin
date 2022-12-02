package com.catalystplus.admin.quartz;


import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.manager.RankManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;

@Slf4j
public class PaperJournalRankJob {

    @Autowired
    RankManager rankManager;

    /**
     * 每天凌晨更新Redis中期刊、文章总量信息
     */
    @Scheduled(cron = "0 0 0 ? * *")
    public void updatePaperAndJournalTotal(){

        //更新文章收藏、打标签、做笔记、点赞总量
        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_COLLECT_TOTAL);
        rankManager.updatePaperTotal(AdminRankConstant.TAG_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TAG_TOTAL);
        rankManager.updatePaperTotal(AdminRankConstant.NOTE_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_NOTE_TOTAL);
        rankManager.updatePaperTotal(AdminRankConstant.GOOD_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_GOOD_TOTAL);

        //更新期刊订阅总量
        rankManager.updateJournalTotal
                (AdminRankConstant.SUBSCRIPTION_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_SUBSCRIPTION_TOTAL);
    }

    /**
     * 每三个小时根据Redis更新数据库中rank_paper、rank_journal表
     */
    @Scheduled(cron = "0 0 0/3 * * ?")
    public void updateRankPaperAndJournalToday(){

        //更新Mysql中rank_paper表
        rankManager.updateMySQLPaperCount(AdminRankConstant.ADMIN_RANK_TODAY_GOOD);
        rankManager.updateMySQLPaperCount(AdminRankConstant.ADMIN_RANK_TODAY_COLLECT);
        rankManager.updateMySQLPaperCount(AdminRankConstant.ADMIN_RANK_TODAY_NOTE);
        rankManager.updateMySQLPaperCount(AdminRankConstant.ADMIN_RANK_TODAY_TAG);

        //更新Mysql中rank_journal表
        rankManager.updateMySQLJournalcount(AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION);

        //更新Mysql中rank_top表
        rankManager.updateRankTop();
    }

}
