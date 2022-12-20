package com.catalystplus.admin.consumer.rank.paper;

import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.TotalCount;
import com.catalystplus.admin.service.TotalCountService;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "admin-rank-subscription",
            topic = "AdminRank",selectorExpression = "subscription")
public class RankJournalSubscriptionConsumer implements RocketMQListener<String> {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountService totalCountService;

    @Override
    public void onMessage(String message) {
        redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION,Long.parseLong(message));
        log.info("subscription消费成功");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        String formatDate = simpleDateFormat.format(date);

        TotalCount totalCount = totalCountService.getByDate(formatDate);
        totalCount.setTodaySubscription(totalCount.getTodaySubscription()+1);
        totalCount.setSubscriptionTotal(totalCount.getSubscriptionTotal()+1);
        totalCountService.updateById(totalCount);
    }
}
