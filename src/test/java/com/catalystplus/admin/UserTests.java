package com.catalystplus.admin;

import com.catalystplus.admin.consumer.TempProducer;
import com.catalystplus.admin.dto.AdminDTO;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.service.UserInfoEducationService;
import com.catalystplus.admin.service.UserInfoUniversityService;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.BitSet;
import java.util.Objects;

@Slf4j
@SpringBootTest
class UserTests {

    @Autowired
    TempProducer tempProducer;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    UserInfoEducationService userInfoEducationService;

    @Autowired
    UserInfoUniversityService userInfoUniversityService;

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

    @Test
    void sendMessage() {
        AdminDTO dto = new AdminDTO();
        dto.setUserId(808685237490941952L);
        dto.setCreatedTime(sysUserService.getById(808685237490941952L).getCreatedTime());
        tempProducer.sendMessage("AdminTopic:nnut", dto);
    }

}
