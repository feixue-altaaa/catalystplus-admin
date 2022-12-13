package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.SummaryApi;
import com.catalystplus.admin.manager.TotalCountManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.totalCount.TotalCountResponse;
import com.catalystplus.admin.vo.summary.SummaryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
public class SummaryController implements SummaryApi {

    @Autowired
    TotalCountManager totalCountManager;

    @Override
    public Response<Map<String, Map>> getPaperJournalSummary(SummaryVo summaryVo) {
        //1. 初始化
//        List<Map> totalCount = new ArrayList<>();
        Map<String,Map> totalCount = new HashMap<>();

        //2. 获取期刊文章浏览汇总信息
        try {
            totalCount = totalCountManager.getByDate();
        } catch (Exception e) {
            return Response.fail(summaryVo.getUserId(),e.getMessage());
        }

        return Response.success(summaryVo.getUserId(),totalCount);
    }
}
