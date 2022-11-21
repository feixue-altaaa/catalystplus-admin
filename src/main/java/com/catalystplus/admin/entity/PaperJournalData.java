package com.catalystplus.admin.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class PaperJournalData implements Serializable {

    /**
     * 领域ID
     */
    Long areaId;

    /**
     * 文章总数
     */
    private Long paperTotal;

    /**
     * 今日新增文章总数
     */
    private Long todayPaperTotal;

    /**
     * 期刊总数
     */
    private Long journalTotal;

    /**
     * 今日新增期刊总数
     */
    private Long todayJournalTotal;

}
