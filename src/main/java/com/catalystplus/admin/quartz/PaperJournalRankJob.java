package com.catalystplus.admin.quartz;


import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.manager.RankManager;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class PaperJournalRankJob {

    @Autowired
    RankManager rankManager;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 每天凌晨更新Redis中期刊、文章总量信息
     */
    @Scheduled(cron = "0 50 15 ? * *")
    public void updatePaperAndJournalTotal(){


        //更新数据库中文章、期刊截至今日阅读等总量
        log.info("开始执行定时任务");
        rankManager.updateMySQLPaperCountTotal();
        rankManager.updateMySQLJournalCountTotal();

        //更新Redis文章收藏、打标签、做笔记、点赞总量、期刊订阅总量
        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);
        rankManager.updatePaperTotal(AdminRankConstant.TAG_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_TAG);
        rankManager.updatePaperTotal(AdminRankConstant.NOTE_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_NOTE);
        rankManager.updatePaperTotal(AdminRankConstant.GOOD_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_GOOD);
        rankManager.updateJournalTotal
                (AdminRankConstant.SUBSCRIPTION_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_SUBSCRIPTION);

        //清空Redis中今日新增部分
        rankManager.redisFlush();

        //更新数据库中rank_top表
        rankManager.updateRankTotalTop();

    }

    /**
     * 每三个小时根据Redis更新数据库中rank_paper、rank_journal表
     */
    @Scheduled(cron = "0 0 0/3 * * ?")
    public void updateRankPaperAndJournalToday(){

        //更新Mysql中rank_paper表
        rankManager.updateMySQLPaperCountToday();

        //更新Mysql中rank_journal表
        rankManager.updateMySQLJournalCountToday();

        //更新Mysql中rank_top表
        rankManager.updateRankTodayTop();
    }

}
