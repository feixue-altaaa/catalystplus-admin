package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.entity.TotalCount;
import com.catalystplus.admin.manager.TotalCountManager;
import com.catalystplus.admin.response.totalCount.TotalCountResponse;
import com.catalystplus.admin.service.TotalCountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TotalCountManagerImpl implements TotalCountManager {


    @Autowired
    TotalCountService totalCountService;

    @Override
    public TotalCountResponse getByDate() {

        //1. 初始化
        TotalCountResponse totalCountResponse = new TotalCountResponse();

        //2. 获取今日、截至今日文章期刊用户新增
        TotalCount totalCount = totalCountService.getByDate();

        //3. 组装响应
//        BeanUtils.copyProperties(totalCount,totalCountResponse);
//        totalCountResponse.setTodayPerCapitaSubscription(totalCount.getTodaySubscription()/totalCount.getTodaySubscriptionUser());
//        totalCountResponse.setTotalPerCapitaSubscription(totalCount.getSubscriptionTotal()/totalCount.getSubscriptionTotalUser());
//
//        totalCountResponse.setTodayPerCapitaRead(totalCount.getTodayRead()/totalCount.getTodayReadUser());
//        totalCountResponse.setTotalPerCapitaRead(totalCount.getReadTotal()/totalCount.getReadTotalUser());
//
//        totalCountResponse.setTodayPerCapitaCollect(totalCount.getTodayCollect()/totalCount.getTodayCollectUser());
//        totalCountResponse.setTotalPerCapitaCollect(totalCount.getReadTotal()/totalCount.getReadTotalUser());
//
//        totalCountResponse.setTodayPerCapitaTag(totalCount.getTodayTag()/totalCount.getTodayTagUser());
//        totalCountResponse.setTotalPerCapitaTag(totalCount.getTagTotal()/totalCount.getTagTotalUser());
//
//        totalCountResponse.setTodayPerCapitaNote(totalCount.getTodayNote()/totalCount.getTodayNoteUser());
//        totalCountResponse.setTotalPerCapitaNote(totalCount.getNoteTotal()/totalCount.getNoteTotalUser());
//
//        totalCountResponse.setTodayPerCapitaGood(totalCount.getTodayGood()/totalCount.getTodayGoodUser());
//        totalCountResponse.setTotalPerCapitaGood(totalCount.getGoodTotal()/totalCount.getGoodTotalUser());

        Map<String, Long> paperRead = new HashMap<>();
        Map<String,Long> paperCollect = new HashMap<>();
        Map<String,Long> paperTag = new HashMap<>();
        Map<String,Long> paperNote = new HashMap<>();
        Map<String,Long> paperGood = new HashMap<>();
        Map<String,Long> journalSubscription = new HashMap<>();



        paperRead.put("todayRead",totalCount.getTodayRead());
        paperRead.put("readTotal",totalCount.getReadTotal());
        paperRead.put("todayPerCapitaRead",totalCount.getTodayRead()/totalCount.getTodayReadUser());
        paperRead.put("totalPerCapitaRead",totalCount.getReadTotal()/totalCount.getReadTotalUser());

        paperCollect.put("todayCollect",totalCount.getTodayCollect());
        paperCollect.put("collectTotal",totalCount.getCollectTotal());
        paperCollect.put("todayPerCapitaCollect",totalCount.getTodayCollect()/totalCount.getTodayCollectUser());
        paperCollect.put("totalPerCapitaCollect",totalCount.getCollectTotal()/totalCount.getCollectTotalUser());

        paperTag.put("todayTag",totalCount.getTodayTag());
        paperTag.put("tagTotal",totalCount.getTagTotal());
        paperTag.put("todayPerCapitaTag",totalCount.getTodayTag()/totalCount.getTodayTagUser());
        paperTag.put("totalPerCapitaTag",totalCount.getTagTotal()/totalCount.getTagTotalUser());

        paperNote.put("todayNote",totalCount.getTodayNote());
        paperNote.put("noteTotal",totalCount.getNoteTotal());
        paperNote.put("todayPerCapitaNote",totalCount.getTodayNote()/totalCount.getTodayNoteUser());
        paperNote.put("totalPerCapitaNote",totalCount.getNoteTotal()/totalCount.getNoteTotalUser());

        paperGood.put("todayGood",totalCount.getTodayGood());
        paperGood.put("goodTotal",totalCount.getGoodTotal());
        paperGood.put("todayPerCapitaGood",totalCount.getTodayGood()/totalCount.getTodayGoodUser());
        paperGood.put("totalPerCapitaGood",totalCount.getGoodTotal()/totalCount.getGoodTotalUser());

        journalSubscription.put("todaySubscription",totalCount.getTodaySubscription());
        journalSubscription.put("subscriptionTotal",totalCount.getSubscriptionTotal());
        journalSubscription.put("todayPerCapitaSubscription",totalCount.getTodaySubscription()/totalCount.getTodaySubscriptionUser());
        journalSubscription.put("totalPerCapitaSubscription",totalCount.getSubscriptionTotal()/totalCount.getSubscriptionTotalUser());

        totalCountResponse.setPaperRead(paperRead);
        totalCountResponse.setPaperCollect(paperCollect);
        totalCountResponse.setPaperTag(paperTag);
        totalCountResponse.setPaperNote(paperNote);
        totalCountResponse.setPaperGood(paperGood);
        totalCountResponse.setJournalSubscription(journalSubscription);

        return totalCountResponse;
    }
}
