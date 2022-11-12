package com.catalystplus.admin.controller.api;


import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.user.UserDataResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "UserApi", tags = "用户数据统计接口")
@RequestMapping("/admin")
public interface UserApi {

    @GetMapping("/auth/user/tun")
    @ApiOperation("查询所有的用户数")
    Response<UserDataResponse> getTNU();

    @PostMapping("/auth/user/nnut")
    @ApiOperation("查询今日新增的用户数")
    Response<UserDataResponse> getNNUT(String dateKey);

    @PostMapping("/auth/user/au")
    @ApiOperation("查询日周月用户活跃数")
    Response<UserDataResponse> getDWMAU(String dateKey);

}
