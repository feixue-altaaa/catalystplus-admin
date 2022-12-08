package com.catalystplus.admin.controller;

import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.vo.rank.RankVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class RankControllerTest {


    @Autowired
    RankController rankController;


    @Test
    void getTopPaper() {

        RankVo rankVo = new RankVo();
        rankVo.setCategoryOfRanking(AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);

        rankController.getTopPaper(rankVo);

    }

    @Test
    void getTopJournal() {

        RankVo rankVo = new RankVo();
        rankVo.setCategoryOfRanking(AdminRankConstant.ADMIN_RANK_TOTAL_SUBSCRIPTION);

        Response<List<JournalResponse>> topJournal = rankController.getTopJournal(rankVo);
        topJournal.getData().forEach(System.out::println);
    }
}