package com.catalystplus.admin.controller.api;


import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.paperCount.PaperCountResponse;
import com.catalystplus.admin.vo.paperCount.PaperCountVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "PaperCountApi",tags = "获取文章期刊数量接口")
@RequestMapping("/admin")
public interface PaperCountApi {

    @PostMapping("/auto/paper_count/total")
    @ApiOperation("获取文章期刊总数")
    Response<PaperCountResponse> getpaperJournalCount(@RequestBody PaperCountVo paperCountVo);

    @PostMapping("/auto/paper_count/area")
    @ApiOperation("根据领域划分获取文章期刊总数")
    Response<List<PaperCountResponse>> getPaperJournalCountByArea(@RequestBody PaperCountVo paperCountVo);

    @PostMapping("/auto/paper_count/subject")
    @ApiOperation("根据主题划分获取文章期刊总数")
    Response<List<PaperCountResponse>> getPaperJournalCountBySubject(@RequestBody PaperCountVo paperCountVo);

}
