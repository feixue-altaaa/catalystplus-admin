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

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "admin-rank-tag",
        topic = "AdminRank",selectorExpression = "tag")
public class RankTagConsumer implements RocketMQListener<String> {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountService totalCountService;

    @Override
    public void onMessage(String message) {
        redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_TAG,Long.parseLong(message));

        TotalCount totalCount = totalCountService.getByDate();
        totalCount.setTodayTag(totalCount.getTodayTag()+1);
        totalCount.setTagTotal(totalCount.getTagTotal()+1);
        totalCountService.updateById(totalCount);
    }
}
