package com.catalystplus.admin.controller.api;


import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserConcurrentResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;
import com.catalystplus.admin.vo.user.UserByDateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "UserApi", tags = "用户数据统计接口")
@RequestMapping("/admin")
public interface UserApi {

    // TODO: 2022/11/24 每个指标用的什么技术方案，开一个子文档，写清楚

    @GetMapping("/auth/user/tnu")
    @ApiOperation("获取截至今日用户总数")
    Response<Long> queryTotalNumberOfUsers();

    @PostMapping("/auth/user/nnut")
    @ApiOperation("获取今日新增用户数")
    Response<Long> queryNumberOfNewUsers(@RequestBody UserByDateVo userByDateVo);

    @PostMapping("/auth/user/au")
    @ApiOperation("获取今日活跃用户数、日活占比、本周活跃用户数、周活占比、本月活跃用户数、月活占比")
    Response<List<UserActiveResponse>> queryActiveUsersInfo(@RequestBody UserByDateVo userByDateVo);

    @GetMapping("/auth/user/cu")
    @ApiOperation("获取同时在线活跃用户数、同时在线新用户数")
    Response<List<UserConcurrentResponse>> queryConcurrentUsersInfo();

    @PostMapping("/auth/user/ru")
    @ApiOperation("获取七天前用户留存数、七天前用户留存率、一个月前用户留存数、一个月前用户留存率")
    Response<List<UserRetainedResponse>> queryRetainedUsersInfo(@RequestBody UserByDateVo userByDateVo);



}
