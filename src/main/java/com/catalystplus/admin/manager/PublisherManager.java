package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.area.AreaResponse;
import com.catalystplus.admin.response.publisher.PublisherResponse;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 18:53
 * @Version 1.1
 */

public interface PublisherManager {

    List<PublisherResponse> getPublisher();

}
