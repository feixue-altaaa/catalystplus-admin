package com.catalystplus.admin.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "admin-rank-collect",
            topic = "AdminRank",selectorExpression = "collect")
public class RankCollectConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String s) {

    }
}
