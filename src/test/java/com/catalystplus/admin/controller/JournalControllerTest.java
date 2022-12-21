package com.catalystplus.admin.controller;

import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.journal.JournalSimpleResponse;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JournalControllerTest {

    @Autowired
    JournalController journalController;

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

        Response<List<JournalSimpleResponse>> journalByFuzzyQuery = journalController.getJournalByFuzzyQuery(journalByJournalNameVo);
        journalByFuzzyQuery.getData().forEach(journalSimpleResponse -> {
            System.out.println(journalSimpleResponse);
        });

    }
}