package com.catalystplus.admin.consumer;

import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RankConsumer {

    @Component
    @RocketMQMessageListener(consumerGroup = "admin-rank-good",
            topic = "AdminRank",selectorExpression = "good")
    public class RankGoodConsumer implements RocketMQListener<String> {

        @Autowired
        RedisUtil redisUtil;

        @Override
        public void onMessage(String message) {
            redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_GOOD,Long.parseLong(message));
            log.info("good消费成功");
        }
    }

    @Component
    @RocketMQMessageListener(consumerGroup = "admin-rank-note",
            topic = "AdminRank",selectorExpression = "note")
    public class RankNoteConsumer implements RocketMQListener<String> {

        @Autowired
        RedisUtil redisUtil;

        @Override
        public void onMessage(String message) {
            redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_NOTE,Long.parseLong(message));
            log.info("note消费成功");
        }
    }

    @Component
    @RocketMQMessageListener(consumerGroup = "admin-rank-read",
            topic = "AdminRank",selectorExpression = "read")
    public class RankReadConsumer implements RocketMQListener<String> {

        @Autowired
        RedisUtil redisUtil;

        @Override
        public void onMessage(String message) {
            redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_READ,Long.parseLong(message));
        }
    }

    @Component
    @RocketMQMessageListener(consumerGroup = "admin-rank-collect",
            topic = "AdminRank",selectorExpression = "collect")
    public class RankCollectConsumer implements RocketMQListener<String> {

        @Autowired
        RedisUtil redisUtil;

        @Override
        public void onMessage(String message) {
            redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_COLLECT,Long.parseLong(message));
        }
    }

    @Component
    @RocketMQMessageListener(consumerGroup = "admin-rank-tag",
            topic = "AdminRank",selectorExpression = "tag")
    public class RankTagConsumer implements RocketMQListener<String> {

        @Autowired
        RedisUtil redisUtil;

        @Override
        public void onMessage(String message) {
            redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_TAG,Long.parseLong(message));
        }
    }

}
