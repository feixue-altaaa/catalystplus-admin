package com.catalystplus.admin.controller;


import com.catalystplus.admin.controller.api.PaperCountApi;
import com.catalystplus.admin.manager.PaperCountManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.paperCount.PaperCountResponse;
import com.catalystplus.admin.response.paperCount.RiseResponse;
import com.catalystplus.admin.vo.paperCount.PaperCountVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 文献总量计数 前端控制器
 * </p>
 *
 * @author qls
 * @since 2022-11-25
 */
@RestController
@CrossOrigin
@Slf4j
public class PaperCountController implements PaperCountApi {

    @Autowired
    PaperCountManager paperCountManager;


    @Override
    public Response<PaperCountResponse> getpaperJournalCount(PaperCountVo paperCountVo) {

        //1. 初始化
        PaperCountResponse paperCountResponse = new PaperCountResponse();

        //2. 获取文章期刊总数
        try {
            paperCountResponse= paperCountManager.getPaperCount();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(paperCountVo.getUserId(),e.getMessage());
        }

        return Response.success(paperCountVo.getUserId(),paperCountResponse);
    }

    @Override
    public Response<List<PaperCountResponse>> getPaperJournalCountByArea(PaperCountVo paperCountVo) {

        //1. 初始化
        List<PaperCountResponse> paperCountByArea = new ArrayList<>();

        //2. 根据领域划分获取文章期刊总数
        try {
            paperCountByArea = paperCountManager.getPaperCountByArea();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(paperCountVo.getUserId(),e.getMessage());
        }

        return Response.success(paperCountVo.getUserId(),paperCountByArea);
    }

    @Override
    public Response<List<PaperCountResponse>> getPaperJournalCountBySubject(PaperCountVo paperCountVo) {

        //1. 初始化
        List<PaperCountResponse> paperCountBySubject = new ArrayList<>();

        //2. 根据主题划分获取文章期刊总数
        try {
            paperCountBySubject = paperCountManager.getPaperCountBySubject(paperCountVo.getAreaId());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(paperCountVo.getUserId(),e.getMessage());
        }
        return Response.success(paperCountVo.getAreaId(),paperCountBySubject);
    }

    @Override
    public Response<RiseResponse> getPaperJournalRise(PaperCountVo paperCountVo) {

        //1. 初始化
        RiseResponse paperJournalRise = new RiseResponse();

        //2. 获取文章期刊新增率
        try {
            paperJournalRise = paperCountManager.getPaperJournalRise();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(paperCountVo.getUserId(),e.getMessage());
        }

        return Response.success(paperCountVo.getUserId(),paperJournalRise);
    }
}
