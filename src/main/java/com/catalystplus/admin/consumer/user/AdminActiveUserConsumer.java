package com.catalystplus.admin.consumer.user;

import com.catalystplus.admin.dto.AdminDTO;
import com.catalystplus.admin.manager.impl.UserActiveManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 当有用户登录时（登录一次即算活跃），消费消息，用于统计用户活跃信息
 */
@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "admin-user-active",
        topic = "AdminTopic", selectorExpression = "au")
public class AdminActiveUserConsumer implements RocketMQListener<AdminDTO> {

    @Autowired
    private UserActiveManagerImpl userManager;

    @Override
    public void onMessage(AdminDTO message) {
        log.info("message is {}", message);
        // 1.从消息中取出用户活跃的相关信息
        Long userId = message.getUserId();
        LocalDateTime loginTime = message.getLoginTime();
        // 2.记录用户的活跃信息（日活跃数，周活跃数，月活跃数）
        userManager.recordActiveUsersInfo(userId, loginTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
