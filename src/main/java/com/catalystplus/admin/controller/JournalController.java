package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.JournalApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.JournalManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.ResponseCode;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.GLOBAL_ID;

/**
 * @Author 蓝染
 * @Date 2022/10/23 18:53
 * @Version 1.1
 */
@RestController
@Slf4j
public class JournalController implements JournalApi {

    @Autowired
    JournalManager journalManager;

    @Override
    public Response<List<JournalResponse>> getJournalBySubjectId(JournalBySubjectIdVo journalBySubjectIdVo) {

        //1. 参数验证
        log.info("journalBySubjectIdVo: {}", journalBySubjectIdVo);
        if (Assert.notEmpty(journalBySubjectIdVo.getSubjectId())) {
            return Response.fail(GLOBAL_ID.get(), journalBySubjectIdVo.getUserId(), ResponseCode.JOURNAL_SUBJECTID_ERROR.getCode(), ResponseCode.JOURNAL_SUBJECTID_ERROR.getMsg());
        }
        List<JournalResponse> journalResponses;

        //2. 通过主题ID查询期刊
        try {
            journalResponses = journalManager.getJournalBySubjectId(journalBySubjectIdVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(GLOBAL_ID.get(), journalBySubjectIdVo.getUserId(), e.getMessage());
        }

        return Response.success(GLOBAL_ID.get(), journalBySubjectIdVo.getUserId(), journalResponses);
    }

    @Override
    public Response<Void> updateJournalBySidOrPid(Long journalId, Long subjectId, Long publisherId) {

        //1. 参数验证
        log.info("journalId: {}, subjectId: {}, publisherId: {}", journalId, subjectId, publisherId);
        if (Assert.notEmpty(journalId)) {
            return Response.fail(GLOBAL_ID.get(), null, ResponseCode.JOURNAL_SUBSCRIBE_ERROR.getCode(), ResponseCode.JOURNAL_SUBSCRIBE_ERROR.getMsg());
        }

        //2. 通过主题ID或者出版商ID修改期刊关联
        try {
            journalManager.updateJournalBySidOrPid(journalId, subjectId, publisherId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(GLOBAL_ID.get(), null, e.getMessage());
        }

        return Response.success(GLOBAL_ID.get(), null, null);
    }
}
