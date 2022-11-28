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
 * @TableName user_major_management
 */
@TableName(value ="user_major_management")
@Data
public class UserMajorManagement implements Serializable {
    /**
     * 管理学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增管理科学与工程专业用户总数, Total Number of 1201 Major Users
     */
    private Long tn1201mu;

    /**
     * 今日新增管理科学与工程专业用户数, Number of New 1201 Major Users Today
     */
    private Long nn1201mut;

    /**
     * 截至今日新增工商管理专业用户总数, Total Number of 1202 Major Users
     */
    private Long tn1202mu;

    /**
     * 今日新增工商管理专业用户数, Number of New 1202 Major Users Today
     */
    private Long nn1202mut;

    /**
     * 截至今日新增农林经济管理专业用户总数, Total Number of 1203 Major Users
     */
    private Long tn1203mu;

    /**
     * 今日新增农林经济管理专业用户数, Number of New 1203 Major Users Today
     */
    private Long nn1203mut;

    /**
     * 截至今日新增公共管理专业用户总数, Total Number of 1204 Major Users
     */
    private Long tn1204mu;

    /**
     * 今日新增公共管理专业用户数, Number of New 1204 Major Users Today
     */
    private Long nn1204mut;

    /**
     * 截至今日新增图书情报与档案管理专业用户总数, Total Number of 1205 Major Users
     */
    private Long tn1205mu;

    /**
     * 今日新增图书情报与档案管理专业用户数, Number of New 1205 Major Users Today
     */
    private Long nn1205mut;

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
        UserMajorManagement other = (UserMajorManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn1201mu() == null ? other.getTn1201mu() == null : this.getTn1201mu().equals(other.getTn1201mu()))
            && (this.getNn1201mut() == null ? other.getNn1201mut() == null : this.getNn1201mut().equals(other.getNn1201mut()))
            && (this.getTn1202mu() == null ? other.getTn1202mu() == null : this.getTn1202mu().equals(other.getTn1202mu()))
            && (this.getNn1202mut() == null ? other.getNn1202mut() == null : this.getNn1202mut().equals(other.getNn1202mut()))
            && (this.getTn1203mu() == null ? other.getTn1203mu() == null : this.getTn1203mu().equals(other.getTn1203mu()))
            && (this.getNn1203mut() == null ? other.getNn1203mut() == null : this.getNn1203mut().equals(other.getNn1203mut()))
            && (this.getTn1204mu() == null ? other.getTn1204mu() == null : this.getTn1204mu().equals(other.getTn1204mu()))
            && (this.getNn1204mut() == null ? other.getNn1204mut() == null : this.getNn1204mut().equals(other.getNn1204mut()))
            && (this.getTn1205mu() == null ? other.getTn1205mu() == null : this.getTn1205mu().equals(other.getTn1205mu()))
            && (this.getNn1205mut() == null ? other.getNn1205mut() == null : this.getNn1205mut().equals(other.getNn1205mut()))
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
        result = prime * result + ((getTn1201mu() == null) ? 0 : getTn1201mu().hashCode());
        result = prime * result + ((getNn1201mut() == null) ? 0 : getNn1201mut().hashCode());
        result = prime * result + ((getTn1202mu() == null) ? 0 : getTn1202mu().hashCode());
        result = prime * result + ((getNn1202mut() == null) ? 0 : getNn1202mut().hashCode());
        result = prime * result + ((getTn1203mu() == null) ? 0 : getTn1203mu().hashCode());
        result = prime * result + ((getNn1203mut() == null) ? 0 : getNn1203mut().hashCode());
        result = prime * result + ((getTn1204mu() == null) ? 0 : getTn1204mu().hashCode());
        result = prime * result + ((getNn1204mut() == null) ? 0 : getNn1204mut().hashCode());
        result = prime * result + ((getTn1205mu() == null) ? 0 : getTn1205mu().hashCode());
        result = prime * result + ((getNn1205mut() == null) ? 0 : getNn1205mut().hashCode());
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
        sb.append(", tn1201mu=").append(tn1201mu);
        sb.append(", nn1201mut=").append(nn1201mut);
        sb.append(", tn1202mu=").append(tn1202mu);
        sb.append(", nn1202mut=").append(nn1202mut);
        sb.append(", tn1203mu=").append(tn1203mu);
        sb.append(", nn1203mut=").append(nn1203mut);
        sb.append(", tn1204mu=").append(tn1204mu);
        sb.append(", nn1204mut=").append(nn1204mut);
        sb.append(", tn1205mu=").append(tn1205mu);
        sb.append(", nn1205mut=").append(nn1205mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}