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
@RocketMQMessageListener(consumerGroup = "admin-rank-read",
        topic = "AdminRank",selectorExpression = "read")
public class RankReadConsumer implements RocketMQListener<String> {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountService totalCountService;

    @Override
    public void onMessage(String message) {

        redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_READ,Long.parseLong(message));

        TotalCount totalCount = totalCountService.getByDate();
        totalCount.setTodayRead(totalCount.getTodayRead()+1);
        totalCount.setReadTotal(totalCount.getReadTotal()+1);
        totalCountService.updateById(totalCount);

    }
}