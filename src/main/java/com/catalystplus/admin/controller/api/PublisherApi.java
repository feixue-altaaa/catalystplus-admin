package com.catalystplus.admin.controller.api;

import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.publisher.PublisherResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
