package com.catalystplus.admin.controller.api;

import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;
import com.catalystplus.admin.vo.journal.ModifyPublisherVo;
import com.catalystplus.admin.vo.journal.ModifySubjectVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/10/23 18:54
 * @Version 1.1
 */
@Api(value = "JournalApi", tags = "主题下的期刊接口")
@RequestMapping("/admin")
public interface JournalApi {

    @PostMapping("/auth/journal")
    @ApiOperation("通过主题ID查找期刊")
    Response<List<JournalResponse>> getJournalBySubjectId(@RequestBody JournalBySubjectIdVo journalBySubjectIdVo);


    @PutMapping("/auth/modify/journal/subject")
    @ApiOperation("修改期刊关联的主题")
    Response<Void> updateJournalBySubjectId(@RequestBody ModifySubjectVo modifySubjectVo);

    @PutMapping("/auth/modify/journal/publisher")
    @ApiOperation("修改期刊关联的主题")
    Response<Void> updateJournalByPublisherId(@RequestBody ModifyPublisherVo modifyPublisherVo);

    @PostMapping("/auth/journal/page")
    @ApiOperation("通过主题ID查找期刊")
    Response<List<JournalResponse>> getJournal(@RequestBody JournalBySubjectIdVo journalBySubjectIdVo);

    @PostMapping("/auth/journal/journal_name")
    @ApiOperation("通过期刊名称查找期刊")
    Response<JournalResponse> getJournalByJournalName(@RequestBody JournalByJournalNameVo journalByJournalNameVo);
}
