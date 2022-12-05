package com.catalystplus.admin.controller;


import com.catalystplus.admin.controller.api.RankApi;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.vo.rank.RankVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class RankController implements RankApi {

    @Override
    public Response<List<PaperResponse>> getTopPaper(RankVo rankVo) {

        //1. 参数校验
//        log.info();
//        if()

        return null;
    }

    @Override
    public Response<List<JournalResponse>> getTopJournal(RankVo rankVo) {
        return null;
    }
}
