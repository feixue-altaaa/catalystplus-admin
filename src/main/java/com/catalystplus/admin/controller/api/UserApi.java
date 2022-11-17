package com.catalystplus.admin.controller.api;


import com.catalystplus.admin.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "UserApi", tags = "用户数据统计接口")
@RequestMapping("/admin")
public interface UserApi {

    @GetMapping("/auth/user/tun")
    @ApiOperation("查询所有的用户数")
    Response<Long> getTNU();

    @PostMapping("/auth/user/nnut")
    @ApiOperation("查询今日新增的用户数")
    Response<Long> getNNUT(String dateKey);

    @PostMapping("/auth/user/au")
    @ApiOperation("查询日周月用户活跃数，日周月活占比")
    Response<Map<String, Object>> getDWMAU(String dateKey);

    @GetMapping("/auth/user/nacu")
    @ApiOperation("查询同时在线活跃用户数")
    Response<Long> getNACU();

    @GetMapping("/auth/user/nncu")
    @ApiOperation("查询同时在线新用户数")
    Response<Long> getNNCU();

}
