package com.catalystplus.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catalystplus.admin.entity.Message;
import com.catalystplus.admin.entity.SysUser;
import com.catalystplus.admin.message.producer.MessageProducer;
import com.catalystplus.admin.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

@Slf4j
@SpringBootTest
class UserDataMessageTests {

    @Autowired
    MessageProducer messageProducer;

    @Autowired
    SysUserService sysUserService;

    @Test
    void testNNUTProducer() {
        Integer userId = 10;
        String str = "2022-11-12";

        String[] split = str.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        String createTime = LocalDate.of(year, month, day).toString();

        Message message = new Message()
                .setTopic("data")
                .setTags("nnut")
                .setData("userId", userId)
                .setData("createTime", createTime);

        messageProducer.produceMessage(message);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testAUProducer() {
        // 测试数据
        Integer userId = 10;

        String str = "2022-11-19";

        String[] split = str.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        String loginTime = LocalDate.of(year, month, day).toString();

        Message message = new Message()
                .setTopic("data")
                .setTags("au")
                .setData("userId", userId)
                .setData("loginTime", loginTime);

        messageProducer.produceMessage(message);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test() {
        // 模拟前端传入时间
        String str = "2022-11-12";

        String[] split = str.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        LocalDate date = LocalDate.of(year, month, day);
        LocalDate parse = LocalDate.parse(date.toString());
        LocalDate weekStart = parse.with(DayOfWeek.MONDAY);
        LocalDate weekEnd = parse.with(DayOfWeek.SUNDAY);
        LocalDate monthStart = parse.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate monthEnd = parse.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(weekStart.toString());
        System.out.println(weekEnd.toString());
        System.out.println(monthStart.toString());
        System.out.println(monthEnd.toString());
    }

}
