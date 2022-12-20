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
@RocketMQMessageListener(consumerGroup = "admin-rank-good-user",
        topic = "AdminRank",selectorExpression = "good-user")
public class RankGoodUserConsumer implements RocketMQListener<String> {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TotalCountService totalCountService;

    @Override
    public void onMessage(String userId) {

        redisUtil.setBit(AdminUserConstant.ADMIN_USER_TODAY_GOOD,Long.parseLong(userId),true);
        Long todayGood = redisUtil.bitCount(AdminUserConstant.ADMIN_USER_TODAY_GOOD);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        String formatDate = simpleDateFormat.format(date);

        TotalCount totalCount = totalCountService.getByDate(formatDate);
        totalCount.setTodayGoodUser(todayGood);
        totalCount.setGoodTotalUser(totalCount.getGoodTotalUser()+todayGood);
        totalCountService.updateById(totalCount);

    }
}