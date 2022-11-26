package com.catalystplus.admin.consumer;

import com.catalystplus.admin.dto.AdminDTO;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TempProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage(String topic, AdminDTO adminDTO) {
        rocketMQTemplate.convertAndSend(topic, adminDTO);
    }
}
