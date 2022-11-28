package com.catalystplus.admin.consumer;


import com.catalystplus.admin.manager.PaperCountManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "paper-count-update",
            topic = "database-update",selectorExpression = "papercount")
public class DatabaseUpdateConsumer implements RocketMQListener<String> {

    @Autowired
    PaperCountManager paperCountManager;


    @Override
    public void onMessage(String message) {

        //1. 参数验证
        log.info("message:{}",message);
        if(!"datebase-update".equals(message)){
            log.error("消费失败，消息体内容不符");
        }else {
            //2. 根据之前数据,更新数据库中paper_count表
            paperCountManager.insertPaperCountTotal(1);
            paperCountManager.insertPaperCountByArea(1);
            paperCountManager.insertPaperCountByAreaAndSubject(1);
            log.info("消费成功，paper_count表插入成功");
        }

    }
}
