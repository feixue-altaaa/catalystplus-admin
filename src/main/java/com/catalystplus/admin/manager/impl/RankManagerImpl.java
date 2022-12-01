package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.entity.Paper;
import com.catalystplus.admin.manager.RankManager;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.service.PaperService;
import com.catalystplus.admin.service.RankJournalService;
import com.catalystplus.admin.service.RankPaperService;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class RankManagerImpl implements RankManager {

    @Autowired
    RankPaperService rankPaperService;
    @Autowired
    RankJournalService rankJournalService;
    @Autowired
    JournalService journalService;
    @Autowired
    PaperService paperService;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public void updateJournalTotal(String type,Long number,String key) {

        //1. 获取截至今日TOP期刊
        List<Long> subscriptionTotal = rankJournalService.getTopJournal(type, number);

        //2. 根据期刊ID从数据库中查询其详细信息
        List<Journal> journals = journalService.getBaseMapper().selectBatchIds(subscriptionTotal);

        //3. 更新Redis中期刊总量
        journals.forEach(journal -> {
            log.info("开始更新Redis中期刊订阅总量");
            redisUtil.set(key,journal);
        });

    }

    @Override
    public void updatePaperTotal(String type,Long number,String key) {

        //1. 获取排行文章ID
        List<Long> paperIds = rankPaperService.getTopTotal(type, number);

        //2. 根据文章ID获取其详细信息
        List<Paper> papers = paperService.getBaseMapper().selectBatchIds(paperIds);

        //3. 更新Redis中文章总量
        papers.forEach(paper -> {
           log.info("");
           redisUtil.set(key,paper);
        });

    }

}
