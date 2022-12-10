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
 * 当有新用户注册时，消费消息，用于统计今日新增用户数
 */
@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "admin-user-new",
        topic = "AdminTopic", selectorExpression = "nnut")
public class AdminNewUserConsumer implements RocketMQListener<AdminDTO> {

    @Autowired
    private UserActiveManagerImpl userActiveManager;


    @Override
    public void onMessage(AdminDTO message) {
        log.info("message is {}", message);
        // 1.获取用户注册的相关信息
        Long userId = message.getUserId();
        LocalDateTime createdTime = message.getCreatedTime();
        // 2.记录今日新增用户数
        userActiveManager.recordNewUsersToday(userId, createdTime.format(DateTimeFormatter.ISO_LOCAL_DATE));

        // 3.记录今日新增用户数-按学历划分

        // 4.记录今日新增用户数-按学校划分


    }
}
