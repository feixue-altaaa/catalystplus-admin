package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.paperCount.PaperCountResponse;
import com.catalystplus.admin.response.paperCount.RiseResponse;

import java.util.List;

public interface PaperCountManager {

    void insertPaperCountTotal(Integer insertFlag);

    void insertPaperCountByArea(Integer insertFlag);

    void insertPaperCountByAreaAndSubject(Integer insertFlag);

    PaperCountResponse getPaperCount();

    List<PaperCountResponse> getPaperCountBySubject(Long areaId);

    List<PaperCountResponse> getPaperCountByArea();

    RiseResponse getPaperJournalRise();



}
