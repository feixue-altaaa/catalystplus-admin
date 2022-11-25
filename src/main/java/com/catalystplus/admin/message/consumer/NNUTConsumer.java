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
@RocketMQMessageListener(consumerGroup = "data-user-nnut",
        topic = "data", selectorExpression = "nnut")
public class NNUTConsumer implements RocketMQListener<String> {

    @Autowired
    private UserDataManagerImpl userDataManager;

    @Override
    public void onMessage(String json) {
        log.info("message is {}", json);
        Message message = JsonUtils.jsonToPojo(json, Message.class);
        if (message != null) {
            Integer userId = (Integer) message.getData().get("userId");
            String createTime = (String) message.getData().get("createdTime");
            userDataManager.recordNNUT(createTime, userId);
        }
    }
}
