package com.catalystplus.admin.consumer;


import com.catalystplus.admin.dto.AdminDTO;
import com.catalystplus.admin.manager.impl.UserManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "admin-user-nnut",
        topic = "AdminTopic", selectorExpression = "nnut")
public class UserNnutConsumer implements RocketMQListener<AdminDTO> {

    @Autowired
    private UserManagerImpl userManager;

    @Override
    public void onMessage(AdminDTO message) {
        log.info("成功消费message: {}", message);
        Long userId = message.getUserId();
        LocalDateTime createdTime = message.getCreatedTime();
        userManager.recordUserNNUT(userId, createdTime);
    }
}
