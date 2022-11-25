package com.catalystplus.admin.message.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


@Component
@RocketMQMessageListener(consumerGroup = "data-update",
        topic = "dataUpdate",selectorExpression = "dataTotal")
public class DataConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {

    }
}
