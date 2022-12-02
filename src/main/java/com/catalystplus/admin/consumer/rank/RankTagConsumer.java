package com.catalystplus.admin.consumer.rank;

import com.catalystplus.admin.constant.AdminRankConstant;
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

    @Override
    public void onMessage(String message) {
        redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_TAG,Long.parseLong(message));
    }
}