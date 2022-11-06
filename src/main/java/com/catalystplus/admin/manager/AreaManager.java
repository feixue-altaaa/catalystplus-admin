package com.catalystplus.admin.manager;

import com.catalystplus.admin.entity.Area;
import com.catalystplus.admin.response.area.AreaResponse;
import com.catalystplus.admin.vo.journal.AreaByAreaNameVo;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 18:53
 * @Version 1.1
 */

public interface AreaManager {

    List<AreaResponse> getArea();

    AreaResponse getAreaByName(AreaByAreaNameVo areaByAreaNameVo);


}
