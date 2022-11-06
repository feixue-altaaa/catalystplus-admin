package com.catalystplus.admin.controller.api;

import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.publisher.PublisherResponse;
import com.catalystplus.admin.vo.journal.PublisherByPublisherNameVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 15:44
 * @Version 1.1
 */
@Api(value = "PublisherApi", tags = "出版商接口")
@RequestMapping("/admin")
public interface PublisherApi {

    @GetMapping("/auth/publisher")
    @ApiOperation("获取所有的出版商")
    Response<List<PublisherResponse>> getPublisher();

    @PostMapping("/auth/publisher/name")
    @ApiOperation("通过出版者名称获取其详细信息")
    Response<PublisherResponse> getJournalByJournalName(@RequestBody PublisherByPublisherNameVo publisherByPublisherNameVo);


}
