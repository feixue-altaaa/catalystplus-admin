package com.catalystplus.admin.controller.api;


import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.vo.rank.RankVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
@Api(value = "RankApi" ,tags = "文章期刊统计排行接口")
public interface RankApi {

    @PostMapping("/auth/rank/paper")
    @ApiOperation("获取文章排行")
    Response<List<PaperResponse>> getTopPaper(@RequestBody RankVo rankVo);

    @PostMapping("/auth/rank/journal")
    @ApiOperation("获取期刊排行")
    Response<List<JournalResponse>> getTopJournal(@RequestBody RankVo rankVo);

}
