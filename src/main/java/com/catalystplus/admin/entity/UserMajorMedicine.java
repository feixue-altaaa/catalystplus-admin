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
 * @TableName user_major_medicine
 */
@TableName(value ="user_major_medicine")
@Data
public class UserMajorMedicine implements Serializable {
    /**
     * 医学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增基础医学专业用户总数, Total Number of 1001 Major Users
     */
    private Long tn1001mu;

    /**
     * 今日新增基础医学专业用户数, Number of New 1001 Major Users Today
     */
    private Long nn1001mut;

    /**
     * 截至今日新增临床医学专业用户总数, Total Number of 1002 Major Users
     */
    private Long tn1002mu;

    /**
     * 今日新增临床医学专业用户数, Number of New 1002 Major Users Today
     */
    private Long nn1002mut;

    /**
     * 截至今日新增口腔医学专业用户总数, Total Number of 1003 Major Users
     */
    private Long tn1003mu;

    /**
     * 今日新增口腔医学专业用户数, Number of New 1003 Major Users Today
     */
    private Long nn1003mut;

    /**
     * 截至今日新增公共卫生与预防医学专业用户总数, Total Number of 1004 Major Users
     */
    private Long tn1004mu;

    /**
     * 今日新增公共卫生与预防医学专业用户数, Number of New 1004 Major Users Today
     */
    private Long nn1004mut;

    /**
     * 截至今日新增中医学专业用户总数, Total Number of 1005 Major Users
     */
    private Long tn1005mu;

    /**
     * 今日新增中医学专业用户数, Number of New 1005 Major Users Today
     */
    private Long nn1005mut;

    /**
     * 截至今日新增中西医结合专业用户总数, Total Number of 1006 Major Users
     */
    private Long tn1006mu;

    /**
     * 今日新增中西医结合专业用户数, Number of New 1006 Major Users Today
     */
    private Long nn1006mut;

    /**
     * 截至今日新增药学专业用户总数, Total Number of 1007 Major Users
     */
    private Long tn1007mu;

    /**
     * 今日新增药学专业用户数, Number of New 1007 Major Users Today
     */
    private Long nn1007mut;

    /**
     * 截至今日新增中药学专业用户总数, Total Number of 1008 Major Users
     */
    private Long tn1008mu;

    /**
     * 今日新增中药学专业用户数, Number of New 1008 Major Users Today
     */
    private Long nn1008mut;

    /**
     * 截至今日新增特种医学专业用户总数, Total Number of 1009 Major Users
     */
    private Long tn1009mu;

    /**
     * 今日新增特种医学专业用户数, Number of New 1009 Major Users Today
     */
    private Long nn1009mut;

    /**
     * 截至今日新增医学技术专业用户总数, Total Number of 1010 Major Users
     */
    private Long tn1010mu;

    /**
     * 今日新增医学技术专业用户数, Number of New 1010 Major Users Today
     */
    private Long nn1010mut;

    /**
     * 截至今日新增护理学专业用户总数, Total Number of 1011 Major Users
     */
    private Long tn1011mu;

