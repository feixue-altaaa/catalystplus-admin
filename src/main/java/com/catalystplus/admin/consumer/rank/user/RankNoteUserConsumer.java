package com.catalystplus.admin.consumer.rank.user;

import com.catalystplus.admin.constant.AdminUserConstant;
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
@RocketMQMessageListener(consumerGroup = "admin-rank-note-user",
        topic = "AdminRank",selectorExpression = "note-user")
public class RankNoteUserConsumer implements RocketMQListener<String> {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountService totalCountService;

    @Override
    public void onMessage(String userId) {
        redisUtil.setBit(AdminUserConstant.ADMIN_USER_TODAY_NOTE,Long.parseLong(userId),true);
        Long todayNote = redisUtil.bitCount(AdminUserConstant.ADMIN_USER_TODAY_NOTE);

        TotalCount totalCount = totalCountService.getByDate();
        totalCount.setTodayNoteUser(todayNote);
        totalCount.setNoteTotalUser(totalCount.getNoteTotalUser()+todayNote);
        totalCountService.updateById(totalCount);
    }
}
