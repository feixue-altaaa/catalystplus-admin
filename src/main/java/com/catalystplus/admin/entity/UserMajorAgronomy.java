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
 * @TableName user_major_agronomy
 */
@TableName(value ="user_major_agronomy")
@Data
public class UserMajorAgronomy implements Serializable {
    /**
     * 农学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增作物学专业用户总数, Total Number of 0901 Major Users
     */
    private Long tn0901mu;

    /**
     * 今日新增作物学专业用户数, Number of New 0901 Major Users Today
     */
    private Long nn0901mut;

    /**
     * 截至今日新增园艺学专业用户总数, Total Number of 0902 Major Users
     */
    private Long tn0902mu;

    /**
     * 今日新增园艺学专业用户数, Number of New 0902 Major Users Today
     */
    private Long nn0902mut;

    /**
     * 截至今日新增农业资源与环境专业用户总数, Total Number of 0903 Major Users
     */
    private Long tn0903mu;

    /**
     * 今日新增农业资源与环境专业用户数, Number of New 0903 Major Users Today
     */
    private Long nn0903mut;

    /**
     * 截至今日新增植物保护专业用户总数, Total Number of 0904 Major Users
     */
    private Long tn0904mu;

    /**
     * 今日新增植物保护专业用户数, Number of New 0904 Major Users Today
     */
    private Long nn0904mut;

    /**
     * 截至今日新增畜牧学专业用户总数, Total Number of 0905 Major Users
     */
    private Long tn0905mu;

    /**
     * 今日新增畜牧学专业用户数, Number of New 0905 Major Users Today
     */
    private Long nn0905mut;

    /**
     * 截至今日新增兽医学专业用户总数, Total Number of 0906 Major Users
     */
    private Long tn0906mu;

    /**
     * 今日新增兽医学专业用户数, Number of New 0906 Major Users Today
     */
    private Long nn0906mut;

    /**
     * 截至今日新增林学专业用户总数, Total Number of 0907 Major Users
     */
    private Long tn0907mu;

    /**
     * 今日新增林学专业用户数, Number of New 0907 Major Users Today
     */
    private Long nn0907mut;

    /**
     * 截至今日新增水产专业用户总数, Total Number of 0908 Major Users
     */
    private Long tn0908mu;

    /**
     * 今日新增水产专业用户数, Number of New 0908 Major Users Today
     */
    private Long nn0908mut;

    /**
     * 截至今日新增草学专业用户总数, Total Number of 0909 Major Users
     */
    private Long tn0909mu;

