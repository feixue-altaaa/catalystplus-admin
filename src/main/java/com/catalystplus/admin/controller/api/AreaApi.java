package com.catalystplus.admin.controller.api;

import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.area.AreaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 15:44
 * @Version 1.1
 */
@Api(value = "AreaApi", tags = "领域接口")
@RequestMapping("/admin")
public interface AreaApi {

    @GetMapping("/auth/area")
    @ApiOperation("查询所有领域18个")
    Response<List<AreaResponse>> getArea();

}