    /**
     * 今日新增护理学专业用户数, Number of New 1011 Major Users Today
     */
    private Long nn1011mut;

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
        UserMajorMedicine other = (UserMajorMedicine) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn1001mu() == null ? other.getTn1001mu() == null : this.getTn1001mu().equals(other.getTn1001mu()))
            && (this.getNn1001mut() == null ? other.getNn1001mut() == null : this.getNn1001mut().equals(other.getNn1001mut()))
            && (this.getTn1002mu() == null ? other.getTn1002mu() == null : this.getTn1002mu().equals(other.getTn1002mu()))
            && (this.getNn1002mut() == null ? other.getNn1002mut() == null : this.getNn1002mut().equals(other.getNn1002mut()))
            && (this.getTn1003mu() == null ? other.getTn1003mu() == null : this.getTn1003mu().equals(other.getTn1003mu()))
            && (this.getNn1003mut() == null ? other.getNn1003mut() == null : this.getNn1003mut().equals(other.getNn1003mut()))
            && (this.getTn1004mu() == null ? other.getTn1004mu() == null : this.getTn1004mu().equals(other.getTn1004mu()))
            && (this.getNn1004mut() == null ? other.getNn1004mut() == null : this.getNn1004mut().equals(other.getNn1004mut()))
            && (this.getTn1005mu() == null ? other.getTn1005mu() == null : this.getTn1005mu().equals(other.getTn1005mu()))
            && (this.getNn1005mut() == null ? other.getNn1005mut() == null : this.getNn1005mut().equals(other.getNn1005mut()))
            && (this.getTn1006mu() == null ? other.getTn1006mu() == null : this.getTn1006mu().equals(other.getTn1006mu()))
            && (this.getNn1006mut() == null ? other.getNn1006mut() == null : this.getNn1006mut().equals(other.getNn1006mut()))
            && (this.getTn1007mu() == null ? other.getTn1007mu() == null : this.getTn1007mu().equals(other.getTn1007mu()))
            && (this.getNn1007mut() == null ? other.getNn1007mut() == null : this.getNn1007mut().equals(other.getNn1007mut()))
            && (this.getTn1008mu() == null ? other.getTn1008mu() == null : this.getTn1008mu().equals(other.getTn1008mu()))
            && (this.getNn1008mut() == null ? other.getNn1008mut() == null : this.getNn1008mut().equals(other.getNn1008mut()))
            && (this.getTn1009mu() == null ? other.getTn1009mu() == null : this.getTn1009mu().equals(other.getTn1009mu()))
            && (this.getNn1009mut() == null ? other.getNn1009mut() == null : this.getNn1009mut().equals(other.getNn1009mut()))
            && (this.getTn1010mu() == null ? other.getTn1010mu() == null : this.getTn1010mu().equals(other.getTn1010mu()))
            && (this.getNn1010mut() == null ? other.getNn1010mut() == null : this.getNn1010mut().equals(other.getNn1010mut()))
            && (this.getTn1011mu() == null ? other.getTn1011mu() == null : this.getTn1011mu().equals(other.getTn1011mu()))
            && (this.getNn1011mut() == null ? other.getNn1011mut() == null : this.getNn1011mut().equals(other.getNn1011mut()))
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
        result = prime * result + ((getTn1001mu() == null) ? 0 : getTn1001mu().hashCode());
        result = prime * result + ((getNn1001mut() == null) ? 0 : getNn1001mut().hashCode());
        result = prime * result + ((getTn1002mu() == null) ? 0 : getTn1002mu().hashCode());
        result = prime * result + ((getNn1002mut() == null) ? 0 : getNn1002mut().hashCode());
        result = prime * result + ((getTn1003mu() == null) ? 0 : getTn1003mu().hashCode());
        result = prime * result + ((getNn1003mut() == null) ? 0 : getNn1003mut().hashCode());
        result = prime * result + ((getTn1004mu() == null) ? 0 : getTn1004mu().hashCode());
        result = prime * result + ((getNn1004mut() == null) ? 0 : getNn1004mut().hashCode());
        result = prime * result + ((getTn1005mu() == null) ? 0 : getTn1005mu().hashCode());
        result = prime * result + ((getNn1005mut() == null) ? 0 : getNn1005mut().hashCode());
        result = prime * result + ((getTn1006mu() == null) ? 0 : getTn1006mu().hashCode());
        result = prime * result + ((getNn1006mut() == null) ? 0 : getNn1006mut().hashCode());
        result = prime * result + ((getTn1007mu() == null) ? 0 : getTn1007mu().hashCode());
        result = prime * result + ((getNn1007mut() == null) ? 0 : getNn1007mut().hashCode());
        result = prime * result + ((getTn1008mu() == null) ? 0 : getTn1008mu().hashCode());
        result = prime * result + ((getNn1008mut() == null) ? 0 : getNn1008mut().hashCode());
        result = prime * result + ((getTn1009mu() == null) ? 0 : getTn1009mu().hashCode());
        result = prime * result + ((getNn1009mut() == null) ? 0 : getNn1009mut().hashCode());
        result = prime * result + ((getTn1010mu() == null) ? 0 : getTn1010mu().hashCode());
        result = prime * result + ((getNn1010mut() == null) ? 0 : getNn1010mut().hashCode());
        result = prime * result + ((getTn1011mu() == null) ? 0 : getTn1011mu().hashCode());
        result = prime * result + ((getNn1011mut() == null) ? 0 : getNn1011mut().hashCode());
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
        sb.append(", tn1001mu=").append(tn1001mu);
        sb.append(", nn1001mut=").append(nn1001mut);
        sb.append(", tn1002mu=").append(tn1002mu);
        sb.append(", nn1002mut=").append(nn1002mut);
        sb.append(", tn1003mu=").append(tn1003mu);
        sb.append(", nn1003mut=").append(nn1003mut);
        sb.append(", tn1004mu=").append(tn1004mu);
        sb.append(", nn1004mut=").append(nn1004mut);
        sb.append(", tn1005mu=").append(tn1005mu);
        sb.append(", nn1005mut=").append(nn1005mut);
        sb.append(", tn1006mu=").append(tn1006mu);
        sb.append(", nn1006mut=").append(nn1006mut);
        sb.append(", tn1007mu=").append(tn1007mu);
        sb.append(", nn1007mut=").append(nn1007mut);
        sb.append(", tn1008mu=").append(tn1008mu);
        sb.append(", nn1008mut=").append(nn1008mut);
        sb.append(", tn1009mu=").append(tn1009mu);
        sb.append(", nn1009mut=").append(nn1009mut);
        sb.append(", tn1010mu=").append(tn1010mu);
        sb.append(", nn1010mut=").append(nn1010mut);
        sb.append(", tn1011mu=").append(tn1011mu);
        sb.append(", nn1011mut=").append(nn1011mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}