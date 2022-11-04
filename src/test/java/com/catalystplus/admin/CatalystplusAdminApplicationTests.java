package com.catalystplus.admin;

import com.catalystplus.admin.controller.JournalController;
import com.catalystplus.admin.entity.Visualize;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.service.VisualizeService;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class CatalystplusAdminApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    JournalController journalController;

    @Test
    void journalBySubjectTest() {

        JournalBySubjectIdVo journalBySubjectIdVo = new JournalBySubjectIdVo();
        journalBySubjectIdVo.setSubjectId(643L);
        Response<List<JournalResponse>> journal = journalController.getJournalBySubjectId(journalBySubjectIdVo);
        log.info("journal: {}", journal);
    }


    @Autowired
    VisualizeService visualizeService;
    @Test
    void adminTest() {
        Visualize visualize = new Visualize();
        visualize.setAu(652L);
        visualizeService.save(visualize);
    }
}
