package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.UserApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.impl.UserDataManagerImpl;
import com.catalystplus.admin.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class UserController implements UserApi {

    @Autowired
    private UserDataManagerImpl userDataManager;

    @Override
    public Response<Long> getTNU() {
        Long tnu = userDataManager.getTNU();
        return Response.success(null, tnu);
    }

    @Override
    public Response<Long> getNNUT(String dateKey) {
        if (Assert.notEmpty(dateKey)) {
            return Response.fail(null, "参数为空");
        }
        Long nnut = userDataManager.getNNUT(dateKey);
        return Response.success(null, nnut);
    }

    @Override
    public Response<Map<String, Object>> getDWMAU(String dateKey) {
        if (Assert.notEmpty(dateKey)) {
            return Response.fail(null, "参数为空");
        }
        Map<String, Object> res = userDataManager.getDWMAU(dateKey);
        return Response.success(null, res);
    }

    @Override
    public Response<Long> getNACU() {
        Long nacu = userDataManager.getNACU();
        return Response.success(null, nacu);
    }

    @Override
    public Response<Long> getNNCU() {
        Long nncu = userDataManager.getNNCU();
        return Response.success(null, nncu);
    }


}

