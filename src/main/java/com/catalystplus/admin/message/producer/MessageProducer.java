package com.catalystplus.admin.message.producer;

import com.catalystplus.admin.entity.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void produceMessage(Message message) {
        // 消息的topic和tags
        String topic = message.getTopic() + ":" + message.getTags();
        // 向topic下发送消息
        rocketMQTemplate.convertAndSend(topic, message);
    }

}
