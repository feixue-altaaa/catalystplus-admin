package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 主题与期刊关联表
 *
 * @TableName subject_journal
 */
@TableName(value = "subject_journal")
@Data
public class SubjectJournal implements Serializable {
    /**
     * 标签id, 使用雪花算法, 关闭自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关联subject表的subject_id
     */
    private Long subjectId;

    /**
     * 关联jounal表的journal_id
     */
    private Long journalId;

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
        SubjectJournal other = (SubjectJournal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSubjectId() == null ? other.getSubjectId() == null : this.getSubjectId().equals(other.getSubjectId()))
                && (this.getJournalId() == null ? other.getJournalId() == null : this.getJournalId().equals(other.getJournalId()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
                && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        result = prime * result + ((getJournalId() == null) ? 0 : getJournalId().hashCode());
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
        sb.append(", subjectId=").append(subjectId);
        sb.append(", journalId=").append(journalId);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}