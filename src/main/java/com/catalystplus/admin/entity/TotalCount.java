package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文献期刊用户总量表
 * @TableName total_count
 */
@TableName(value ="total_count")
@Data
public class TotalCount implements Serializable {
    /**
     * id，自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 今日文章阅读次数
     */
    private Long todayRead;

    /**
     * 今日文章收藏次数
     */
    private Long todayCollect;

    /**
     * 今日文章标签次数
     */
    private Long todayTag;

    /**
     * 今日文章做笔记次数
     */
    private Long todayNote;

    /**
     * 今日点赞热度
     */
    private Long todayGood;

    /**
     * 今日期刊订阅总量
     */
    private Long todaySubscription;

    /**
     * 截至今日文章阅读次数
     */
    private Long readTotal;

    /**
     * 截至今日文章收藏次数
     */
    private Long collectTotal;

    /**
     * 截至今日文章标签次数
     */
    private Long tagTotal;

    /**
     * 截至今日文章做笔记次数
     */
    private Long noteTotal;

    /**
     * 截至今日点赞热度
     */
    private Long goodTotal;

    /**
     * 截至今日期刊订阅总量
     */
    private Long subscriptionTotal;

    /**
     * 今日阅读文章的用户数
     */
    private Long todayReadUser;

    /**
     * 今日文章收藏用户次数
     */
    private Long todayCollectUser;

    /**
     * 今日文章标签用户次数
     */
    private Long todayTagUser;

    /**
     * 今日文章做笔记用户次数
     */
    private Long todayNoteUser;

    /**
     * 今日点赞用户热度
     */
    private Long todayGoodUser;

    /**
     * 今日期刊订阅用户总量
     */
    private Long todaySubscriptionUser;

    /**
     * 截至今日文章阅读用户次数
     */
    private Long readTotalUser;

    /**
     * 截至今日文章收藏用户次数
     */
    private Long collectTotalUser;

    /**
     * 截至今日文章标签用户次数
     */
    private Long tagTotalUser;

    /**
     * 截至今日文章做笔记用户次数
     */
    private Long noteTotalUser;

    /**
     * 截至今日点赞用户热度
     */
    private Long goodTotalUser;

