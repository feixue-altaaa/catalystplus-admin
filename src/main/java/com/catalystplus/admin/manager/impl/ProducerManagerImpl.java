package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.manager.ProducerManager;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerManagerImpl implements ProducerManager {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String topic, String msg) {
        this.rocketMQTemplate.convertAndSend(topic + ":" + "note", msg);
        this.rocketMQTemplate.convertAndSend(topic + ":" + "good", msg);
    }


}
