package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.UserApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.impl.UserDataManagerImpl;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.user.AUResponse;
import com.catalystplus.admin.vo.user.AUByDateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.catalystplus.admin.response.ResponseCode.USER_DATA_DATE_ERROR;

@Slf4j
@RestController
@CrossOrigin
public class UserController implements UserApi {

    @Autowired
    private UserDataManagerImpl userDataManager;

    @Override
    public Response<Long> getTNU() {
        // 1.初始化
        Long tnu;

        // 2.查询所有用户数
        try {
            tnu = userDataManager.getTNU();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }

        return Response.success(null, tnu);
    }

    @Override
    public Response<Long> getNNUT(AUByDateVo auByDateVo) {
        // 1.验证参数
        log.info("auByDateVo: {}", auByDateVo);
        if (Assert.notEmpty(auByDateVo.getDateKey())) {
            return Response.fail(auByDateVo.getUserId(), USER_DATA_DATE_ERROR.getCode(), USER_DATA_DATE_ERROR.getMsg());
        }

        // 2.根据今日日期查询nnut
        Long nnut;
        try {
            nnut = userDataManager.getNNUT(auByDateVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }
        return Response.success(auByDateVo.getUserId(), nnut);
    }

    @Override
    public Response<List<AUResponse>> getDWMAU(AUByDateVo auByDateVo) {
        // 1.验证参数
        log.info("auByDateVo: {}", auByDateVo);
        if (Assert.notEmpty(auByDateVo.getDateKey())) {
            return Response.fail(auByDateVo.getUserId(), USER_DATA_DATE_ERROR.getCode(), USER_DATA_DATE_ERROR.getMsg());
        }
        List<AUResponse> dwmauInfo;
        // 2.根据日期查询用户日周月活及占比
        try {
            dwmauInfo = userDataManager.getDWMAU(auByDateVo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(auByDateVo.getUserId(), e.getMessage());
        }
        // 3.返回数据
        return Response.success(auByDateVo.getUserId(), dwmauInfo);
    }

    @Override
    public Response<Long> getNACU() {
        // 1.初始化
        Long nacu;

        // 2.查询同时在线活跃用户数
        try {
            nacu = userDataManager.getNACU();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }

        return Response.success(null, nacu);
    }

    @Override
    public Response<Long> getNNCU() {
        // 1.初始化
        Long nncu;

        // 2.查询同时在线新用户数
        try {
            nncu = userDataManager.getNNCU();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }

        return Response.success(null, nncu);
    }


}

