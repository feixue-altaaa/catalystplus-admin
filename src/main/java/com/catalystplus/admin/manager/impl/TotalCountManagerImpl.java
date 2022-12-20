package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.entity.TotalCount;
import com.catalystplus.admin.manager.TotalCountManager;
import com.catalystplus.admin.response.totalCount.TotalCountResponse;
import com.catalystplus.admin.service.TotalCountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TotalCountManagerImpl implements TotalCountManager {


    @Autowired
    TotalCountService totalCountService;

    @Override
    public Map<String, Map> getByDate(String dateTime) {

        //1. 初始化
        TotalCountResponse totalCountResponse = new TotalCountResponse();

        //2. 获取今日、截至今日文章期刊用户新增
        TotalCount totalCount = totalCountService.getByDate(dateTime);


        Map<String, Long> paperRead = new HashMap<>();
        Map<String,Long> paperCollect = new HashMap<>();
        Map<String,Long> paperTag = new HashMap<>();
        Map<String,Long> paperNote = new HashMap<>();
        Map<String,Long> paperGood = new HashMap<>();
        Map<String,Long> journalSubscription = new HashMap<>();



        paperRead.put("today",totalCount.getTodayRead());
        paperRead.put("total",totalCount.getReadTotal());
        paperRead.put("todayPerCapita",totalCount.getTodayRead()/totalCount.getTodayReadUser());
        paperRead.put("totalPerCapita",totalCount.getReadTotal()/totalCount.getReadTotalUser());

        paperCollect.put("today",totalCount.getTodayCollect());
        paperCollect.put("total",totalCount.getCollectTotal());
        paperCollect.put("todayPerCapita",totalCount.getTodayCollect()/totalCount.getTodayCollectUser());
        paperCollect.put("totalPerCapita",totalCount.getCollectTotal()/totalCount.getCollectTotalUser());

        paperTag.put("today",totalCount.getTodayTag());
        paperTag.put("total",totalCount.getTagTotal());
        paperTag.put("todayPerCapita",totalCount.getTodayTag()/totalCount.getTodayTagUser());
        paperTag.put("totalPerCapita",totalCount.getTagTotal()/totalCount.getTagTotalUser());

        paperNote.put("today",totalCount.getTodayNote());
        paperNote.put("total",totalCount.getNoteTotal());
        paperNote.put("todayPerCapita",totalCount.getTodayNote()/totalCount.getTodayNoteUser());
        paperNote.put("totalPerCapita",totalCount.getNoteTotal()/totalCount.getNoteTotalUser());

        paperGood.put("today",totalCount.getTodayGood());
        paperGood.put("total",totalCount.getGoodTotal());
        paperGood.put("todayPerCapita",totalCount.getTodayGood()/totalCount.getTodayGoodUser());
        paperGood.put("totalPerCapita",totalCount.getGoodTotal()/totalCount.getGoodTotalUser());

        journalSubscription.put("today",totalCount.getTodaySubscription());
        journalSubscription.put("total",totalCount.getSubscriptionTotal());
        journalSubscription.put("todayPerCapita",totalCount.getTodaySubscription()/totalCount.getTodaySubscriptionUser());
        journalSubscription.put("totalPerCapita",totalCount.getSubscriptionTotal()/totalCount.getSubscriptionTotalUser());

//        totalCountResponse.setPaperRead(paperRead);
//        totalCountResponse.setPaperCollect(paperCollect);
//        totalCountResponse.setPaperTag(paperTag);
//        totalCountResponse.setPaperNote(paperNote);
//        totalCountResponse.setPaperGood(paperGood);
//        totalCountResponse.setJournalSubscription(journalSubscription);

//        return totalCountResponse;

//        List<Map> total = new ArrayList<>();
        Map<String,Map> total = new HashMap<>();

        total.put("read",paperRead);
        total.put("collect",paperCollect);
        total.put("note",paperNote);
        total.put("tag",paperTag);
        total.put("good",paperGood);
        total.put("subscription",journalSubscription);

        return total;
    }
}
