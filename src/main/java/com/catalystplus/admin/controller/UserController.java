package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.UserApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.impl.UserManagerImpl;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.vo.user.UserByDateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import static com.catalystplus.admin.response.ResponseCode.ADMIN_DATE_ERROR;


@Slf4j
@RestController
@CrossOrigin
public class UserController implements UserApi {

    @Autowired
    private UserManagerImpl userManager;

    @Override
    public Response<Long> getTNU() {
        // 1.初始化
        Long tnu;
        // 2.查询截至今日用户总数
        try {
            tnu = userManager.queryUserTNU();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }
        return Response.success(null, tnu);
    }

    @Override
    public Response<Long> getNNUT(UserByDateVo userByDateVo) {
        // 1.验证参数
        log.info("auByDateVo: {}", userByDateVo);
        if (Assert.notEmpty(userByDateVo.getLocalDateTime().toString())) {
            return Response.fail(userByDateVo.getUserId(), ADMIN_DATE_ERROR.getCode(), ADMIN_DATE_ERROR.getMsg());
        }
        // 2.查询今日新增用户数
        Long nnut;
        try {
            nnut = userManager.queryUserNNUT(userByDateVo.getLocalDateTime());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }
        return Response.success(userByDateVo.getUserId(), nnut);
    }

}

