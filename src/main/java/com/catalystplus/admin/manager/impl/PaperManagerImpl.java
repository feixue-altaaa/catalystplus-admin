package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.entity.Paper;
import com.catalystplus.admin.manager.PaperManager;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.service.PaperService;
import com.catalystplus.admin.util.RedisUtil;
import com.catalystplus.admin.vo.rank.RankVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaperManagerImpl implements PaperManager {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    JournalService journalService;
    @Autowired
    PaperService paperService;


    @Override
    public List<PaperResponse> getTopPaper(RankVo rankVo) {

        //1. 初始化
        List<PaperResponse> paperResponses = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<Paper> papers = new ArrayList<>();

        //2. 获取文章详细信息
        if(AdminRankConstant.ADMIN_RANK_COLLECT_TOTAL == rankVo.getCategoryOfRanking() ||
            AdminRankConstant.ADMIN_RANK_GOOD_TOTAL == rankVo.getCategoryOfRanking() ||
            AdminRankConstant.ADMIN_RANK_NOTE_TOTAL == rankVo.getCategoryOfRanking() ||
            AdminRankConstant.ADMIN_RANK_TAG_TOTAL == rankVo.getCategoryOfRanking()){
            objects = redisUtil.get(rankVo.getCategoryOfRanking());
            if(null != objects){
                objects.forEach(object -> {
                    papers.add((Paper) object);
                });
            }
        }else if(AdminRankConstant.ADMIN_RANK_TODAY_COLLECT == rankVo.getCategoryOfRanking() ||
                    AdminRankConstant.ADMIN_RANK_TODAY_GOOD == rankVo.getCategoryOfRanking() ||
                    AdminRankConstant.ADMIN_RANK_TODAY_NOTE == rankVo.getCategoryOfRanking() ||
                    AdminRankConstant.ADMIN_RANK_TODAY_TAG == rankVo.getCategoryOfRanking()){
            objects = redisUtil.get(rankVo.getCategoryOfRanking());
            if(null != objects){
                objects.forEach(object -> {
                    papers.add(paperService.getById((Long)object));
                });
            }
        }

        //3. 组装响应
        if(null != objects){
            objects.forEach(paper -> {
                PaperResponse paperResponse = new PaperResponse();
                BeanUtils.copyProperties((Paper)paper,paperResponse);
                paperResponses.add(paperResponse);
            });
        }

        return paperResponses;
    }

    @Override
    public List<JournalResponse> getTopJournal(RankVo rankVo) {

        //1. 初始化
        List<JournalResponse> journalResponses = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<Journal> journals = new ArrayList<>();

        //2. 获取期刊详细信息
        if(AdminRankConstant.ADMIN_RANK_SUBSCRIPTION_TOTAL == rankVo.getCategoryOfRanking()){
            objects = redisUtil.get(rankVo.getCategoryOfRanking());
            if(null != objects){
                objects.forEach(object -> {
                    journals.add((Journal)object);
                });
            }
        }else if(AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION == rankVo.getCategoryOfRanking()){
            objects = redisUtil.get(rankVo.getCategoryOfRanking());
            if(null != objects){
                objects.forEach(journalId -> {
                    journals.add(journalService.getById((Long)journalId));
                });
            }
        }

        //3. 组装响应
        if(null != journals){
            journals.forEach(journal -> {
                JournalResponse journalResponse = new JournalResponse();
                BeanUtils.copyProperties(journal,journalResponse);
                journalResponses.add(journalResponse);
            });
        }

        return journalResponses;
    }




}
