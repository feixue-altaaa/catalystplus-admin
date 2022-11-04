package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.SubjectApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.SubjectManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.ResponseCode;
import com.catalystplus.admin.response.subject.SubjectResponse;
import com.catalystplus.admin.vo.subject.SubjectByAreaIdVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.*;

/**
 * @Author 蓝染
 * @Date 2022/9/30 15:48
 * @Version 1.1
 */
@Slf4j
@RestController
public class SubjectController implements SubjectApi {


    @Autowired
    SubjectManager subjectManager;


    @Override
    public Response<List<SubjectResponse>> getSubjectByAreaId(SubjectByAreaIdVo subjectByAreaIdVo) {

        //1. 参数验证
        log.info("subjectByAreaIdVo: {}", subjectByAreaIdVo);
        if (Assert.notEmpty(subjectByAreaIdVo.getAreaId())) {
            return Response.fail(subjectByAreaIdVo.getUserId(), ResponseCode.SUBJECT_AREAID_ERROR.getCode(), ResponseCode.SUBJECT_AREAID_ERROR.getMsg());
        }
        PAGE_NO.set(subjectByAreaIdVo.getPageNo());
        PAGE_SIZE.set(subjectByAreaIdVo.getPageSize());
        List<SubjectResponse> subjectResponses;

        //2. 通过领域ID查询主题
        try {
            subjectResponses = subjectManager.getSubjectByAreaId(subjectByAreaIdVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(subjectByAreaIdVo.getUserId(), e.getMessage());
        }

        return Response.success(subjectByAreaIdVo.getUserId(), subjectResponses);
    }


    @Override
    public Response<Void> updateSubjectByAreaId(Long subjectId, Long areaId) {

        //1. 参数验证
        log.info("subjectId: {},  areaId: {}", subjectId, areaId);
        if (Assert.notEmpty(subjectId)) {
            return Response.fail(null, ResponseCode.SUBJECT_AREAID_ERROR.getCode(), ResponseCode.SUBJECT_AREAID_ERROR.getMsg());
        }
        if (Assert.notEmpty(areaId)) {
            return Response.fail(null, ResponseCode.SUBJECT_AREAID_ERROR.getCode(), ResponseCode.SUBJECT_AREAID_ERROR.getMsg());
        }

        //2. 通过领域ID查询主题
        try {
            subjectManager.updateSubjectByAreaId(subjectId, areaId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }

        return Response.success(null, null);
    }

    @Override
    public Response<List<SubjectResponse>> getSubject(SubjectByAreaIdVo subjectByAreaIdVo) {

        //1. 参数验证
        log.info("subjectByAreaIdVo: {}", subjectByAreaIdVo);
        PAGE_NO.set(subjectByAreaIdVo.getPageNo());
        PAGE_SIZE.set(subjectByAreaIdVo.getPageSize());
        List<SubjectResponse> subjectResponses;

        //2. 通过领域ID查询主题
        try {
            subjectResponses = subjectManager.getSubject(subjectByAreaIdVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(subjectByAreaIdVo.getUserId(), e.getMessage());
        }

        return Response.success(subjectByAreaIdVo.getUserId(), subjectResponses);
    }
}
