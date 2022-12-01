package com.catalystplus.admin.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "admin-rank-good",
            topic = "AdminRank",selectorExpression = "good")
public class RankGoodConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String s) {

    }
}
