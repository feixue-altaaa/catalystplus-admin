package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.totalCount.TotalCountResponse;

import java.util.List;
import java.util.Map;


public interface TotalCountManager {

    Map<String, Map> getByDate(String dateTime);

}
