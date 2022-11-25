package com.catalystplus.admin.controller;


import com.catalystplus.admin.controller.api.PaperCountApi;
import com.catalystplus.admin.manager.PaperCountManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.paperCount.PaperCountResponse;
import com.catalystplus.admin.vo.paperCount.PaperCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class PaperCountController implements PaperCountApi {

    @Autowired
    PaperCountManager paperCountManager;


    @Override
    public Response<PaperCountResponse> getpaperJournalCount(PaperCountVo paperCountVo) {
        PaperCountResponse paperCount = paperCountManager.getPaperCount();

        return Response.success(paperCountVo.getUserId(),paperCount);
    }

    @Override
    public Response<List<PaperCountResponse>> getPaperJournalCountByArea(PaperCountVo paperCountVo) {
        List<PaperCountResponse> paperCountByArea = paperCountManager.getPaperCountByArea();

        return Response.success(paperCountVo.getUserId(),paperCountByArea);
    }

    @Override
    public Response<List<PaperCountResponse>> getPaperJournalCountBySubject(PaperCountVo paperCountVo) {

        List<PaperCountResponse> paperCountBySubject = paperCountManager.getPaperCountBySubject(paperCountVo.getAreaId());
        return Response.success(paperCountVo.getAreaId(),paperCountBySubject);
    }
}
