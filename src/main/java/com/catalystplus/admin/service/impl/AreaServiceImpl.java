package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.Area;
import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.service.AreaService;
import com.catalystplus.admin.mapper.AreaMapper;
import org.springframework.stereotype.Service;

/**
 * @author lanran
 * @description 针对表【area(领域信息表)】的数据库操作Service实现
 * @createDate 2022-10-24 10:39:55
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area>
        implements AreaService {

    @Override
    public Area getAreaByName(String areaName) {
        LambdaQueryWrapper<Area> areaLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断areaName是英文还是中文
        if(areaName.matches("[\u4E00-\u9FA5]+")){
            areaLambdaQueryWrapper.eq(Area::getChName,areaName);
        }else {
            areaLambdaQueryWrapper.eq(Area::getEnName,areaName);
        }
        Area area = this.baseMapper.selectOne(areaLambdaQueryWrapper);
        return area;
    }

}




