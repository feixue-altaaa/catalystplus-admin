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
@RocketMQMessageListener(consumerGroup = "admin-rank-tag",
        topic = "AdminRank",selectorExpression = "tag")
public class RankTagUserConsumer implements RocketMQListener<String> {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountService totalCountService;

    @Override
    public void onMessage(String userId) {
        redisUtil.setBit(AdminUserConstant.ADMIN_USER_TODAY_TAG,Long.parseLong(userId),true);
        Long todayTag = redisUtil.bitCount(AdminUserConstant.ADMIN_USER_TODAY_TAG);

        TotalCount totalCount = totalCountService.getByDate();
        totalCount.setTodayTagUser(todayTag);
        totalCount.setTagTotalUser(totalCount.getTagTotalUser()+todayTag);
        totalCountService.updateById(totalCount);
    }
}
