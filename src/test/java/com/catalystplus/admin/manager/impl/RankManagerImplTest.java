package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.Paper;
import com.catalystplus.admin.manager.RankManager;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.service.PaperService;
import com.catalystplus.admin.service.RankJournalService;
import com.catalystplus.admin.service.RankPaperService;
import com.catalystplus.admin.util.RedisUtil;
import com.catalystplus.admin.vo.rank.RankVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RankManagerImplTest {

    @Autowired
    RankManager rankManager;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    RankPaperService rankPaperService;
    @Autowired
    PaperService paperService;
    @Autowired
    RankJournalService rankJournalService;

    @Test
    void updateJournalTotal() {


        //1
//        rankManager.updateJournalTotal(AdminRankConstant.SUBSCRIPTION_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TOTAL_SUBSCRIPTION);

//        redisUtil.flushDB(AdminRankConstant.ADMIN_RANK_COLLECT_TOTAL);
    }

    @Test
    void updatePaperTotal() {

//        List<Long> topTotal = rankPaperService.getTopTotal(AdminRankConstant.COLLECT_TOTAL, 10L);
//        topTotal.forEach(System.out::println);
//
//        List<Paper> papers = paperService.getPapersByIds(topTotal);
//
//        papers.forEach(System.out::println);

        //没问题
        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);
        rankManager.updatePaperTotal(AdminRankConstant.GOOD_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TOTAL_GOOD);

    }

    @Test
    void updateRankTodayTop() {

        //没问题
        rankManager.updateRankTodayTop();

    }

    @Test
    void updateRankTotalTop(){

        rankManager.updateRankTotalTop();
    }

    @Test
    void updateMySQLPaperCountToday() {

        //没问题
        rankManager.updateMySQLPaperCountToday();
    }

    @Test
    void updateMySQLPaperCountTotal(){

        //没问题
        rankManager.updateMySQLPaperCountTotal();
    }



    @Test
    void getTopPaper() {


        //获取今日新增没问题
        RankVo rankVo = new RankVo();
        rankVo.setCategoryOfRanking(AdminRankConstant.ADMIN_RANK_TODAY_COLLECT);
        List<PaperResponse> topPaper = rankManager.getTopPaper(rankVo);
        topPaper.forEach(System.out::println);


        //获取截至今日没问题

//        RankVo rankVo = new RankVo();
//        rankVo.setCategoryOfRanking(AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);
//
//        List<PaperResponse> topPaper = rankManager.getTopPaper(rankVo);
//        topPaper.forEach(System.out::println);

//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        if(list.contains("hello")){
//            System.out.println("hhhhhhhhhh");
//        }



    }

    @Test
    void getTopJournal() {
    }
}