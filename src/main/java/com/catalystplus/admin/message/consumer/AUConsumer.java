package com.catalystplus.admin.message.consumer;

import com.catalystplus.admin.entity.Message;
import com.catalystplus.admin.manager.impl.UserDataManagerImpl;
import com.catalystplus.admin.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "data-user-au",
        topic = "data", selectorExpression = "au")
public class AUConsumer implements RocketMQListener<String> {

    // TODO: 2022/11/24 data改成admin

    // TODO: 2022/11/25 String类型改成AdminDTO  我已经放在程序里了 

    @Autowired
    private UserDataManagerImpl userDataManager;

    @Override
    public void onMessage(String json) {
        log.info("message is {}", json);
        Message message = JsonUtils.jsonToPojo(json, Message.class);
        if (message != null) {
            Integer userId = (Integer) message.getData().get("userId");
            String loginTime = (String) message.getData().get("loginTime");
            userDataManager.recordDWMAU(loginTime, userId);
        }
    }
}
