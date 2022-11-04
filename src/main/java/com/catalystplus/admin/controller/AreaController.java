package com.catalystplus.admin.controller;

import com.catalystplus.admin.controller.api.AreaApi;
import com.catalystplus.admin.manager.AreaManager;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.area.AreaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.GLOBAL_ID;

/**
 * @Author 蓝染
 * @Date 2022/9/30 15:47
 * @Version 1.1
 */
@Slf4j
@RestController
public class AreaController implements AreaApi {


    @Autowired
    AreaManager areaManager;

    @Override
    public Response<List<AreaResponse>> getArea() {

        //1. 初始化
        List<AreaResponse> areaResponses;

        //2. 查询几篇论文放主页
        try {
            areaResponses = areaManager.getArea();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.fail(null, e.getMessage());
        }

        return Response.success(null, areaResponses);
    }
}
