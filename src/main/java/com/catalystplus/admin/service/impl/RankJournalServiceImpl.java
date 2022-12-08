package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.RankJournal;
import com.catalystplus.admin.service.RankJournalService;
import com.catalystplus.admin.mapper.RankJournalMapper;
import com.catalystplus.admin.constant.AdminRankConstant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author lanran
* @description 针对表【rank_journal(期刊排行表)】的数据库操作Service实现
* @createDate 2022-12-01 10:00:55
*/
@Service
public class RankJournalServiceImpl extends ServiceImpl<RankJournalMapper, RankJournal>
    implements RankJournalService{

    /**
     * 获取不同排行下期刊ID
     * @param type  排行种类
     * @param number 排行数量
     * @return
     */
    @Override
    public List<Long> getTopJournal(String type, Long number) {

        LambdaQueryWrapper<RankJournal> rankJournalLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rankJournalLambdaQueryWrapper.select(RankJournal::getId);
        switch (type){
            case AdminRankConstant.SUBSCRIPTION_TOTAL :
                rankJournalLambdaQueryWrapper.orderByDesc(RankJournal::getSubscriptionTotal);
                break;
        }
        rankJournalLambdaQueryWrapper.last("limit "+number);

        return this.listObjs(rankJournalLambdaQueryWrapper,object -> Long.valueOf(object.toString()));
    }

    @Override
    public List<RankJournal> getRankJouralByIds(List<Long> journalIds) {


        List<RankJournal> rankJournals = new ArrayList<>();

        journalIds.forEach(journalId -> {
            rankJournals.add(this.getById(journalId));
        });
        return rankJournals;
    }
}




