package com.catalystplus.admin.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "admin-rank-tag",
            topic = "AdminRank",selectorExpression = "tag")
public class RankTagConsumer {
}
