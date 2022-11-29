package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.Paper;
import com.catalystplus.admin.manager.PaperManager;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.util.RedisUtil;
import com.catalystplus.admin.vo.rank.RankVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaperManagerImpl implements PaperManager {

    @Autowired
    RedisUtil redisUtil;


    @Override
    public List<PaperResponse> getTopPaper(RankVo rankVo) {

        //1. 初始化
        List<PaperResponse> paperResponses = new ArrayList<>();
        List<Paper> papers = new ArrayList<>();

        if(AdminRankConstant.ADMIN_RANK_TODAY == rankVo.getDate()){
            //根据Redis中排名，从数据库中取数据
            switch (rankVo.getCategoryOfRanking()){
                case AdminRankConstant.ADMIN_RANK_PAPER_COLLECT :

                    break;
                case AdminRankConstant.ADMIN_RANK_PAPER_GOOD :

                    break;
                case AdminRankConstant.ADMIN_RANK_PAPER_NOTE :

                    break;
                case AdminRankConstant.ADMIN_RANK_PAPER_READ :

                    break;
                case AdminRankConstant.ADMIN_RANK_PAPER_TAG :

                    break;
            }
        }else if(AdminRankConstant.ADMIN_RANK_TOTAL == rankVo.getDate()){
            //直接从Redis中取数据
            switch (rankVo.getCategoryOfRanking()){
                case AdminRankConstant.ADMIN_RANK_PAPER_COLLECT :
                    List<Object> collectTotal = redisUtil.get("collect_total");
                    collectTotal.forEach(collect -> {
                    });
                    break;
                case AdminRankConstant.ADMIN_RANK_PAPER_GOOD :

                    break;
                case AdminRankConstant.ADMIN_RANK_PAPER_NOTE :

                    break;
                case AdminRankConstant.ADMIN_RANK_PAPER_READ :

                    break;
                case AdminRankConstant.ADMIN_RANK_PAPER_TAG :

                    break;
            }
        }

        return null;
    }

    @Override
    public List<JournalResponse> getTopJournal(RankVo rankVo) {
        return null;
    }
}
