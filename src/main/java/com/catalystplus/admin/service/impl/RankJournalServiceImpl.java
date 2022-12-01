package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.RankJournal;
import com.catalystplus.admin.service.RankJournalService;
import com.catalystplus.admin.mapper.RankJournalMapper;
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

    @Override
    public List<Long> getTopJournal(String type, Long number) {

        LambdaQueryWrapper<RankJournal> rankJournalLambdaQueryWrapper = new LambdaQueryWrapper<>();
        switch (type){
            case "subscription_total" :
                rankJournalLambdaQueryWrapper.orderByDesc(RankJournal::getSubscriptionTotal);
        }
        rankJournalLambdaQueryWrapper.last("limit "+number);

        List<RankJournal> rankJournals = this.baseMapper.selectList(rankJournalLambdaQueryWrapper);
        List<Long> list = new ArrayList<>();

        if(null != rankJournals){
            rankJournals.forEach(rankJournal -> {
                list.add(rankJournal.getId());
            });
        }

        return list;
    }
}




