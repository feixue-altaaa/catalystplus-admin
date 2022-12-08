package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.TotalCount;
import com.catalystplus.admin.service.TotalCountService;
import com.catalystplus.admin.mapper.TotalCountMapper;
import org.springframework.stereotype.Service;

/**
* @author lanran
* @description 针对表【total_count(文献期刊用户总量表)】的数据库操作Service实现
* @createDate 2022-12-08 10:50:19
*/
@Service
public class TotalCountServiceImpl extends ServiceImpl<TotalCountMapper, TotalCount>
    implements TotalCountService{

}




