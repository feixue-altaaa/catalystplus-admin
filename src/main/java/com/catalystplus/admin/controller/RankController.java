package com.catalystplus.admin.controller;


import com.catalystplus.admin.controller.api.RankApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.RankManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.ResponseCode;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.vo.rank.RankVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class RankController implements RankApi {

    @Autowired
    RankManager rankManager;

    @Override
    public Response<List<PaperResponse>> getTopPaper(RankVo rankVo) {

        //1. 参数校验
        log.info("rankVo :{}",rankVo);
        if(Assert.notEmpty(rankVo.getCategoryOfRanking())){
            return Response.fail(rankVo.getUserId(), ResponseCode.CATEGORY_RANK_ERROR.getCode(),ResponseCode.CATEGORY_RANK_ERROR.getMsg());
        }
        List<PaperResponse> paperResponses = new ArrayList<>();

        //2. 根据收藏等排名获取文章
        try {
            paperResponses = rankManager.getTopPaper(rankVo);
            log.info("获取paper");
            paperResponses.forEach(System.out::println);
        } catch (Exception e) {
            return Response.fail(rankVo.getUserId(),e.getMessage());
        }

        return Response.success(rankVo.getUserId(),paperResponses);
    }

    @Override
    public Response<List<JournalResponse>> getTopJournal(RankVo rankVo) {

        //1. 参数校验
        log.info("rankVo :{}",rankVo);
        if(Assert.notEmpty(rankVo.getCategoryOfRanking())){
            return Response.fail(rankVo.getUserId(), ResponseCode.CATEGORY_RANK_ERROR.getCode(),ResponseCode.CATEGORY_RANK_ERROR.getMsg());
        }
        List<JournalResponse> journalResponses = new ArrayList<>();

        //2. 根据收藏等排名获取文章、期刊
        try {
            journalResponses = rankManager.getTopJournal(rankVo);
        } catch (Exception e) {
            return Response.fail(rankVo.getUserId(),e.getMessage());
        }

        return Response.success(rankVo.getUserId(),journalResponses);
    }
}
