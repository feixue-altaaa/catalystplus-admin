package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.manager.JournalManager;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.journal.JournalSimpleResponse;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JournalManagerImplTest {

    @Autowired
    JournalManager journalManager;
    @Autowired
    JournalService journalService;

    @Test
    void getJournalBySubjectId() {
    }

    @Test
    void updateJournalBySubjectId() {
    }

    @Test
    void updateJournalByPublisherId() {
    }

    @Test
    void updateJournal() {
    }

    @Test
    void getJournal() {
    }

    @Test
    void getJournalByJournalName() {
    }

    @Test
    void getJournalByFuzzyQuery() {

        JournalByJournalNameVo journalByJournalNameVo = new JournalByJournalNameVo();
        journalByJournalNameVo.setJournalName("sci");
//        List<JournalSimpleResponse> journalByFuzzyQuery = journalManager.getJournalByFuzzyQuery(journalByJournalNameVo);
//        journalByFuzzyQuery.forEach(journalSimpleResponse -> {
//            System.out.println(journalSimpleResponse);
//        });
        List<JournalSimpleResponse> journalByFuzzyQuery = journalManager.getJournalByFuzzyQuery(journalByJournalNameVo);
        journalByFuzzyQuery.forEach(journalSimpleResponse -> {
            System.out.println(journalSimpleResponse);
        });

//        JournalResponse journalByJournalName = journalManager.getJournalByJournalName(journalByJournalNameVo);
//        System.out.println(journalByJournalName);


    }
}