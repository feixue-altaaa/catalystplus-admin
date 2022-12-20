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

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "admin-rank-read-user",
        topic = "AdminRank",selectorExpression = "read-user")
public class RankReadUserConsumer implements RocketMQListener<String> {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountService totalCountService;

    @Override
    public void onMessage(String userId) {

        redisUtil.setBit(AdminUserConstant.ADMIN_USER_TODAY_READ,Long.parseLong(userId),true);
        Long todayRead = redisUtil.bitCount(AdminUserConstant.ADMIN_USER_TODAY_READ);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        String formatDate = simpleDateFormat.format(date);

        TotalCount totalCount = totalCountService.getByDate(formatDate);
        totalCount.setTodayReadUser(todayRead);
        totalCount.setReadTotalUser(totalCount.getReadTotalUser()+todayRead);
        totalCountService.updateById(totalCount);

    }
}
