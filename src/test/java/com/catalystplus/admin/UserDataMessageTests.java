package com.catalystplus.admin;

import com.catalystplus.admin.consumer.TempProducer;
import com.catalystplus.admin.dto.AdminDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class UserDataMessageTests {

    @Autowired
    TempProducer tempProducer;

    @Test
    void testMQ() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUserId(11L);
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

}
