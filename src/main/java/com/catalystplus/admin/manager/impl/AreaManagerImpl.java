package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.entity.Area;
import com.catalystplus.admin.manager.AreaManager;
import com.catalystplus.admin.response.area.AreaResponse;
import com.catalystplus.admin.service.AreaService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 18:53
 * @Version 1.1
 */
@Slf4j
@Service
public class AreaManagerImpl implements AreaManager {


    @Autowired
    AreaService areaService;

    @Override
    public List<AreaResponse> getArea() {
        List<Area> areas = areaService.page(new Page<>(1, 18)).getRecords();
        log.info("areas: {}", areas);
        List<AreaResponse> areaResponses = Lists.newArrayList();
        areas.forEach(area -> {
            AreaResponse areaResponse = new AreaResponse();
            BeanUtils.copyProperties(area, areaResponse);
            areaResponses.add(areaResponse);
        });
        return areaResponses;
    }
}
