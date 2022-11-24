package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.entity.PaperJournalData;
import com.catalystplus.admin.manager.PaperJournalManager;
import com.catalystplus.admin.mapper.JournalMapper;
import com.catalystplus.admin.mapper.PaperMapper;
import com.catalystplus.admin.response.paper.PaperJournalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PaperJournalManagerImpl implements PaperJournalManager {

    // TODO: 2022/11/24 mapper改成service
    @Autowired
    JournalMapper journalMapper;
    @Autowired
    PaperMapper paperMapper;

    @Override
    public PaperJournalResponse getTotalDataByArea(Long areaId) {
        //1. 初始化
        PaperJournalResponse paperJournalResponse = new PaperJournalResponse();

        //2. 获取期刊文章总数
        PaperJournalData paperJournalData = new PaperJournalData();
        paperJournalData.setAreaId(0L);
        paperJournalData.setJournalTotal(journalMapper.getJournalTotal());
        paperJournalData.setTodayJournalTotal(journalMapper.getTodayJournalTotal());
        paperJournalData.setPaperTotal(paperMapper.getpaperTotal());
        paperJournalData.setTodayPaperTotal(paperMapper.getTodayPaperTotal());
        paperJournalResponse.setTotalPaperJournalData(paperJournalData);

        //3. 获取不同领域下期刊文章总数
        List<PaperJournalData> paperJournalDatas = new ArrayList<>();
        for (Long i = 1L; i <= 18; i++) {
            PaperJournalData data = new PaperJournalData();
            data.setAreaId(i);
            data.setJournalTotal(journalMapper.getJournalTotalByArea(i));
            data.setTodayJournalTotal(journalMapper.getTodayJournalTotalByArea(i));
            data.setPaperTotal(paperMapper.getPaperTotalByArea(i));
            data.setTodayPaperTotal(paperMapper.getTodayPaperTotalByArea(i));
            paperJournalDatas.add(data);
        }

        paperJournalResponse.setTotalPaperJournalData(paperJournalData);
        paperJournalResponse.setPaperJournalDatas(paperJournalDatas);

        return paperJournalResponse;
    }
}
