package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 文献总量计数
 * </p>
 *
 * @author qls
 * @since 2022-11-25
 */
public class PaperCount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 1表示按照领域，2表示按照领域与主题，3表示数据库总数
     */
    private Integer type;

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

    /**
     * 逻辑删除(1:存在，0:不存在)
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间, 数据有变更自动更新时间
     */
    private LocalDateTime updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
    public Long getJournalTotal() {
        return journalTotal;
    }

    public void setJournalTotal(Long journalTotal) {
        this.journalTotal = journalTotal;
    }
    public Long getPaperTotal() {
        return paperTotal;
    }

    public void setPaperTotal(Long paperTotal) {
        this.paperTotal = paperTotal;
    }
    public Long getTodayJournal() {
        return todayJournal;
    }

    public void setTodayJournal(Long todayJournal) {
        this.todayJournal = todayJournal;
    }
    public Long getTodayPaper() {
        return todayPaper;
    }

    public void setTodayPaper(Long todayPaper) {
        this.todayPaper = todayPaper;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "PaperCount{" +
            "id=" + id +
            ", type=" + type +
            ", areaId=" + areaId +
            ", subjectId=" + subjectId +
            ", journalTotal=" + journalTotal +
            ", paperTotal=" + paperTotal +
            ", todayJournal=" + todayJournal +
            ", todayPaper=" + todayPaper +
            ", status=" + status +
            ", createdTime=" + createdTime +
            ", updatedTime=" + updatedTime +
        "}";
    }
}