    /**
     * 今日新增草学专业用户数, Number of New 0909 Major Users Today
     */
    private Long nn0909mut;

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
        UserMajorAgronomy other = (UserMajorAgronomy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn0901mu() == null ? other.getTn0901mu() == null : this.getTn0901mu().equals(other.getTn0901mu()))
            && (this.getNn0901mut() == null ? other.getNn0901mut() == null : this.getNn0901mut().equals(other.getNn0901mut()))
            && (this.getTn0902mu() == null ? other.getTn0902mu() == null : this.getTn0902mu().equals(other.getTn0902mu()))
            && (this.getNn0902mut() == null ? other.getNn0902mut() == null : this.getNn0902mut().equals(other.getNn0902mut()))
            && (this.getTn0903mu() == null ? other.getTn0903mu() == null : this.getTn0903mu().equals(other.getTn0903mu()))
            && (this.getNn0903mut() == null ? other.getNn0903mut() == null : this.getNn0903mut().equals(other.getNn0903mut()))
            && (this.getTn0904mu() == null ? other.getTn0904mu() == null : this.getTn0904mu().equals(other.getTn0904mu()))
            && (this.getNn0904mut() == null ? other.getNn0904mut() == null : this.getNn0904mut().equals(other.getNn0904mut()))
            && (this.getTn0905mu() == null ? other.getTn0905mu() == null : this.getTn0905mu().equals(other.getTn0905mu()))
            && (this.getNn0905mut() == null ? other.getNn0905mut() == null : this.getNn0905mut().equals(other.getNn0905mut()))
            && (this.getTn0906mu() == null ? other.getTn0906mu() == null : this.getTn0906mu().equals(other.getTn0906mu()))
            && (this.getNn0906mut() == null ? other.getNn0906mut() == null : this.getNn0906mut().equals(other.getNn0906mut()))
            && (this.getTn0907mu() == null ? other.getTn0907mu() == null : this.getTn0907mu().equals(other.getTn0907mu()))
            && (this.getNn0907mut() == null ? other.getNn0907mut() == null : this.getNn0907mut().equals(other.getNn0907mut()))
            && (this.getTn0908mu() == null ? other.getTn0908mu() == null : this.getTn0908mu().equals(other.getTn0908mu()))
            && (this.getNn0908mut() == null ? other.getNn0908mut() == null : this.getNn0908mut().equals(other.getNn0908mut()))
            && (this.getTn0909mu() == null ? other.getTn0909mu() == null : this.getTn0909mu().equals(other.getTn0909mu()))
            && (this.getNn0909mut() == null ? other.getNn0909mut() == null : this.getNn0909mut().equals(other.getNn0909mut()))
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
        result = prime * result + ((getTn0901mu() == null) ? 0 : getTn0901mu().hashCode());
        result = prime * result + ((getNn0901mut() == null) ? 0 : getNn0901mut().hashCode());
        result = prime * result + ((getTn0902mu() == null) ? 0 : getTn0902mu().hashCode());
        result = prime * result + ((getNn0902mut() == null) ? 0 : getNn0902mut().hashCode());
        result = prime * result + ((getTn0903mu() == null) ? 0 : getTn0903mu().hashCode());
        result = prime * result + ((getNn0903mut() == null) ? 0 : getNn0903mut().hashCode());
        result = prime * result + ((getTn0904mu() == null) ? 0 : getTn0904mu().hashCode());
        result = prime * result + ((getNn0904mut() == null) ? 0 : getNn0904mut().hashCode());
        result = prime * result + ((getTn0905mu() == null) ? 0 : getTn0905mu().hashCode());
        result = prime * result + ((getNn0905mut() == null) ? 0 : getNn0905mut().hashCode());
        result = prime * result + ((getTn0906mu() == null) ? 0 : getTn0906mu().hashCode());
        result = prime * result + ((getNn0906mut() == null) ? 0 : getNn0906mut().hashCode());
        result = prime * result + ((getTn0907mu() == null) ? 0 : getTn0907mu().hashCode());
        result = prime * result + ((getNn0907mut() == null) ? 0 : getNn0907mut().hashCode());
        result = prime * result + ((getTn0908mu() == null) ? 0 : getTn0908mu().hashCode());
        result = prime * result + ((getNn0908mut() == null) ? 0 : getNn0908mut().hashCode());
        result = prime * result + ((getTn0909mu() == null) ? 0 : getTn0909mu().hashCode());
        result = prime * result + ((getNn0909mut() == null) ? 0 : getNn0909mut().hashCode());
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
        sb.append(", tn0901mu=").append(tn0901mu);
        sb.append(", nn0901mut=").append(nn0901mut);
        sb.append(", tn0902mu=").append(tn0902mu);
        sb.append(", nn0902mut=").append(nn0902mut);
        sb.append(", tn0903mu=").append(tn0903mu);
        sb.append(", nn0903mut=").append(nn0903mut);
        sb.append(", tn0904mu=").append(tn0904mu);
        sb.append(", nn0904mut=").append(nn0904mut);
        sb.append(", tn0905mu=").append(tn0905mu);
        sb.append(", nn0905mut=").append(nn0905mut);
        sb.append(", tn0906mu=").append(tn0906mu);
        sb.append(", nn0906mut=").append(nn0906mut);
        sb.append(", tn0907mu=").append(tn0907mu);
        sb.append(", nn0907mut=").append(nn0907mut);
        sb.append(", tn0908mu=").append(tn0908mu);
        sb.append(", nn0908mut=").append(nn0908mut);
        sb.append(", tn0909mu=").append(tn0909mu);
        sb.append(", nn0909mut=").append(nn0909mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}