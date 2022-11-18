package com.catalystplus.admin.controller.api;

import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.subject.SubjectResponse;
import com.catalystplus.admin.vo.journal.SubjectBySubjectNameVo;
import com.catalystplus.admin.vo.subject.SubjectByAreaIdVo;
import com.catalystplus.admin.vo.subject.SubjectPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 15:44
 * @Version 1.1
 */
@Api(value = "SubjectApi", tags = "领域下的主题接口")
@RequestMapping("/admin")
public interface SubjectApi {

    @PostMapping("/auth/subject")
    @ApiOperation("通过领域ID查找主题")
    Response<List<SubjectResponse>> getSubjectByAreaId(@RequestBody SubjectByAreaIdVo subjectByAreaIdVo);


    @PutMapping("/auth/modify/subject_area")
    @ApiOperation("通过领域ID查找主题")
    Response<Void> updateSubjectByAreaId(
            @RequestParam Long subjectId,
            @RequestParam Long areaId
    );

    @PostMapping("/auth/subject/page")
    @ApiOperation("通过领域ID查找主题")
    Response<List<SubjectResponse>> getSubject(@RequestBody SubjectPageVo subjectPageVo);

    @PostMapping("/auth/subject/name")
    @ApiOperation("通过主题名称查找主题详细信息")
    Response<SubjectResponse> getSubjectBySubjectName(@RequestBody SubjectBySubjectNameVo subjectBySubjectNameVo);

}
