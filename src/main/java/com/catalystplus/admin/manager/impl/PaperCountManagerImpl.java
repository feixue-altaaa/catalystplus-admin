package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.entity.PaperCount;
import com.catalystplus.admin.entity.Subject;
import com.catalystplus.admin.manager.PaperCountManager;
import com.catalystplus.admin.response.paperCount.PaperCountResponse;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.service.PaperCountService;
import com.catalystplus.admin.service.PaperService;
import com.catalystplus.admin.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class PaperCountManagerImpl implements PaperCountManager {

    @Autowired
    PaperService paperService;
    @Autowired
    JournalService journalService;
    @Autowired
    PaperCountService paperCountService;
    @Autowired
    SubjectService subjectService;

    /**
     * 插入数据库文章期刊总数
     */
    @Override
    public void insertPaperCountTotal() {
        PaperCount paperCount = new PaperCount();
        paperCount.setType(3);

        paperCount.setPaperTotal(paperService.getpaperTotal());
        paperCount.setTodayPaper(paperService.getTodayPaperTotal());
        paperCount.setJournalTotal(journalService.getJournalTotal());
        paperCount.setTodayJournal(journalService.getTodayJournalTotal());

        paperCountService.insertPaperCount(paperCount);
        log.info("插入成功");
    }


    /**
     * 插入根据领域划分的文章期刊总数
     */
    @Override
    public void insertPaperCountByArea() {

        //获取每个领域下文章期刊总数
        for (Long areaId = 1L; areaId <= 18; areaId++) {
            PaperCount paperCount = new PaperCount();
            paperCount.setType(1);
            paperCount.setAreaId(areaId);
            paperCount.setPaperTotal(paperService.getPaperTotalByArea(areaId));
            paperCount.setTodayPaper(paperService.getTodayPaperTotalByArea(areaId));
            paperCount.setJournalTotal(journalService.getJournalTotalByArea(areaId));
            paperCount.setTodayJournal(journalService.getTodayJournalTotalByArea(areaId));
            paperCountService.insertPaperCount(paperCount);
        }

    }


    /**
     * 插入根据领域主题划分的文章期刊总数
     */
    @Override
    public void insertPaperCountByAreaAndSubject() {

        for (Long areaId = 1L; areaId <= 18L; areaId++) {
            List<Subject> subjectByAreaId = subjectService.getSubjectByAreaId(areaId);
            for (Subject subject : subjectByAreaId) {
                PaperCount paperCount = new PaperCount();
                paperCount.setType(2);
                paperCount.setAreaId(areaId);
                paperCount.setSubjectId(subject.getSubjectId());
                paperCount.setPaperTotal(paperService.getPaperTotalBySubject(subject.getSubjectId()));
                paperCount.setTodayPaper(paperService.getTodayPaperTotalBySubject(subject.getSubjectId()));
                paperCount.setJournalTotal(journalService.getJournalTotalBySubject(subject.getSubjectId()));
                paperCount.setTodayJournal(journalService.getTodayJournalTotalBySubject(subject.getSubjectId()));
                paperCountService.insertPaperCount(paperCount);
            }

        }
    }

    @Override
    public PaperCountResponse getPaperCount() {
        PaperCountResponse paperCountResponse = new PaperCountResponse();
        PaperCount paperCount = paperCountService.getTotalPaperJournal();
        BeanUtils.copyProperties(paperCount,paperCountResponse);
        return paperCountResponse;
    }

    @Override
    public List<PaperCountResponse> getPaperCountBySubject(Long areaId) {

        //1. 初始化
        List<PaperCountResponse> paperCountResponses = new ArrayList<>();
        List<PaperCount> paperCounts = new ArrayList<>();

        //2. 通过主题划分获取文章期刊总数
        List<Subject> subjectByAreaId = subjectService.getSubjectByAreaId(areaId);
        for (Subject subject : subjectByAreaId) {
            PaperCount paperCount = paperCountService.getTotalPaperJournalBySubject(areaId, subject.getSubjectId());
            paperCounts.add(paperCount);
        }

        //3. 组装响应
        paperCounts.forEach(paperCount -> {
            PaperCountResponse paperCountResponse = new PaperCountResponse();
            BeanUtils.copyProperties(paperCount,paperCountResponse);
            paperCountResponses.add(paperCountResponse);
        });
        return paperCountResponses;
    }

    @Override
    public List<PaperCountResponse> getPaperCountByArea() {

        //1. 初始化
        List<PaperCountResponse> paperCountResponses = new ArrayList<>();
        List<PaperCount> paperCounts = new ArrayList<>();

        //2. 通过领域划分获取文章期刊总数
        for (Long areaId = 1L;areaId<=18L;areaId++){
            paperCounts.add(paperCountService.getTotalPaperJournalByArea(areaId));
        }

        //3. 组装响应
        paperCounts.forEach(paperCount -> {
            PaperCountResponse paperCountResponse = new PaperCountResponse();
            BeanUtils.copyProperties(paperCount,paperCountResponse);
            paperCountResponses.add(paperCountResponse);
        });
        return paperCountResponses;
    }

}
