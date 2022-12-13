package com.catalystplus.admin.controller.api;

import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.totalCount.TotalCountResponse;
import com.catalystplus.admin.vo.summary.SummaryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Api(value = "SummaryApi" , tags = "期刊文章浏览汇总接口")
@RequestMapping("/admin")
public interface SummaryApi {

    @PostMapping("/auth/summary")
    @ApiOperation("查询期刊文章浏览汇总信息")
    Response<Map<String, Map>> getPaperJournalSummary(@RequestBody SummaryVo summaryVo);
}
