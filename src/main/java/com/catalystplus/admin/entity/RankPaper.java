package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文献排行表
 * @TableName rank_paper
 */
@TableName(value ="rank_paper")
@Data
public class RankPaper implements Serializable {
    /**
     * 论文id
     */
    @TableId
    private Long id;

    /**
     * 文章今日阅读次数
     */
    private Long todayRead;

    /**
     * 截至今日文章阅读次数
     */
    private Long readTotal;

    /**
     * 今日文章收藏次数
     */
    private Long todayCollect;

    /**
     * 截至今日文章收藏次数
     */
    private Long collectTotal;

    /**
     * 今日文章标签次数
     */
    private Long todayTag;

    /**
     * 截至今日文章标签次数
     */
    private Long tagTotal;

    /**
     * 今日文章做笔记次数
     */
    private Long todayNote;

    /**
     * 截至今日文章做笔记次数
     */
    private Long noteTotal;

    /**
     * 今日点赞热度
     */
    private Long todayGood;

    /**
     * 截至今日点赞热度
     */
    private Long goodTotal;

    /**
     * 当日日期，比如2022-11-26
     */
    private String dateTime;

    /**
     * 逻辑删除(1:存在，0:不存在)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间, 数据有变更自动更新时间
     */
    private Date updatedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RankPaper other = (RankPaper) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTodayRead() == null ? other.getTodayRead() == null : this.getTodayRead().equals(other.getTodayRead()))
            && (this.getReadTotal() == null ? other.getReadTotal() == null : this.getReadTotal().equals(other.getReadTotal()))
            && (this.getTodayCollect() == null ? other.getTodayCollect() == null : this.getTodayCollect().equals(other.getTodayCollect()))
            && (this.getCollectTotal() == null ? other.getCollectTotal() == null : this.getCollectTotal().equals(other.getCollectTotal()))
            && (this.getTodayTag() == null ? other.getTodayTag() == null : this.getTodayTag().equals(other.getTodayTag()))
            && (this.getTagTotal() == null ? other.getTagTotal() == null : this.getTagTotal().equals(other.getTagTotal()))
            && (this.getTodayNote() == null ? other.getTodayNote() == null : this.getTodayNote().equals(other.getTodayNote()))
            && (this.getNoteTotal() == null ? other.getNoteTotal() == null : this.getNoteTotal().equals(other.getNoteTotal()))
            && (this.getTodayGood() == null ? other.getTodayGood() == null : this.getTodayGood().equals(other.getTodayGood()))
            && (this.getGoodTotal() == null ? other.getGoodTotal() == null : this.getGoodTotal().equals(other.getGoodTotal()))
            && (this.getDateTime() == null ? other.getDateTime() == null : this.getDateTime().equals(other.getDateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTodayRead() == null) ? 0 : getTodayRead().hashCode());
        result = prime * result + ((getReadTotal() == null) ? 0 : getReadTotal().hashCode());
        result = prime * result + ((getTodayCollect() == null) ? 0 : getTodayCollect().hashCode());
        result = prime * result + ((getCollectTotal() == null) ? 0 : getCollectTotal().hashCode());
        result = prime * result + ((getTodayTag() == null) ? 0 : getTodayTag().hashCode());
        result = prime * result + ((getTagTotal() == null) ? 0 : getTagTotal().hashCode());
        result = prime * result + ((getTodayNote() == null) ? 0 : getTodayNote().hashCode());
        result = prime * result + ((getNoteTotal() == null) ? 0 : getNoteTotal().hashCode());
        result = prime * result + ((getTodayGood() == null) ? 0 : getTodayGood().hashCode());
        result = prime * result + ((getGoodTotal() == null) ? 0 : getGoodTotal().hashCode());
        result = prime * result + ((getDateTime() == null) ? 0 : getDateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", todayRead=").append(todayRead);
        sb.append(", readTotal=").append(readTotal);
        sb.append(", todayCollect=").append(todayCollect);
        sb.append(", collectTotal=").append(collectTotal);
        sb.append(", todayTag=").append(todayTag);
        sb.append(", tagTotal=").append(tagTotal);
        sb.append(", todayNote=").append(todayNote);
        sb.append(", noteTotal=").append(noteTotal);
        sb.append(", todayGood=").append(todayGood);
        sb.append(", goodTotal=").append(goodTotal);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}