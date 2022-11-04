package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.manager.JournalManager;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.vo.journal.JournalBySubjectIdVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<JournalResponse> getJournalBySubjectId(JournalBySubjectIdVo journalBySubjectIdVo) {

        //1. 初始化
        Long subjectId = journalBySubjectIdVo.getSubjectId();


        //2. 是否喜欢期刊，喜欢在期刊里面把favourite置为true
        List<Journal> journals = journalService.getJournalBySubjectId(subjectId, journalBySubjectIdVo.getPageNo(), journalBySubjectIdVo.getPageSize());
        log.info("journals: {}", journals);
        List<JournalResponse> journalResponses = Lists.newArrayList();

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
    public void updateJournalBySidOrPid(Long journalId, Long subjectId, Long publisherId) {

        Journal journal = new Journal();
        journal.setId(journalId);
        if (Optional.ofNullable(subjectId).isPresent()) {
            journal.setSubjectId(subjectId);
        }
        if (Optional.ofNullable(publisherId).isPresent()) {
            journal.setPublisherId(publisherId);
        }
        if (!journalService.updateById(journal)) {
            throw new RuntimeException("journal期刊更新失败");
        }
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
}
