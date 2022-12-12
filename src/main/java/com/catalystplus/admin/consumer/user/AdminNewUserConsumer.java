package com.catalystplus.admin.consumer.user;


import com.catalystplus.admin.dto.AdminDTO;
import com.catalystplus.admin.manager.impl.UserActiveManagerImpl;
import com.catalystplus.admin.manager.impl.UserInfoManagerImpl;
import com.catalystplus.admin.util.RedisKeyUtil;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * 当有新用户注册时，消费消息，用于统计
 */
@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "admin-user-new",
        topic = "AdminTopic", selectorExpression = "nnut")
public class AdminNewUserConsumer implements RocketMQListener<AdminDTO> {

    @Autowired
    private UserActiveManagerImpl userActiveManager;

    @Autowired
    private UserInfoManagerImpl userInfoManager;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void onMessage(AdminDTO message) {
        // 有新用户注册
        Long userId = message.getUserId();
        // 注册时间
        LocalDateTime createdTime = message.getCreatedTime();

//        // 1.统计今日新增用户（userId必须不能超过整型，否则bitmap报错）
//        userActiveManager.recordNewUsersToday(userId, createdTime.format(DateTimeFormatter.ISO_LOCAL_DATE));

        // 2.初始化redis的哈希键
        prepareRedisKey(createdTime.format(DateTimeFormatter.ISO_LOCAL_DATE));

        // 3.统计用户信息
        userInfoManager.recordNewUsersInfoToday(userId, createdTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    private void prepareRedisKey(String dateTime) {
        String key = RedisKeyUtil.getUserInfoKey(dateTime);
        if (!redisUtil.hasKey(key)) {
            // 键不存在，初始化键
            // 读取配置文件
            try (
                    InputStream is = this.getClass().getClassLoader().getResourceAsStream("userinfo.properties");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)));
            ) {
                String hashKey;
                while ((hashKey = reader.readLine()) != null) {
                    // 将所有的hashValue初值设为0
                    redisUtil.putHashKey(key, hashKey, 0);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
