package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.entity.PaperCount;
import com.catalystplus.admin.entity.Subject;
import com.catalystplus.admin.manager.PaperCountManager;
import com.catalystplus.admin.response.paperCount.PaperCountResponse;
import com.catalystplus.admin.response.paperCount.RiseResponse;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.service.PaperCountService;
import com.catalystplus.admin.service.PaperService;
import com.catalystplus.admin.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@CrossOrigin
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
     * insertFlag标志位==1时，根据paper_count表中之前数据来插入新数据
     * insertFlag标志位==2时，根据database重新插入数据，矫正paper_count中数据
     * insertFlag标志位==3时，根据paper_count表中之前数据，保留paper、journal总数，插入新数据
     */


    @Override
    public void insertPaperCountTotal(Integer insertFlag) {
        PaperCount paperCount = new PaperCount();
        paperCount.setType(3);

        PaperCount totalPaperJournal = paperCountService.getTotalPaperJournal();

        if(insertFlag == 1 || insertFlag == 2) {
            paperCount.setTodayPaper(paperService.getTodayPaperTotal());
            paperCount.setTodayJournal(journalService.getTodayJournalTotal());
        }
        if(insertFlag == 1){
            paperCount.setPaperTotal(totalPaperJournal.getPaperTotal()+paperService.getTodayPaperTotal());
            paperCount.setJournalTotal(journalService.getTodayJournalTotal()+totalPaperJournal.getJournalTotal());
        }else if(insertFlag == 2){
            paperCount.setPaperTotal(paperService.getpaperTotal());
            paperCount.setJournalTotal(journalService.getJournalTotal());
        }else if(insertFlag == 3){
            paperCount.setPaperTotal(totalPaperJournal.getPaperTotal());
            paperCount.setJournalTotal(totalPaperJournal.getJournalTotal());
        }

        paperCountService.insertPaperCount(paperCount);
        log.info("插入成功");
    }


    /**
     * 插入根据领域划分的文章期刊总数
     */
    @Override
    public void insertPaperCountByArea(Integer insertFlag) {

        //获取每个领域下文章期刊总数
        for (Long areaId = 1L; areaId <= 18; areaId++) {
            PaperCount paperCount = new PaperCount();
            paperCount.setType(1);
            paperCount.setAreaId(areaId);
            PaperCount totalPaperJournalByArea = paperCountService.getTotalPaperJournalByArea(areaId);

            if(insertFlag == 1 || insertFlag == 2) {
                paperCount.setTodayPaper(paperService.getTodayPaperTotalByArea(areaId));
                paperCount.setTodayJournal(journalService.getTodayJournalTotalByArea(areaId));
            }

            if(insertFlag == 1){
                paperCount.setPaperTotal(paperService.getTodayPaperTotalByArea(areaId)+totalPaperJournalByArea.getPaperTotal());
                paperCount.setJournalTotal(journalService.getTodayJournalTotalByArea(areaId)+totalPaperJournalByArea.getJournalTotal());
            }else if(insertFlag == 2){
                paperCount.setPaperTotal(paperService.getPaperTotalByArea(areaId));
                paperCount.setJournalTotal(journalService.getJournalTotalByArea(areaId));
            }else if(insertFlag == 3){
                paperCount.setPaperTotal(totalPaperJournalByArea.getPaperTotal());
                paperCount.setJournalTotal(totalPaperJournalByArea.getJournalTotal());
            }

            paperCountService.insertPaperCount(paperCount);
        }

    }


    /**
     * 插入根据领域主题划分的文章期刊总数
     */
    @Override
    public void insertPaperCountByAreaAndSubject(Integer insertFlag) {

        for (Long areaId = 1L; areaId <= 18L; areaId++) {
            List<Subject> subjectByAreaId = subjectService.getSubjectByAreaId(areaId);
            for (Subject subject : subjectByAreaId) {
                PaperCount paperCount = new PaperCount();
                paperCount.setType(2);
                paperCount.setAreaId(areaId);
                paperCount.setSubjectId(subject.getSubjectId());
                PaperCount totalPaperJournalBySubject = paperCountService.getTotalPaperJournalBySubject(areaId, subject.getSubjectId());

                if(insertFlag == 1 || insertFlag == 2) {
                    paperCount.setTodayPaper(paperService.getTodayPaperTotalBySubject(subject.getSubjectId()));
                    paperCount.setTodayJournal(journalService.getTodayJournalTotalBySubject(subject.getSubjectId()));
                }

                if(insertFlag == 1){
                    paperCount.setPaperTotal(paperService.getTodayPaperTotalBySubject(subject.getSubjectId())+totalPaperJournalBySubject.getPaperTotal());
                    paperCount.setJournalTotal(journalService.getTodayJournalTotalBySubject(subject.getSubjectId())+totalPaperJournalBySubject.getJournalTotal());
                }else if(insertFlag == 2){
                    paperCount.setPaperTotal(paperService.getPaperTotalBySubject(subject.getSubjectId()));
                    paperCount.setJournalTotal(journalService.getJournalTotalBySubject(subject.getSubjectId()));
                }else if(insertFlag == 3){
                    paperCount.setPaperTotal(totalPaperJournalBySubject.getPaperTotal());
                    paperCount.setJournalTotal(totalPaperJournalBySubject.getJournalTotal());
                }

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

    @Override
    public RiseResponse getPaperJournalRise() {

        //1. 初始化
        RiseResponse riseResponse = new RiseResponse();

        //2. 获取昨日文章期刊总数及今日新增
        PaperCount paperCountpre = paperCountService.getPaperCountpre();
        PaperCount paperCountLatest = paperCountService.getPaperCountLatest();

        //3. 组装响应
        if(null != paperCountpre && null != paperCountLatest){
            System.out.println(paperCountpre.toString());
            System.out.println(paperCountLatest);
            riseResponse.setPaperRise(paperCountLatest.getTodayPaper()*1.0/paperCountpre.getPaperTotal());
            riseResponse.setJournalRise(paperCountLatest.getTodayJournal()*1.0/paperCountpre.getJournalTotal());
        }

        return riseResponse;
    }
}
