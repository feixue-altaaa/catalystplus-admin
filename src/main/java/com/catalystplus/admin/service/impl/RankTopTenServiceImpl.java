package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.RankTopTen;
import com.catalystplus.admin.service.RankTopTenService;
import com.catalystplus.admin.mapper.RankTopTenMapper;
import org.springframework.stereotype.Service;

/**
* @author lanran
* @description 针对表【rank_top_ten(后台文章期刊十大排行表)】的数据库操作Service实现
* @createDate 2022-12-01 10:00:55
*/
@Service
public class RankTopTenServiceImpl extends ServiceImpl<RankTopTenMapper, RankTopTen>
    implements RankTopTenService{

}




