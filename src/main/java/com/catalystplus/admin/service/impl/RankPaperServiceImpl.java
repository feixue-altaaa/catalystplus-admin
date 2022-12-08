package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.RankPaper;
import com.catalystplus.admin.service.RankPaperService;
import com.catalystplus.admin.mapper.RankPaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanran
 * @description 针对表【rank_paper(文献排行表)】的数据库操作Service实现
 * @createDate 2022-12-01 10:00:55
 */
@Service
public class RankPaperServiceImpl extends ServiceImpl<RankPaperMapper, RankPaper>
        implements RankPaperService {

    /**
     *获取不同排行下文章ID
     * @param type  排行种类
     * @param number 排行数量
     * @return
     */
    @Override
    public List<Long> getTopTotal(String type, Long number) {

        //1. 组装查询语句
        LambdaQueryWrapper<RankPaper> rankPaperLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rankPaperLambdaQueryWrapper.select(RankPaper::getId);
        switch (type) {
            case AdminRankConstant.READ_TOTAL:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getReadTotal);
                break;
            case AdminRankConstant.COLLECT_TOTAL:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getCollectTotal);
                break;
            case AdminRankConstant.TAG_TOTAL:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getTagTotal);
                break;
            case AdminRankConstant.NOTE_TOTAL:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getNoteTotal);
                break;
            case AdminRankConstant.GOOD_TOTAL:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getGoodTotal);
                break;
        }
        rankPaperLambdaQueryWrapper.last("limit " + number);

        //2. 返回文章ID
        return this.listObjs(rankPaperLambdaQueryWrapper, object -> Long.valueOf(object.toString()));
    }

    @Override
    public List<Long> getTopToday(String type, Long number) {

        //1. 组装查询语句
        LambdaQueryWrapper<RankPaper> rankPaperLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rankPaperLambdaQueryWrapper.select(RankPaper::getId);
        switch (type) {
            case AdminRankConstant.TODAY_READ:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getTodayRead);
            case AdminRankConstant.TODAY_COLLECT:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getTodayCollect);
                break;
            case AdminRankConstant.TODAY_TAG:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getTodayTag);
                break;
            case AdminRankConstant.TODAY_NOTE:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getTodayNote);
                break;
            case AdminRankConstant.TODAY_GOOD:
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getTodayGood);
                break;
        }
        rankPaperLambdaQueryWrapper.last("limit " + number);

        //2. 返回文章ID
        return this.listObjs(rankPaperLambdaQueryWrapper, object -> Long.valueOf(object.toString()));
    }

    @Override
    public List<RankPaper> getRankPaperByIds(List<Long> paperIds) {

        //1. 初始化
        List<RankPaper> rankPapers = new ArrayList<>();

        //2. 根据paperIds获取rankpaper
        paperIds.forEach(paperId -> {
            rankPapers.add(this.getById(paperId));
        });

        return rankPapers;
    }
}




