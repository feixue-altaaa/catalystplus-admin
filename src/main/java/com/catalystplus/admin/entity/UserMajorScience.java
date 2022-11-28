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
 * @TableName user_major_science
 */
@TableName(value ="user_major_science")
@Data
public class UserMajorScience implements Serializable {
    /**
     * 理学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增数学专业用户总数, Total Number of 0701 Major Users
     */
    private Long tn0701mu;

    /**
     * 今日新增数学专业用户数, Number of New 0701 Major Users Today
     */
    private Long nn0701mut;

    /**
     * 截至今日新增物理学专业用户总数, Total Number of 0702 Major Users
     */
    private Long tn0702mu;

    /**
     * 今日新增物理学专业用户数, Number of New 0702 Major Users Today
     */
    private Long nn0702mut;

    /**
     * 截至今日新增化学专业用户总数, Total Number of 0703 Major Users
     */
    private Long tn0703mu;

    /**
     * 今日新增化学专业用户数, Number of New 0703 Major Users Today
     */
    private Long nn0703mut;

    /**
     * 截至今日新增天文学专业用户总数, Total Number of 0704 Major Users
     */
    private Long tn0704mu;

    /**
     * 今日新增天文学专业用户数, Number of New 0704 Major Users Today
     */
    private Long nn0704mut;

    /**
     * 截至今日新增地理学专业用户总数, Total Number of 0705 Major Users
     */
    private Long tn0705mu;

    /**
     * 今日新增地理学专业用户数, Number of New 0705 Major Users Today
     */
    private Long nn0705mut;

    /**
     * 截至今日新增大气科学专业用户总数, Total Number of 0706 Major Users
     */
    private Long tn0706mu;

    /**
     * 今日新增大气科学专业用户数, Number of New 0706 Major Users Today
     */
    private Long nn0706mut;

    /**
     * 截至今日新增海洋科学专业用户总数, Total Number of 0707 Major Users
     */
    private Long tn0707mu;

    /**
     * 今日新增海洋科学专业用户数, Number of New 0707 Major Users Today
     */
    private Long nn0707mut;

    /**
     * 截至今日新增地球物理学专业用户总数, Total Number of 0708 Major Users
     */
    private Long tn0708mu;

    /**
     * 今日新增地球物理学专业用户数, Number of New 0708 Major Users Today
     */
    private Long nn0708mut;

    /**
     * 截至今日新增地质学专业用户总数, Total Number of 0709 Major Users
     */
    private Long tn0709mu;

    /**
     * 今日新增地质学专业用户数, Number of New 0709 Major Users Today
     */
    private Long nn0709mut;

    /**
     * 截至今日新增生物学专业用户总数, Total Number of 0710 Major Users
     */
    private Long tn0710mu;

    /**
     * 今日新增生物学专业用户数, Number of New 0710 Major Users Today
     */
    private Long nn0710mut;

    /**
     * 截至今日新增系统科学专业用户总数, Total Number of 0711 Major Users
     */
    private Long tn0711mu;

    /**
     * 今日新增系统科学专业用户数, Number of New 0711 Major Users Today
     */
    private Long nn0711mut;

    /**
     * 截至今日新增科学技术史专业用户总数, Total Number of 0712 Major Users
     */
    private Long tn0712mu;

    /**
     * 今日新增科学技术史专业用户数, Number of New 0712 Major Users Today
     */
    private Long nn0712mut;

    /**
     * 截至今日新增生态学专业用户总数, Total Number of 0713 Major Users
     */
    private Long tn0713mu;

    /**
     * 今日新增生态学专业用户数, Number of New 0713 Major Users Today
     */
    private Long nn0713mut;

    /**
     * 截至今日新增统计学专业用户总数, Total Number of 0714 Major Users
     */
    private Long tn0714mu;

