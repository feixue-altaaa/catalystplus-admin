package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.paper.PaperJournalResponse;

public interface PaperJournalManager {

    PaperJournalResponse getTotalDataByArea(Long areaId);

}
