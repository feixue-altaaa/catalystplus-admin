package com.catalystplus.admin.consumer;

import com.catalystplus.admin.dto.AdminDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TempProducerTest {


    @Test
    void adminDTOTest(){

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUserId(123L);

    }

}