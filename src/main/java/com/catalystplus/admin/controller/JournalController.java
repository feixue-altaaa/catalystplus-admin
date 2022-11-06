package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.JournalApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.JournalManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.ResponseCode;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;
import com.catalystplus.admin.vo.journal.ModifyPublisherVo;
import com.catalystplus.admin.vo.journal.ModifySubjectVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.*;

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
            return Response.fail(journalBySubjectIdVo.getUserId(), ResponseCode.JOURNAL_SUBJECTID_ERROR.getCode(), ResponseCode.JOURNAL_SUBJECTID_ERROR.getMsg());
        }
        PAGE_NO.set(journalBySubjectIdVo.getPageNo());
        PAGE_SIZE.set(journalBySubjectIdVo.getPageSize());
        List<JournalResponse> journalResponses;

        //2. 通过主题ID查询期刊
        try {
            journalResponses = journalManager.getJournalBySubjectId(journalBySubjectIdVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(journalBySubjectIdVo.getUserId(), e.getMessage());
        }

        return Response.success(journalBySubjectIdVo.getUserId(), journalResponses);
    }

    @Override
    public Response<Void> updateJournalBySubjectId(ModifySubjectVo modifySubjectVo) {

        //1. 参数验证
        log.info("modifySubjectVo: {}", modifySubjectVo);
        if (Assert.notEmpty(modifySubjectVo.getJournalId())) {
            return Response.fail(null, ResponseCode.JOURNAL_SUBSCRIBE_ERROR.getCode(), ResponseCode.JOURNAL_SUBSCRIBE_ERROR.getMsg());
        }

        //2. 通过主题ID或者出版商ID修改期刊关联
        try {
            journalManager.updateJournalBySubjectId(modifySubjectVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }

        return Response.success(null, null);
    }

    @Override
    public Response<Void> updateJournalByPublisherId(ModifyPublisherVo modifyPublisherVo) {

        //1. 参数验证
        log.info("modifyPublisherVo: {}", modifyPublisherVo);
        if (Assert.notEmpty(modifyPublisherVo.getJournalId())) {
            return Response.fail(null, ResponseCode.JOURNAL_SUBSCRIBE_ERROR.getCode(), ResponseCode.JOURNAL_SUBSCRIBE_ERROR.getMsg());
        }

        //2. 通过主题ID或者出版商ID修改期刊关联
        try {
            journalManager.updateJournalByPublisherId(modifyPublisherVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }

        return Response.success(null, null);
    }

    @Override
    public Response<List<JournalResponse>> getJournal(JournalBySubjectIdVo journalBySubjectIdVo) {

        //1. 参数验证
        log.info("journalBySubjectIdVo: {}", journalBySubjectIdVo);

        PAGE_NO.set(journalBySubjectIdVo.getPageNo());
        PAGE_SIZE.set(journalBySubjectIdVo.getPageSize());
        List<JournalResponse> journalResponses;

        //2. 通过主题ID查询期刊
        try {
            journalResponses = journalManager.getJournal(journalBySubjectIdVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(journalBySubjectIdVo.getUserId(), e.getMessage());
        }

        return Response.success(journalBySubjectIdVo.getUserId(), journalResponses);
    }

    @Override
    public Response<JournalResponse> getJournalByJournalName(JournalByJournalNameVo journalByJournalNameVo) {

        //1. 参数验证
        log.info("journalByJournalNameVo: {}", journalByJournalNameVo);
        if (Assert.notEmpty(journalByJournalNameVo.getJournalName())) {
            return Response.fail(journalByJournalNameVo.getUserId(), ResponseCode.JOURNALNAME_ERROR.getCode(), ResponseCode.JOURNALNAME_ERROR.getMsg());
        }
        JournalResponse journalResponse;

        //2. 通过journalName查询journal
        try {
            journalResponse = journalManager.getJournalByJournalName(journalByJournalNameVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(journalByJournalNameVo.getUserId(),e.getMessage());
        }

        return Response.success(journalByJournalNameVo.getUserId(),journalResponse);
    }
}
