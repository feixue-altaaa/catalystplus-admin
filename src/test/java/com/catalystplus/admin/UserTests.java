package com.catalystplus.admin;

import com.catalystplus.admin.consumer.TempProducer;
import com.catalystplus.admin.dto.AdminDTO;
import com.catalystplus.admin.entity.UserInfo;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.service.UserInfoEducationService;
import com.catalystplus.admin.service.UserInfoService;
import com.catalystplus.admin.service.UserInfoUniversityService;
import com.catalystplus.admin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.BitSet;
import java.util.Objects;

import static com.catalystplus.admin.constant.AdminUserConstant.MAJOR_CODE;

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
        dto.setUserId(809068696621285377L);
        dto.setCreatedTime(sysUserService.getById(809068696621285377L).getCreatedTime());
        tempProducer.sendMessage("AdminTopic:nnut", dto);
        dto = new AdminDTO();
        dto.setUserId(809069269621932032L);
        dto.setCreatedTime(sysUserService.getById(809069269621932032L).getCreatedTime());
        tempProducer.sendMessage("AdminTopic:nnut", dto);
        dto = new AdminDTO();
        dto.setUserId(809068696822611968L);
        dto.setCreatedTime(sysUserService.getById(809068696822611968L).getCreatedTime());
        tempProducer.sendMessage("AdminTopic:nnut", dto);
        dto = new AdminDTO();
        dto.setUserId(809069269433188353L);
        dto.setCreatedTime(sysUserService.getById(809069269433188353L).getCreatedTime());
        tempProducer.sendMessage("AdminTopic:nnut", dto);
        dto = new AdminDTO();
        dto.setUserId(809069269852618753L);
        dto.setCreatedTime(sysUserService.getById(809069269852618753L).getCreatedTime());
        tempProducer.sendMessage("AdminTopic:nnut", dto);
    }

    @Autowired
    UserInfoService userInfoService;
    @Test
    void testInsert() {
        for (int i = 0; i < MAJOR_CODE.size(); i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setDiscipline(MAJOR_CODE.get(i).substring(0, 2));
            userInfo.setMajor(MAJOR_CODE.get(i));
            userInfo.setAddNumber((long) (i + 10));
            userInfo.setTotalNumber((long) (i + 20));
            userInfo.setDateTime("2022-12-11");
            userInfoService.save(userInfo);
        }
    }

}
