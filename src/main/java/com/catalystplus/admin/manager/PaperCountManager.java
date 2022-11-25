package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.paperCount.PaperCountResponse;

import java.util.List;

public interface PaperCountManager {

    void insertPaperCountTotal();

    void insertPaperCountByArea();

    void insertPaperCountByAreaAndSubject();

    PaperCountResponse getPaperCount();

    List<PaperCountResponse> getPaperCountBySubject(Long areaId);

    List<PaperCountResponse> getPaperCountByArea();

}
