package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.RankTop;
import com.catalystplus.admin.mapper.RankTopMapper;
import com.catalystplus.admin.service.RankTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalystplus.admin.constant.AdminRankConstant;

import java.util.List;

/**
* @author lanran
* @description 针对表【rank_top_ten(后台文章期刊十大排行表)】的数据库操作Service实现
* @createDate 2022-12-01 10:00:55
*/
@Service
public class RankTopServiceImpl extends ServiceImpl<RankTopMapper, RankTop>
    implements RankTopService {

    @Autowired
    RankTopMapper rankTopMapper;

    @Override
    public void deleteByType(Long type) {
        rankTopMapper.deleteByType(type);
    }

    @Override
    public List<Long> getTypeIdByCategory(String category,Long number) {

        //1. 组装查询语句
        LambdaQueryWrapper<RankTop> rankTopLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rankTopLambdaQueryWrapper.select(RankTop::getTypeId);

        switch (category){
            case AdminRankConstant.ADMIN_RANK_TODAY_READ :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,1);
                break;
            case AdminRankConstant.ADMIN_RANK_TOTAL_READ :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,2);
                break;
            case AdminRankConstant.ADMIN_RANK_TODAY_COLLECT :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,3);
                break;
            case AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,4);
                break;
            case AdminRankConstant.ADMIN_RANK_TODAY_TAG :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,5);
                break;
            case AdminRankConstant.ADMIN_RANK_TOTAL_TAG :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,6);
                break;
            case AdminRankConstant.ADMIN_RANK_TODAY_NOTE :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,7);
                break;
            case AdminRankConstant.ADMIN_RANK_TOTAL_NOTE :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,8);
                break;
            case AdminRankConstant.ADMIN_RANK_TODAY_GOOD :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,9);
                break;
            case AdminRankConstant.ADMIN_RANK_TOTAL_GOOD :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,10);
                break;
            case AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,1001);
                break;
            case AdminRankConstant.ADMIN_RANK_TOTAL_SUBSCRIPTION :
                rankTopLambdaQueryWrapper.eq(RankTop::getType,1002);
                break;
        }
        rankTopLambdaQueryWrapper.orderByDesc(RankTop::getCount);
        rankTopLambdaQueryWrapper.last("limit "+number);

        //2. 返回文章ID
        return this.listObjs(rankTopLambdaQueryWrapper, object -> Long.valueOf(object.toString()));
    }
}




