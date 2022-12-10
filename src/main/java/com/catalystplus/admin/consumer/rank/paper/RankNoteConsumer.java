package com.catalystplus.admin.consumer.rank.paper;

import cn.hutool.crypto.digest.otp.TOTP;
import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.TotalCount;
import com.catalystplus.admin.service.TotalCountService;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "admin-rank-note",
        topic = "AdminRank",selectorExpression = "note")
public class RankNoteConsumer implements RocketMQListener<String> {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountService totalCountService;

    @Override
    public void onMessage(String message) {
        redisUtil.update(AdminRankConstant.ADMIN_RANK_TODAY_NOTE,Long.parseLong(message));
        log.info("note消费成功");

        TotalCount totalCount = totalCountService.getByDate();
        totalCount.setTodayNote(totalCount.getTodayNote()+1);
        totalCount.setNoteTotal(totalCount.getNoteTotal()+1);
        totalCountService.updateById(totalCount);
    }
}