    /**
     * 今日新增统计学专业用户数, Number of New 0714 Major Users Today
     */
    private Long nn0714mut;

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
        UserMajorScience other = (UserMajorScience) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn0701mu() == null ? other.getTn0701mu() == null : this.getTn0701mu().equals(other.getTn0701mu()))
            && (this.getNn0701mut() == null ? other.getNn0701mut() == null : this.getNn0701mut().equals(other.getNn0701mut()))
            && (this.getTn0702mu() == null ? other.getTn0702mu() == null : this.getTn0702mu().equals(other.getTn0702mu()))
            && (this.getNn0702mut() == null ? other.getNn0702mut() == null : this.getNn0702mut().equals(other.getNn0702mut()))
            && (this.getTn0703mu() == null ? other.getTn0703mu() == null : this.getTn0703mu().equals(other.getTn0703mu()))
            && (this.getNn0703mut() == null ? other.getNn0703mut() == null : this.getNn0703mut().equals(other.getNn0703mut()))
            && (this.getTn0704mu() == null ? other.getTn0704mu() == null : this.getTn0704mu().equals(other.getTn0704mu()))
            && (this.getNn0704mut() == null ? other.getNn0704mut() == null : this.getNn0704mut().equals(other.getNn0704mut()))
            && (this.getTn0705mu() == null ? other.getTn0705mu() == null : this.getTn0705mu().equals(other.getTn0705mu()))
            && (this.getNn0705mut() == null ? other.getNn0705mut() == null : this.getNn0705mut().equals(other.getNn0705mut()))
            && (this.getTn0706mu() == null ? other.getTn0706mu() == null : this.getTn0706mu().equals(other.getTn0706mu()))
            && (this.getNn0706mut() == null ? other.getNn0706mut() == null : this.getNn0706mut().equals(other.getNn0706mut()))
            && (this.getTn0707mu() == null ? other.getTn0707mu() == null : this.getTn0707mu().equals(other.getTn0707mu()))
            && (this.getNn0707mut() == null ? other.getNn0707mut() == null : this.getNn0707mut().equals(other.getNn0707mut()))
            && (this.getTn0708mu() == null ? other.getTn0708mu() == null : this.getTn0708mu().equals(other.getTn0708mu()))
            && (this.getNn0708mut() == null ? other.getNn0708mut() == null : this.getNn0708mut().equals(other.getNn0708mut()))
            && (this.getTn0709mu() == null ? other.getTn0709mu() == null : this.getTn0709mu().equals(other.getTn0709mu()))
            && (this.getNn0709mut() == null ? other.getNn0709mut() == null : this.getNn0709mut().equals(other.getNn0709mut()))
            && (this.getTn0710mu() == null ? other.getTn0710mu() == null : this.getTn0710mu().equals(other.getTn0710mu()))
            && (this.getNn0710mut() == null ? other.getNn0710mut() == null : this.getNn0710mut().equals(other.getNn0710mut()))
            && (this.getTn0711mu() == null ? other.getTn0711mu() == null : this.getTn0711mu().equals(other.getTn0711mu()))
            && (this.getNn0711mut() == null ? other.getNn0711mut() == null : this.getNn0711mut().equals(other.getNn0711mut()))
            && (this.getTn0712mu() == null ? other.getTn0712mu() == null : this.getTn0712mu().equals(other.getTn0712mu()))
            && (this.getNn0712mut() == null ? other.getNn0712mut() == null : this.getNn0712mut().equals(other.getNn0712mut()))
            && (this.getTn0713mu() == null ? other.getTn0713mu() == null : this.getTn0713mu().equals(other.getTn0713mu()))
            && (this.getNn0713mut() == null ? other.getNn0713mut() == null : this.getNn0713mut().equals(other.getNn0713mut()))
            && (this.getTn0714mu() == null ? other.getTn0714mu() == null : this.getTn0714mu().equals(other.getTn0714mu()))
            && (this.getNn0714mut() == null ? other.getNn0714mut() == null : this.getNn0714mut().equals(other.getNn0714mut()))
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
        result = prime * result + ((getTn0701mu() == null) ? 0 : getTn0701mu().hashCode());
        result = prime * result + ((getNn0701mut() == null) ? 0 : getNn0701mut().hashCode());
        result = prime * result + ((getTn0702mu() == null) ? 0 : getTn0702mu().hashCode());
        result = prime * result + ((getNn0702mut() == null) ? 0 : getNn0702mut().hashCode());
        result = prime * result + ((getTn0703mu() == null) ? 0 : getTn0703mu().hashCode());
        result = prime * result + ((getNn0703mut() == null) ? 0 : getNn0703mut().hashCode());
        result = prime * result + ((getTn0704mu() == null) ? 0 : getTn0704mu().hashCode());
        result = prime * result + ((getNn0704mut() == null) ? 0 : getNn0704mut().hashCode());
        result = prime * result + ((getTn0705mu() == null) ? 0 : getTn0705mu().hashCode());
        result = prime * result + ((getNn0705mut() == null) ? 0 : getNn0705mut().hashCode());
        result = prime * result + ((getTn0706mu() == null) ? 0 : getTn0706mu().hashCode());
        result = prime * result + ((getNn0706mut() == null) ? 0 : getNn0706mut().hashCode());
        result = prime * result + ((getTn0707mu() == null) ? 0 : getTn0707mu().hashCode());
        result = prime * result + ((getNn0707mut() == null) ? 0 : getNn0707mut().hashCode());
        result = prime * result + ((getTn0708mu() == null) ? 0 : getTn0708mu().hashCode());
        result = prime * result + ((getNn0708mut() == null) ? 0 : getNn0708mut().hashCode());
        result = prime * result + ((getTn0709mu() == null) ? 0 : getTn0709mu().hashCode());
        result = prime * result + ((getNn0709mut() == null) ? 0 : getNn0709mut().hashCode());
        result = prime * result + ((getTn0710mu() == null) ? 0 : getTn0710mu().hashCode());
        result = prime * result + ((getNn0710mut() == null) ? 0 : getNn0710mut().hashCode());
        result = prime * result + ((getTn0711mu() == null) ? 0 : getTn0711mu().hashCode());
        result = prime * result + ((getNn0711mut() == null) ? 0 : getNn0711mut().hashCode());
        result = prime * result + ((getTn0712mu() == null) ? 0 : getTn0712mu().hashCode());
        result = prime * result + ((getNn0712mut() == null) ? 0 : getNn0712mut().hashCode());
        result = prime * result + ((getTn0713mu() == null) ? 0 : getTn0713mu().hashCode());
        result = prime * result + ((getNn0713mut() == null) ? 0 : getNn0713mut().hashCode());
        result = prime * result + ((getTn0714mu() == null) ? 0 : getTn0714mu().hashCode());
        result = prime * result + ((getNn0714mut() == null) ? 0 : getNn0714mut().hashCode());
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
        sb.append(", tn0701mu=").append(tn0701mu);
        sb.append(", nn0701mut=").append(nn0701mut);
        sb.append(", tn0702mu=").append(tn0702mu);
        sb.append(", nn0702mut=").append(nn0702mut);
        sb.append(", tn0703mu=").append(tn0703mu);
        sb.append(", nn0703mut=").append(nn0703mut);
        sb.append(", tn0704mu=").append(tn0704mu);
        sb.append(", nn0704mut=").append(nn0704mut);
        sb.append(", tn0705mu=").append(tn0705mu);
        sb.append(", nn0705mut=").append(nn0705mut);
        sb.append(", tn0706mu=").append(tn0706mu);
        sb.append(", nn0706mut=").append(nn0706mut);
        sb.append(", tn0707mu=").append(tn0707mu);
        sb.append(", nn0707mut=").append(nn0707mut);
        sb.append(", tn0708mu=").append(tn0708mu);
        sb.append(", nn0708mut=").append(nn0708mut);
        sb.append(", tn0709mu=").append(tn0709mu);
        sb.append(", nn0709mut=").append(nn0709mut);
        sb.append(", tn0710mu=").append(tn0710mu);
        sb.append(", nn0710mut=").append(nn0710mut);
        sb.append(", tn0711mu=").append(tn0711mu);
        sb.append(", nn0711mut=").append(nn0711mut);
        sb.append(", tn0712mu=").append(tn0712mu);
        sb.append(", nn0712mut=").append(nn0712mut);
        sb.append(", tn0713mu=").append(tn0713mu);
        sb.append(", nn0713mut=").append(nn0713mut);
        sb.append(", tn0714mu=").append(tn0714mu);
        sb.append(", nn0714mut=").append(nn0714mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}