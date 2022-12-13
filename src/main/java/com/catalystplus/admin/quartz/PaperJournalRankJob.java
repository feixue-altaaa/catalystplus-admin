package com.catalystplus.admin.quartz;


import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.TotalCount;
import com.catalystplus.admin.manager.RankManager;
import com.catalystplus.admin.manager.TotalCountManager;
import com.catalystplus.admin.response.totalCount.TotalCountResponse;
import com.catalystplus.admin.response.totalCount.TotalResponse;
import com.catalystplus.admin.service.TotalCountService;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;

@Slf4j
@Component
public class PaperJournalRankJob {

    @Autowired
    RankManager rankManager;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountManager totalCountManager;
    @Autowired
    TotalCountService totalCountService;

    /**
     * 每天凌晨更新Redis中期刊、文章总量信息
     */
    @Scheduled(cron = "0 55 23 ? * *")
    public void updatePaperAndJournalTotal(){


        //更新数据库中文章、期刊截至今日阅读等总量
        log.info("开始执行定时任务");
        rankManager.updateMySQLPaperCountTotal();
        rankManager.updateMySQLJournalCountTotal();

        //更新Redis文章收藏、打标签、做笔记、点赞总量、期刊订阅总量
        rankManager.updatePaperTotal(AdminRankConstant.READ_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_READ);
        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);
        rankManager.updatePaperTotal(AdminRankConstant.TAG_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_TAG);
        rankManager.updatePaperTotal(AdminRankConstant.NOTE_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_NOTE);
        rankManager.updatePaperTotal(AdminRankConstant.GOOD_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_GOOD);
        rankManager.updateJournalTotal
                (AdminRankConstant.SUBSCRIPTION_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_SUBSCRIPTION);

        //清空Redis中今日新增部分
//        rankManager.redisFlush();

        //更新数据库中rank_top表
        rankManager.updateRankTotalTop();

        //清空Redis中admin:user:today下所有key
        redisUtil.deleteBatch("admin:user:today");

        //total_count重新插入一条
        TotalCount todayTotalCount = new TotalCount();
        TotalCount oldTotalCount = totalCountService.getByDate();
        TotalResponse totalResponse = new TotalResponse();
        BeanUtils.copyProperties(oldTotalCount,totalResponse);
        BeanUtils.copyProperties(totalResponse,todayTotalCount);
        todayTotalCount.setDateTime(totalCountService.tomorrowDateStr());

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
