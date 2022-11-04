package com.catalystplus.admin.controller.api;

import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;
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


    @PutMapping("/auth/modify/journal/subject_publisher")
    @ApiOperation("修改期刊关联的主题")
    Response<Void> updateJournalBySidOrPid(
            @RequestParam Long journalId,
            @RequestParam Long subjectId,
            @RequestParam Long publisherId
    );


    @PostMapping("/auth/journal/page")
    @ApiOperation("通过主题ID查找期刊")
    Response<List<JournalResponse>> getJournal(@RequestBody JournalBySubjectIdVo journalBySubjectIdVo);


}
