package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.UserApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.impl.UserActiveManagerImpl;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserConcurrentResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;
import com.catalystplus.admin.vo.user.UserByDateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.catalystplus.admin.response.ResponseCode.*;


@Slf4j
@RestController
@CrossOrigin
public class UserController implements UserApi {

    @Autowired
    private UserActiveManagerImpl userManager;

    @Override
    public Response<Long> queryTotalNumberOfUsers() {
        // 1.初始化变量
        Long totalNumberOfUsers;
        // 2.查询截至今日用户总数
        try {
            totalNumberOfUsers = userManager.getTotalNumberOfUsers();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }
        return Response.success(null, totalNumberOfUsers);
    }

    @Override
    public Response<Long> queryNumberOfNewUsers(UserByDateVo userByDateVo) {
        // 1.验证参数
        log.info("userByDateVo is {}", userByDateVo);
        if (Assert.notEmpty(userByDateVo.getLocalDateTime())) {
            return Response.fail(userByDateVo.getUserId(), ADMIN_USER_DATE_ERROR.getCode(), ADMIN_USER_DATE_ERROR.getMsg());
        }
        // 2.查询今日新增用户数
        Long numberOfNewUsersToday;
        try {
            numberOfNewUsersToday = userManager.getNewUsersToday(userByDateVo.getLocalDateTime());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(userByDateVo.getUserId(), e.getMessage());
        }
        return Response.success(userByDateVo.getUserId(), numberOfNewUsersToday);
    }

    @Override
    public Response<List<UserActiveResponse>> queryActiveUsersInfo(UserByDateVo userByDateVo) {
        // 1.验证参数
        log.info("userByDateVo is {}", userByDateVo);
        if (Assert.notEmpty(userByDateVo.getLocalDateTime())) {
            return Response.fail(userByDateVo.getUserId(), ADMIN_USER_DATE_ERROR.getCode(), ADMIN_USER_DATE_ERROR.getMsg());
        }
        // 2.查询用户活跃信息
        List<UserActiveResponse> userActiveResponses;
        try {
            userActiveResponses = userManager.getActiveUsersInfo(userByDateVo.getLocalDateTime());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(userByDateVo.getUserId(), e.getMessage());
        }
        return Response.success(userByDateVo.getUserId(), userActiveResponses);
    }

    @Override
    public Response<List<UserConcurrentResponse>> queryConcurrentUsersInfo() {
        // 1.初始化变量
        List<UserConcurrentResponse> userConcurrentResponses;
        // 2.查询用户在线信息
        try {
            userConcurrentResponses = userManager.getConcurrentUsersInfo();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }
        return Response.success(null, userConcurrentResponses);
    }

    @Override
    public Response<List<UserRetainedResponse>> queryRetainedUsersInfo(UserByDateVo userByDateVo) {
        // 1.验证参数
        log.info("userByDateVo is {}", userByDateVo);
        if (Assert.notEmpty(userByDateVo.getLocalDateTime())) {
            return Response.fail(userByDateVo.getUserId(), ADMIN_USER_DATE_ERROR.getCode(), ADMIN_USER_DATE_ERROR.getMsg());
        }
        // 2.查询用户留存信息
        List<UserRetainedResponse> userRetainedResponses;
        try {
            userRetainedResponses = userManager.getRetainedUsersInfo(userByDateVo.getLocalDateTime());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(userByDateVo.getUserId(), e.getMessage());
        }
        return Response.success(userByDateVo.getUserId(), userRetainedResponses);
    }
}

