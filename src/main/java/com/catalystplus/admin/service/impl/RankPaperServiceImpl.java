package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    implements RankPaperService{

    @Override
    public List<Long> getTopTotal(String type, Long number) {

        LambdaQueryWrapper<RankPaper> rankPaperLambdaQueryWrapper = new LambdaQueryWrapper<>();
        switch (type){
            case "collect_total" :
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getCollectTotal);
                break;
            case "tag_total" :
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getTagTotal);
                break;
            case "note_total" :
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getNoteTotal);
                break;
            case "good_total" :
                rankPaperLambdaQueryWrapper.orderByDesc(RankPaper::getGoodTotal);
                break;
        }
        rankPaperLambdaQueryWrapper.last("limit "+number);

        List<RankPaper> rankPapers = this.baseMapper.selectList(rankPaperLambdaQueryWrapper);
        List<Long> list = new ArrayList<>();

        rankPapers.forEach(rankPaper -> {
            list.add(rankPaper.getId());
        });
        return list;
    }
}




