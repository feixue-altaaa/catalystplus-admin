package com.catalystplus.admin;

import com.catalystplus.admin.consumer.TempProducer;
import com.catalystplus.admin.dto.AdminDTO;
import com.catalystplus.admin.service.UserInfoService;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.BitSet;
import java.util.Objects;

@Slf4j
@SpringBootTest
class UserDataMessageTests {

    @Autowired
    TempProducer tempProducer;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    UserInfoService userInfoService;

    @Test
    void testMQ() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUserId(5L);
        adminDTO.setCreatedTime(LocalDateTime.now());
        tempProducer.sendMessage("AdminTopic:nnut", adminDTO);
    }

    @Test
    void testMQ1() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUserId(11L);
        adminDTO.setLoginTime(LocalDateTime.now());
        tempProducer.sendMessage("AdminTopic:au", adminDTO);
    }

    @Test
    void testBitmap() {
        redisTemplate.opsForValue().setBit("test1", 1, true);
        String test1 = redisTemplate.opsForValue().get("test1", 0, -1);
        redisTemplate.opsForHash().put("test5", "bitmap", Objects.requireNonNull(test1));
        String str = (String) redisTemplate.opsForHash().get("test5", "bitmap");
        BitSet bitSet = BitSet.valueOf(Objects.requireNonNull(str).getBytes());
        for (int i = 0; i < bitSet.length(); i++) {
            System.out.println(bitSet.get(i));
        }
    }


}