    /**
     * 截至今日期刊订阅用户总量
     */
    private Long subscriptionTotalUser;

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
        TotalCount other = (TotalCount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTodayRead() == null ? other.getTodayRead() == null : this.getTodayRead().equals(other.getTodayRead()))
            && (this.getTodayCollect() == null ? other.getTodayCollect() == null : this.getTodayCollect().equals(other.getTodayCollect()))
            && (this.getTodayTag() == null ? other.getTodayTag() == null : this.getTodayTag().equals(other.getTodayTag()))
            && (this.getTodayNote() == null ? other.getTodayNote() == null : this.getTodayNote().equals(other.getTodayNote()))
            && (this.getTodayGood() == null ? other.getTodayGood() == null : this.getTodayGood().equals(other.getTodayGood()))
            && (this.getTodaySubscription() == null ? other.getTodaySubscription() == null : this.getTodaySubscription().equals(other.getTodaySubscription()))
            && (this.getReadTotal() == null ? other.getReadTotal() == null : this.getReadTotal().equals(other.getReadTotal()))
            && (this.getCollectTotal() == null ? other.getCollectTotal() == null : this.getCollectTotal().equals(other.getCollectTotal()))
            && (this.getTagTotal() == null ? other.getTagTotal() == null : this.getTagTotal().equals(other.getTagTotal()))
            && (this.getNoteTotal() == null ? other.getNoteTotal() == null : this.getNoteTotal().equals(other.getNoteTotal()))
            && (this.getGoodTotal() == null ? other.getGoodTotal() == null : this.getGoodTotal().equals(other.getGoodTotal()))
            && (this.getSubscriptionTotal() == null ? other.getSubscriptionTotal() == null : this.getSubscriptionTotal().equals(other.getSubscriptionTotal()))
            && (this.getTodayReadUser() == null ? other.getTodayReadUser() == null : this.getTodayReadUser().equals(other.getTodayReadUser()))
            && (this.getTodayCollectUser() == null ? other.getTodayCollectUser() == null : this.getTodayCollectUser().equals(other.getTodayCollectUser()))
            && (this.getTodayTagUser() == null ? other.getTodayTagUser() == null : this.getTodayTagUser().equals(other.getTodayTagUser()))
            && (this.getTodayNoteUser() == null ? other.getTodayNoteUser() == null : this.getTodayNoteUser().equals(other.getTodayNoteUser()))
            && (this.getTodayGoodUser() == null ? other.getTodayGoodUser() == null : this.getTodayGoodUser().equals(other.getTodayGoodUser()))
            && (this.getTodaySubscriptionUser() == null ? other.getTodaySubscriptionUser() == null : this.getTodaySubscriptionUser().equals(other.getTodaySubscriptionUser()))
            && (this.getReadTotalUser() == null ? other.getReadTotalUser() == null : this.getReadTotalUser().equals(other.getReadTotalUser()))
            && (this.getCollectTotalUser() == null ? other.getCollectTotalUser() == null : this.getCollectTotalUser().equals(other.getCollectTotalUser()))
            && (this.getTagTotalUser() == null ? other.getTagTotalUser() == null : this.getTagTotalUser().equals(other.getTagTotalUser()))
            && (this.getNoteTotalUser() == null ? other.getNoteTotalUser() == null : this.getNoteTotalUser().equals(other.getNoteTotalUser()))
            && (this.getGoodTotalUser() == null ? other.getGoodTotalUser() == null : this.getGoodTotalUser().equals(other.getGoodTotalUser()))
            && (this.getSubscriptionTotalUser() == null ? other.getSubscriptionTotalUser() == null : this.getSubscriptionTotalUser().equals(other.getSubscriptionTotalUser()))
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
        result = prime * result + ((getTodayCollect() == null) ? 0 : getTodayCollect().hashCode());
        result = prime * result + ((getTodayTag() == null) ? 0 : getTodayTag().hashCode());
        result = prime * result + ((getTodayNote() == null) ? 0 : getTodayNote().hashCode());
        result = prime * result + ((getTodayGood() == null) ? 0 : getTodayGood().hashCode());
        result = prime * result + ((getTodaySubscription() == null) ? 0 : getTodaySubscription().hashCode());
        result = prime * result + ((getReadTotal() == null) ? 0 : getReadTotal().hashCode());
        result = prime * result + ((getCollectTotal() == null) ? 0 : getCollectTotal().hashCode());
        result = prime * result + ((getTagTotal() == null) ? 0 : getTagTotal().hashCode());
        result = prime * result + ((getNoteTotal() == null) ? 0 : getNoteTotal().hashCode());
        result = prime * result + ((getGoodTotal() == null) ? 0 : getGoodTotal().hashCode());
        result = prime * result + ((getSubscriptionTotal() == null) ? 0 : getSubscriptionTotal().hashCode());
        result = prime * result + ((getTodayReadUser() == null) ? 0 : getTodayReadUser().hashCode());
        result = prime * result + ((getTodayCollectUser() == null) ? 0 : getTodayCollectUser().hashCode());
        result = prime * result + ((getTodayTagUser() == null) ? 0 : getTodayTagUser().hashCode());
        result = prime * result + ((getTodayNoteUser() == null) ? 0 : getTodayNoteUser().hashCode());
        result = prime * result + ((getTodayGoodUser() == null) ? 0 : getTodayGoodUser().hashCode());
        result = prime * result + ((getTodaySubscriptionUser() == null) ? 0 : getTodaySubscriptionUser().hashCode());
        result = prime * result + ((getReadTotalUser() == null) ? 0 : getReadTotalUser().hashCode());
        result = prime * result + ((getCollectTotalUser() == null) ? 0 : getCollectTotalUser().hashCode());
        result = prime * result + ((getTagTotalUser() == null) ? 0 : getTagTotalUser().hashCode());
        result = prime * result + ((getNoteTotalUser() == null) ? 0 : getNoteTotalUser().hashCode());
        result = prime * result + ((getGoodTotalUser() == null) ? 0 : getGoodTotalUser().hashCode());
        result = prime * result + ((getSubscriptionTotalUser() == null) ? 0 : getSubscriptionTotalUser().hashCode());
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
        sb.append(", todayCollect=").append(todayCollect);
        sb.append(", todayTag=").append(todayTag);
        sb.append(", todayNote=").append(todayNote);
        sb.append(", todayGood=").append(todayGood);
        sb.append(", todaySubscription=").append(todaySubscription);
        sb.append(", readTotal=").append(readTotal);
        sb.append(", collectTotal=").append(collectTotal);
        sb.append(", tagTotal=").append(tagTotal);
        sb.append(", noteTotal=").append(noteTotal);
        sb.append(", goodTotal=").append(goodTotal);
        sb.append(", subscriptionTotal=").append(subscriptionTotal);
        sb.append(", todayReadUser=").append(todayReadUser);
        sb.append(", todayCollectUser=").append(todayCollectUser);
        sb.append(", todayTagUser=").append(todayTagUser);
        sb.append(", todayNoteUser=").append(todayNoteUser);
        sb.append(", todayGoodUser=").append(todayGoodUser);
        sb.append(", todaySubscriptionUser=").append(todaySubscriptionUser);
        sb.append(", readTotalUser=").append(readTotalUser);
        sb.append(", collectTotalUser=").append(collectTotalUser);
        sb.append(", tagTotalUser=").append(tagTotalUser);
        sb.append(", noteTotalUser=").append(noteTotalUser);
        sb.append(", goodTotalUser=").append(goodTotalUser);
        sb.append(", subscriptionTotalUser=").append(subscriptionTotalUser);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}