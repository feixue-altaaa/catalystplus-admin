package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.entity.*;
import com.catalystplus.admin.manager.JournalManager;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.journal.JournalSimpleResponse;
import com.catalystplus.admin.service.*;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;
import com.catalystplus.admin.vo.journal.ModifyPublisherVo;
import com.catalystplus.admin.vo.journal.ModifySubjectVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.PAGE_TOTAL;

/**
 * @Author 蓝染
 * @Date 2022/10/24 10:33
 * @Version 1.1
 */
@Slf4j
@Service
public class JournalManagerImpl implements JournalManager {

    @Autowired
    JournalService journalService;
    @Autowired
    SubjectJournalService subjectJournalService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    AreaService areaService;
    @Autowired
    PublisherService publisherService;


    @Override
    public List<JournalSimpleResponse> getJournalBySubjectId(JournalBySubjectIdVo journalBySubjectIdVo) {

        //1. 初始化
        Long subjectId = journalBySubjectIdVo.getSubjectId();


        //2. 是否喜欢期刊，喜欢在期刊里面把favourite置为true
        List<Journal> journals = journalService.getJournalBySubjectId(subjectId, journalBySubjectIdVo.getPageNo(), journalBySubjectIdVo.getPageSize());
        log.info("journals: {}", journals);
        List<JournalSimpleResponse> journalSimpleResponses = Lists.newArrayList();

        journals.forEach(journal -> {
            JournalSimpleResponse journalSimpleResponse = new JournalSimpleResponse();
            BeanUtils.copyProperties(journal, journalSimpleResponse);
            journalSimpleResponses.add(journalSimpleResponse);
        });
        journals.clear();

        //3. 先根据分区排序，再根据英文名排序
        // return journalResponses.parallelStream().sorted(Comparator.comparing(JournalResponse::getQuartile).thenComparing(JournalResponse::getEnName)).collect(Collectors.toList());
        return journalSimpleResponses;
    }

    @Override
    public void updateJournalBySubjectId(ModifySubjectVo modifySubjectVo) {

        Long journalId = modifySubjectVo.getJournalId();
        Long sourceSubjectId = modifySubjectVo.getSourceSubjectId();
        Long targetSubjectId = modifySubjectVo.getTargetSubjectId();

        subjectJournalService.updateJournalBySubjectId(journalId, sourceSubjectId, targetSubjectId);
    }

    @Override
    public void updateJournalByPublisherId(ModifyPublisherVo modifyPublisherVo) {


    }

    @Override
    public List<JournalResponse> getJournal(JournalBySubjectIdVo journalBySubjectIdVo) {

        //1. 初始化
        List<JournalResponse> journalResponses = Lists.newArrayList();

        //2. 查询journal
        Page<Journal> journalPage = new Page<>(journalBySubjectIdVo.getPageNo(), journalBySubjectIdVo.getPageSize());
        Page<Journal> page = journalService.page(journalPage);
        PAGE_TOTAL.set(journalPage.getTotal());
        List<Journal> journals = page.getRecords();

        //3. 组装响应
        journals.forEach(journal -> {
            JournalResponse journalResponse = new JournalResponse();
            BeanUtils.copyProperties(journal, journalResponse);
            journalResponses.add(journalResponse);
        });
        journals.clear();

        //3. 先根据分区排序，再根据英文名排序
        // return journalResponses.parallelStream().sorted(Comparator.comparing(JournalResponse::getQuartile).thenComparing(JournalResponse::getEnName)).collect(Collectors.toList());
        return journalResponses;
    }

    @Override
    public JournalResponse getJournalByJournalName(JournalByJournalNameVo journalByJournalNameVo) {

        //1. 初始化
        JournalResponse journalResponse = new JournalResponse();

        //2. 根据期刊名称查询journal
        Journal journalByJournalName = journalService.
                getJournalByJournalName(journalByJournalNameVo.getJournalName());
        //3. 根据期刊ID，查找对应领域名称和主题名称
        Subject subject = subjectService.getById(journalByJournalName.getSubjectId());
        Area area = areaService.getById(subject.getAreaId());
        List<Journal> journalByJournalId = journalService.getJournalByJournalId(journalByJournalName.getJournalId());
        List<String> subejctChNames = new ArrayList<>();
        List<Long> subjectIds = new ArrayList<>();
        for(Journal journal:journalByJournalId){
            subejctChNames.add(subjectService.getById(journal.getSubjectId()).getChName());
            subjectIds.add(subjectService.getById(journal.getSubjectId()).getId());
        }
        Publisher publisher = publisherService.getById(journalByJournalName.getPublisherId());

        //4. 组装响应
        BeanUtils.copyProperties(journalByJournalName,journalResponse);
        journalResponse.setAreaChName(area.getChName());
        journalResponse.setSubjectChNames(subejctChNames);
        journalResponse.setSubjectIds(subjectIds);
        journalResponse.setPublisher(publisher.getName());

        return journalResponse;
    }

    @Override
    public List<JournalSimpleResponse> getJournalByFuzzyQuery(JournalByJournalNameVo journalByJournalNameVo) {

        //1. 初始化
        List<JournalSimpleResponse> journalSimpleResponses = new ArrayList<>();

        //2. 根据名称模糊查询期刊
        List<Journal> journalsByFuzzyQuery = journalService.getJournalByFuzzyQuery(journalByJournalNameVo);

        //3. 组装响应
        journalsByFuzzyQuery.forEach(journal -> {
            JournalSimpleResponse journalSimpleResponse = new JournalSimpleResponse();
            BeanUtils.copyProperties(journal,journalSimpleResponse);
            journalSimpleResponses.add(journalSimpleResponse);
        });
        journalsByFuzzyQuery.clear();

        return journalSimpleResponses;
    }


}
