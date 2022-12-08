package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.entity.TotalCount;
import com.catalystplus.admin.manager.TotalCountManager;
import com.catalystplus.admin.response.totalCount.TotalCountResponse;
import com.catalystplus.admin.service.TotalCountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        BeanUtils.copyProperties(totalCount,totalCountResponse);
        totalCountResponse.setTodayPerCapitaSubscription(totalCount.getTodaySubscription()/totalCount.getTodaySubscriptionUser());
        totalCountResponse.setTotalPerCapitaSubscription(totalCount.getSubscriptionTotal()/totalCount.getSubscriptionTotalUser());

        totalCountResponse.setTodayPerCapitaRead(totalCount.getTodayRead()/totalCount.getTodayReadUser());
        totalCountResponse.setTotalPerCapitaRead(totalCount.getReadTotal()/totalCount.getReadTotalUser());

        totalCountResponse.setTodayPerCapitaCollect(totalCount.getTodayCollect()/totalCount.getTodayCollectUser());
        totalCountResponse.setTotalPerCapitaCollect(totalCount.getReadTotal()/totalCount.getReadTotalUser());

        totalCountResponse.setTodayPerCapitaTag(totalCount.getTodayTag()/totalCount.getTodayTagUser());
        totalCountResponse.setTotalPerCapitaTag(totalCount.getTagTotal()/totalCount.getTagTotalUser());

        totalCountResponse.setTodayPerCapitaNote(totalCount.getTodayNote()/totalCount.getTodayNoteUser());
        totalCountResponse.setTotalPerCapitaNote(totalCount.getNoteTotal()/totalCount.getNoteTotalUser());

        totalCountResponse.setTodayPerCapitaGood(totalCount.getTodayGood()/totalCount.getTodayGoodUser());
        totalCountResponse.setTotalPerCapitaGood(totalCount.getGoodTotal()/totalCount.getGoodTotalUser());

        return totalCountResponse;
    }
}
