package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user_major_history
 */
@TableName(value ="user_major_history")
@Data
public class UserMajorHistory implements Serializable {
    /**
     * 历史学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增考古学专业用户总数, Total Number of 0601 Major Users
     */
    private Long tn0601mu;

    /**
     * 今日新增考古学专业用户数, Number of New 0601 Major Users Today
     */
    private Long nn0601mut;

    /**
     * 截至今日新增中国史专业用户总数, Total Number of 0602 Major Users
     */
    private Long tn0602mu;

    /**
     * 今日新增中国史专业用户数, Number of New 0602 Major Users Today
     */
    private Long nn0602mut;

    /**
     * 截至今日新增世界史专业用户总数, Total Number of 0603 Major Users
     */
    private Long tn0603mu;

    /**
     * 今日新增世界史专业用户数, Number of New 0603 Major Users Today
     */
    private Long nn0603mut;

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
        UserMajorHistory other = (UserMajorHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn0601mu() == null ? other.getTn0601mu() == null : this.getTn0601mu().equals(other.getTn0601mu()))
            && (this.getNn0601mut() == null ? other.getNn0601mut() == null : this.getNn0601mut().equals(other.getNn0601mut()))
            && (this.getTn0602mu() == null ? other.getTn0602mu() == null : this.getTn0602mu().equals(other.getTn0602mu()))
            && (this.getNn0602mut() == null ? other.getNn0602mut() == null : this.getNn0602mut().equals(other.getNn0602mut()))
            && (this.getTn0603mu() == null ? other.getTn0603mu() == null : this.getTn0603mu().equals(other.getTn0603mu()))
            && (this.getNn0603mut() == null ? other.getNn0603mut() == null : this.getNn0603mut().equals(other.getNn0603mut()))
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
        result = prime * result + ((getTn0601mu() == null) ? 0 : getTn0601mu().hashCode());
        result = prime * result + ((getNn0601mut() == null) ? 0 : getNn0601mut().hashCode());
        result = prime * result + ((getTn0602mu() == null) ? 0 : getTn0602mu().hashCode());
        result = prime * result + ((getNn0602mut() == null) ? 0 : getNn0602mut().hashCode());
        result = prime * result + ((getTn0603mu() == null) ? 0 : getTn0603mu().hashCode());
        result = prime * result + ((getNn0603mut() == null) ? 0 : getNn0603mut().hashCode());
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
        sb.append(", tn0601mu=").append(tn0601mu);
        sb.append(", nn0601mut=").append(nn0601mut);
        sb.append(", tn0602mu=").append(tn0602mu);
        sb.append(", nn0602mut=").append(nn0602mut);
        sb.append(", tn0603mu=").append(tn0603mu);
        sb.append(", nn0603mut=").append(nn0603mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}