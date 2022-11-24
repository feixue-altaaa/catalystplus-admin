package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.entity.Area;
import com.catalystplus.admin.entity.Publisher;
import com.catalystplus.admin.manager.AreaManager;
import com.catalystplus.admin.manager.PublisherManager;
import com.catalystplus.admin.response.area.AreaResponse;
import com.catalystplus.admin.response.publisher.PublisherResponse;
import com.catalystplus.admin.service.AreaService;
import com.catalystplus.admin.service.PublisherService;
import com.catalystplus.admin.vo.journal.PublisherByPublisherNameVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 18:53
 * @Version 1.1
 */
@Slf4j
@Service
public class PublisherManagerImpl implements PublisherManager {


    @Autowired
    PublisherService publisherService;


    @Override
    public List<PublisherResponse> getPublisher() {

        List<Publisher> publishers = publisherService.list();
        log.info("publishers: {}", publishers);
        List<PublisherResponse> publisherResponses = Lists.newArrayList();
        publishers.forEach(area -> {
            PublisherResponse publisherResponse = new PublisherResponse();
            BeanUtils.copyProperties(area, publisherResponse);
            publisherResponses.add(publisherResponse);
        });

        return publisherResponses;
    }

    @Override
    public PublisherResponse getPublisherByPublisherName(PublisherByPublisherNameVo publisherByPublisherNameVo) {

        //1. 初始化
        PublisherResponse publisherResponse = new PublisherResponse();

        //2. 通过出版者名称获取其详细信息
        Publisher publisherByPublisherName = publisherService.getPublisherByPublisherName(publisherByPublisherNameVo.getPublisherName());

        //3. 组装响应
        BeanUtils.copyProperties(publisherByPublisherName, publisherResponse);

        return publisherResponse;

    }
}
