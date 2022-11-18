package com.catalystplus.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.controller.AreaController;
import com.catalystplus.admin.controller.JournalController;
import com.catalystplus.admin.controller.PublisherController;
import com.catalystplus.admin.controller.SubjectController;
import com.catalystplus.admin.entity.*;
import com.catalystplus.admin.manager.impl.JournalManagerImpl;
import com.catalystplus.admin.mapper.SubjectMapper;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.area.AreaResponse;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.publisher.PublisherResponse;
import com.catalystplus.admin.response.subject.SubjectResponse;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.service.SysUserService;
import com.catalystplus.admin.service.VisualizeService;
import com.catalystplus.admin.service.impl.AreaServiceImpl;
import com.catalystplus.admin.service.impl.JournalServiceImpl;
import com.catalystplus.admin.service.impl.PublisherServiceImpl;
import com.catalystplus.admin.service.impl.SubjectServiceImpl;
import com.catalystplus.admin.vo.journal.*;
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

//        JournalBySubjectIdVo journalBySubjectIdVo = new JournalBySubjectIdVo();
//        journalBySubjectIdVo.setSubjectId(643L);
//        Response<List<JournalResponse>> journal = journalController.getJournalBySubjectId(journalBySubjectIdVo);
//        log.info("journal: {}", journal);
    }


    @Autowired
    VisualizeService visualizeService;

    @Test
    void adminTest() {
        Visualize visualize = new Visualize();
        visualize.setAu(652L);
        visualizeService.save(visualize);
    }


    @Autowired
    JournalServiceImpl journalService;

    @Test
    void journalTest() {
        Journal journal = journalService.getJournalByJournalName("Nature climate change");
        log.info("journal:{}", journal);
        Journal journal1 = journalService.getJournalByJournalName("地球未来");
        log.info("journal:{}", journal1);

    }


    @Autowired
    SubjectServiceImpl subjectService;
    @Autowired
    SubjectController subjectController;
    @Autowired
    AreaController areaController;
    @Autowired
    PublisherController publisherController;

    @Test
    void subjectTest() {
//        Page<Subject> page = new Page<>(1, 10);
//        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        subjectLambdaQueryWrapper.groupBy(Subject::getSubjectId);
//        Page<Subject> subjectPage = subjectService.page(page, subjectLambdaQueryWrapper);
//        System.out.println(subjectPage);
//        Subject subjectBySubjectName = subjectMapper.getSubjectBySubjectName("geosciences, multidisciplinary", 2L);
//        log.info("subject:{}",subjectBySubjectName);
//        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        subjectLambdaQueryWrapper.eq(Subject::getEnName,"geosciences, multidisciplinary");
//        subjectLambdaQueryWrapper.and((wrapper)->{
//            wrapper.eq(Subject::getAreaId,2L);
//        });
//        subjectLambdaQueryWrapper.groupBy(Subject::getSubjectId);
//        Subject subject = subjectMapper.selectOne(subjectLambdaQueryWrapper);
//        log.info("subject:{}",subject);

//        SubjectBySubjectNameVo subjectBySubjectNameVo = new SubjectBySubjectNameVo();
//        subjectBySubjectNameVo.setSubjectName("geosciences, multidisciplinary");
//        subjectBySubjectNameVo.setAreaId(2L);
//        Response<SubjectResponse> subject = subjectController.getSubjectBySubjectName(subjectBySubjectNameVo);
//        log.info("subject:{}",subject);
//
//        JournalByJournalNameVo journalByJournalNameVo = new JournalByJournalNameVo();
//        journalByJournalNameVo.setJournalName("Nature climate change");
//        Response<JournalResponse> journal = journalController.getJournalByJournalName(journalByJournalNameVo);
//        log.info("journal:{}",journal);
//
//        AreaByAreaNameVo areaByAreaNameVo = new AreaByAreaNameVo();
//        areaByAreaNameVo.setAreaName("地球科学");
//        Response<AreaResponse> area = areaController.getAreaByAreaName(areaByAreaNameVo);
//        log.info("area:{}",area);
//
//        PublisherByPublisherNameVo publisherByPublisherNameVo = new PublisherByPublisherNameVo();
//        publisherByPublisherNameVo.setPublisherName("elseiver");
//        Response<PublisherResponse> publisher = publisherController.getJournalByJournalName(publisherByPublisherNameVo);
//        log.info("publisher:{}",publisher);

        List<Subject> subjectByAreaId = subjectService.getSubjectByAreaId(1);
        for (Subject subject : subjectByAreaId) {
            log.info("subject:{}", subject);
        }

    }

    @Autowired
    PublisherServiceImpl publisherService;
    @Autowired
    AreaServiceImpl areaService;

    @Test
    void publisherTest() {
//        Publisher elseiver = publisherService.getPublisherByPublisherName("elseiver");
//        log.info("publisher:{}",elseiver);
        Area areaByName = areaService.getAreaByName("物理与天体物理");
        log.info("area：{}", areaByName);
        Area areaByName1 = areaService.getAreaByName("Mathematics");
        log.info("area：{}", areaByName1);
    }


    @Autowired
    JournalManagerImpl journalManager;

    @Test
    void test() {
        JournalByJournalNameVo journalByJournalNameVo = new JournalByJournalNameVo();
        journalByJournalNameVo.setJournalName("Nature climate change");
        JournalResponse journal = journalManager.getJournalByJournalName(journalByJournalNameVo);
        log.info("journal:{}", journal);
    }

//
//    @Autowired
//    JournalServiceImpl journalService;

//    @Autowired
//    JournalService journalService;

    @Test
    void likeTest() {
        String journalName = "nature";
        LambdaQueryWrapper<Journal> journalLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        判断journalName是英文还是中文
        if(journalName.matches("[\u4E00-\u9FA5]+")){
            journalLambdaQueryWrapper.eq(Journal::getChName,journalName).groupBy(Journal::getJournalId);
        }else {
            journalLambdaQueryWrapper.eq(Journal::getEnName, journalName).groupBy(Journal::getJournalId);
        }
        journalLambdaQueryWrapper.like(true, Journal::getEnName, journalName);
        journalLambdaQueryWrapper.like(true, Journal::getEnName, "energy").groupBy(Journal::getJournalId);
        List<Journal> journals = journalService.getBaseMapper().selectList(journalLambdaQueryWrapper);
        System.out.println(journals.size());
        for (Journal journal : journals) {
            System.out.println(journal);
        }

//        List<Journal> nature = journalService.getJournalByFuzzyQuery("nature");
//        nature.forEach(System.out::println);

    }

    @Autowired
    SysUserService sysUserService;

    @Test
    void userTest() {
        SysUser byId = sysUserService.getById(10L);
        log.info("byId: {}", byId);
    }

    @Test
    void updateTest(){
        ModifyJournalVo modifyJournalVo = new ModifyJournalVo();
        modifyJournalVo.setJournalId(1);
        modifyJournalVo.setSourceQuartile(1);
        modifyJournalVo.setTargetQuartile(2);

        journalService.updateJournal(modifyJournalVo);
        log.info("更新结束");
    }


}
