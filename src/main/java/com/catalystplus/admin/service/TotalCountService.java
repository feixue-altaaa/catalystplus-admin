package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.TotalCount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catalystplus.admin.response.totalCount.TotalCountResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author lanran
* @description 针对表【total_count(文献期刊用户总量表)】的数据库操作Service
* @createDate 2022-12-08 10:50:19
*/
public interface TotalCountService extends IService<TotalCount> {




    TotalCount getByDate();


}
