package com.catalystplus.admin.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.Paper;
import com.catalystplus.admin.manager.RankManager;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.service.PaperService;
import com.catalystplus.admin.service.RankJournalService;
import com.catalystplus.admin.service.RankPaperService;
import com.catalystplus.admin.util.JsonUtils;
import com.catalystplus.admin.util.RedisUtil;
import com.catalystplus.admin.vo.rank.RankVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Slf4j
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
        rankManager.updateJournalTotal(AdminRankConstant.SUBSCRIPTION_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TOTAL_SUBSCRIPTION);

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
//        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);
//        rankManager.updatePaperTotal(AdminRankConstant.GOOD_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TOTAL_GOOD);
        rankManager.updatePaperTotal(AdminRankConstant.READ_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TOTAL_READ);
        rankManager.updatePaperTotal(AdminRankConstant.NOTE_TOTAL,10l,AdminRankConstant.ADMIN_RANK_TOTAL_NOTE);
        rankManager.updatePaperTotal(AdminRankConstant.TAG_TOTAL,10l,AdminRankConstant.ADMIN_RANK_TOTAL_TAG);

    }

    @Test
    void updateRankTodayTop() {

        //没问题
        rankManager.updateRankTodayTop();

    }


    @Test
    void updateRankTotalTop(){

        rankManager.updateRankTotalTop();

//        Set<ZSetOperations.TypedTuple<Object>> paperIdAndScore = redisUtil.get
//                (AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT, AdminRankConstant.rankStart, AdminRankConstant.rankNumber - 1);
//        Iterator<ZSetOperations.TypedTuple<Object>> iteratorpaperIdAndScore = paperIdAndScore.iterator();
//        while (iteratorpaperIdAndScore.hasNext()){
//            ZSetOperations.TypedTuple<Object> next = iteratorpaperIdAndScore.next();
////            System.out.println(next.getValue().toString());
////            PaperResponse paperResponse = JsonUtils.jsonToPojo(next.getValue().toString(), PaperResponse.class);
//            PaperResponse paperResponse = JSON.parseObject(JSON.parse(next.getValue().toString()).toString(), PaperResponse.class);
//            log.info("开始获取paper响应");
//            System.out.println(paperResponse);
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
        rankVo.setCategoryOfRanking(AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);
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