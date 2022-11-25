package com.catalystplus.admin.response.paperCount;


import lombok.Data;

@Data
public class PaperCountResponse {

    /**
     * 领域ID
     */
    private Long areaId;

    /**
     * 主题ID，当type==2时，表示某领域下主题。type==1、3时，为默认值
     */
    private Long subjectId;

    /**
     * 当type==1时，表示一个领域下的期刊总数；当type==2时，表示一个领域的主题下的期刊总数，当type==3时，表示数据库期刊总数
     */
    private Long journalTotal;

    /**
     * 当type==1时，表示一个领域下的文献总数；当type==2时，表示一个领域的主题下的文献总数，当type==3时，表示数据库文章总数
     */
    private Long paperTotal;

    /**
     * 当type==1时，表示一个领域下的今日新增期刊数；当type==2时，表示一个领域的主题下的今日新增期刊数，当type==3时，表示数据库今日期刊新增总数
     */
    private Long todayJournal;

    /**
     * 当type==1时，表示一个领域下的今日新增文献数；当type==2时，表示一个领域的主题下的今日新增文献数，当type==3时，表示数据库今日文章新增总数
     */
    private Long todayPaper;


}
