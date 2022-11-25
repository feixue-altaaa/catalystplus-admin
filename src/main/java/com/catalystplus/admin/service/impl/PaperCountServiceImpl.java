package com.catalystplus.admin.service.impl;

import com.catalystplus.admin.entity.PaperCount;
import com.catalystplus.admin.mapper.PaperCountMapper;
import com.catalystplus.admin.service.PaperCountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文献总量计数 服务实现类
 * </p>
 *
 * @author qls
 * @since 2022-11-25
 */
@Service
public class PaperCountServiceImpl extends ServiceImpl<PaperCountMapper, PaperCount> implements PaperCountService {


    @Autowired
    PaperCountMapper paperCountMapper;


    @Override
    public PaperCount getTotalPaperJournal() {
        return paperCountMapper.getTotalPaperJournal();
    }

    @Override
    public PaperCount getTotalPaperJournalByArea(Long areaId) {
        return paperCountMapper.getTotalPaperJournalByArea(areaId);
    }

    @Override
    public PaperCount getTotalPaperJournalBySubject(Long areaId, Long subjectId) {
        return paperCountMapper.getTotalPaperJournalBySubject(areaId,subjectId);
    }

    @Override
    public void insertPaperCount(PaperCount paperCount) {
        paperCountMapper.insert(paperCount);
    }

//    @Override
//    public void insertPaperCount(Long journalTotal, Long paperTotal, Long todayJournal, Long todayPaper) {
//
//    }
//
//    @Override
//    public void insertPaperCountByArea(Long areaId, Long journalTotal, Long paperTotal, Long todayJournal, Long todayPaper) {
//
//    }
}
