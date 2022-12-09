package com.catalystplus.admin.consumer.user;


import com.catalystplus.admin.dto.AdminDTO;
import com.catalystplus.admin.manager.impl.UserActiveManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 当用户上线或下线时，消费消息，统计用户同时在线数
 */
@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "admin-user-concurrent",
        topic = "AdminTopic", selectorExpression = "cu")
public class AdminConcurrentUserConsumer implements RocketMQListener<AdminDTO> {

    @Autowired
    private UserActiveManagerImpl userManager;

    @Override
    public void onMessage(AdminDTO message) {
        log.info("message is {}", message);
        // 1.从消息中取出用户在线的相关信息
        Long userId = message.getUserId();
        Integer onlineFlag = message.getOnlineFlag();
        // 2.记录用户的在线信息
        userManager.recordConcurrentUsersInfo(userId, onlineFlag);
    }
}
