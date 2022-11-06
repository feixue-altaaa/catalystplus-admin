package com.catalystplus.admin.controller;

import com.catalystplus.admin.config.GlobalAspect;
import com.catalystplus.admin.controller.api.PublisherApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.PublisherManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.ResponseCode;
import com.catalystplus.admin.response.publisher.PublisherResponse;
import com.catalystplus.admin.vo.journal.PublisherByPublisherNameVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 15:47
 * @Version 1.1
 */
@Slf4j
@RestController
public class PublisherController implements PublisherApi {

    @Autowired
    PublisherManager publisherManager;

    @Override
    public Response<List<PublisherResponse>> getPublisher() {

        //1. 初始化
        List<PublisherResponse> publisherResponses;

        //2. 查询几篇论文放主页
        try {
            publisherResponses = publisherManager.getPublisher();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }

        return Response.success(null, publisherResponses);
    }

    @Override
    public Response<PublisherResponse> getJournalByJournalName(PublisherByPublisherNameVo publisherByPublisherNameVo) {

        //1. 参数验证
        log.info("publisherByPublisherNameVo: {}",publisherByPublisherNameVo);
        if(Assert.notEmpty(publisherByPublisherNameVo.getPublisherName())){
            return Response.fail(publisherByPublisherNameVo.getUserId(), ResponseCode.PUBLISHERNAME_ERROR.getCode(),ResponseCode.PUBLISHERNAME_ERROR.getMsg());
        }
        PublisherResponse publisherResponse;

        //2. 通过出版者名称获取其详细信息
        try {
            publisherResponse = publisherManager.getPublisherByPublisherName(publisherByPublisherNameVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(publisherByPublisherNameVo.getUserId(),e.getMessage());
        }

        return Response.success(publisherByPublisherNameVo.getUserId(),publisherResponse);
    }

}
