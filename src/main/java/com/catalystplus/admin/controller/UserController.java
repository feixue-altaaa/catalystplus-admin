package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.UserApi;
import com.catalystplus.admin.exception.Assert;
import com.catalystplus.admin.manager.UserDataManager;
import com.catalystplus.admin.manager.impl.UserDataManagerImpl;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.ResponseCode;
import com.catalystplus.admin.response.user.UserDataResponse;
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
    public Response<UserDataResponse> getTNU() {
        Long tnu = userDataManager.getTNU();

        UserDataResponse userDataResponse = new UserDataResponse();
        userDataResponse.setTnu(tnu);
        return Response.success(null, userDataResponse);
    }

    @Override
    public Response<UserDataResponse> getNNUT(String dateKey) {
        if (Assert.notEmpty(dateKey)) {
            return Response.fail(null, "参数为空");
        }

        Long nnut = userDataManager.getNNUT(dateKey);

        UserDataResponse userDataResponse = new UserDataResponse();
        userDataResponse.setNnut(nnut);
        return Response.success(null, userDataResponse);
    }

    @Override
    public Response<UserDataResponse> getDWMAU(String dateKey) {
        if (Assert.notEmpty(dateKey)) {
            return Response.fail(null, "参数为空");
        }

        Map<String, Object> res = userDataManager.getDWMAU(dateKey);
        UserDataResponse userDataResponse = new UserDataResponse();
        userDataResponse.setDau((Long) res.get("dau"));
        userDataResponse.setWau((Long) res.get("wau"));
        userDataResponse.setMau((Long) res.get("mau"));
        userDataResponse.setPdau((String) res.get("pdau"));
        userDataResponse.setPwau((String) res.get("pwau"));
        userDataResponse.setPmau((String) res.get("pmau"));
        return Response.success(null, userDataResponse);
    }

    @Override
    public Response<UserDataResponse> getNACU() {
        Long nacu = userDataManager.getNACU();
        UserDataResponse userDataResponse = new UserDataResponse();
        userDataResponse.setNacu(nacu);
        return Response.success(null, userDataResponse);
    }

    @Override
    public Response<UserDataResponse> getNNCU() {
        Long nncu = userDataManager.getNNCU();
        UserDataResponse userDataResponse = new UserDataResponse();
        userDataResponse.setNncu(nncu);
        return Response.success(null, userDataResponse);
    }


}

