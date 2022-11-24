package com.catalystplus.admin.controller.api;


import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.user.AUResponse;
import com.catalystplus.admin.vo.user.AUByDateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "UserApi", tags = "用户数据统计接口")
@RequestMapping("/admin")
public interface UserApi {

    // TODO: 2022/11/24 每个指标用的什么技术方案，开一个子文档，写清楚

    @GetMapping("/auth/user/tun")
    @ApiOperation("查询所有的用户数")
    Response<Long> getTNU();

    @PostMapping("/auth/user/nnut")
    @ApiOperation("查询今日新增的用户数")
    Response<Long> getNNUT(@RequestBody AUByDateVo auByDateVo);

    @PostMapping("/auth/user/au")
    @ApiOperation("查询日周月用户活跃数，日周月活占比")
    Response<List<AUResponse>> getDWMAU(@RequestBody AUByDateVo auByDateVo);

    @GetMapping("/auth/user/nacu")
    @ApiOperation("查询同时在线活跃用户数")
    Response<Long> getNACU();

    @GetMapping("/auth/user/nncu")
    @ApiOperation("查询同时在线新用户数")
    Response<Long> getNNCU();

}
