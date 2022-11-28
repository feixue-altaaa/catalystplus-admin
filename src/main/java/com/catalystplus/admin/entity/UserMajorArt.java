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
 * @TableName user_major_art
 */
@TableName(value ="user_major_art")
@Data
public class UserMajorArt implements Serializable {
    /**
     * 艺术学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增艺术学理论专业用户总数, Total Number of 1301 Major Users
     */
    private Long tn1301mu;

    /**
     * 今日新增艺术学理论专业用户数, Number of New 1301 Major Users Today
     */
    private Long nn1301mut;

    /**
     * 截至今日新增音乐与舞蹈学专业用户总数, Total Number of 1302 Major Users
     */
    private Long tn1302mu;

    /**
     * 今日新增音乐与舞蹈学专业用户数, Number of New 1302 Major Users Today
     */
    private Long nn1302mut;

    /**
     * 截至今日新增戏剧与影视学专业用户总数, Total Number of 1303 Major Users
     */
    private Long tn1303mu;

    /**
     * 今日新增戏剧与影视学专业用户数, Number of New 1303 Major Users Today
     */
    private Long nn1303mut;

    /**
     * 截至今日新增美术学专业用户总数, Total Number of 1304 Major Users
     */
    private Long tn1304mu;

    /**
     * 今日新增美术学专业用户数, Number of New 1304 Major Users Today
     */
    private Long nn1304mut;

    /**
     * 截至今日新增设计学专业用户总数, Total Number of 1305 Major Users
     */
    private Long tn1305mu;

    /**
     * 今日新增设计学专业用户数, Number of New 1305 Major Users Today
     */
    private Long nn1305mut;

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
        UserMajorArt other = (UserMajorArt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn1301mu() == null ? other.getTn1301mu() == null : this.getTn1301mu().equals(other.getTn1301mu()))
            && (this.getNn1301mut() == null ? other.getNn1301mut() == null : this.getNn1301mut().equals(other.getNn1301mut()))
            && (this.getTn1302mu() == null ? other.getTn1302mu() == null : this.getTn1302mu().equals(other.getTn1302mu()))
            && (this.getNn1302mut() == null ? other.getNn1302mut() == null : this.getNn1302mut().equals(other.getNn1302mut()))
            && (this.getTn1303mu() == null ? other.getTn1303mu() == null : this.getTn1303mu().equals(other.getTn1303mu()))
            && (this.getNn1303mut() == null ? other.getNn1303mut() == null : this.getNn1303mut().equals(other.getNn1303mut()))
            && (this.getTn1304mu() == null ? other.getTn1304mu() == null : this.getTn1304mu().equals(other.getTn1304mu()))
            && (this.getNn1304mut() == null ? other.getNn1304mut() == null : this.getNn1304mut().equals(other.getNn1304mut()))
            && (this.getTn1305mu() == null ? other.getTn1305mu() == null : this.getTn1305mu().equals(other.getTn1305mu()))
            && (this.getNn1305mut() == null ? other.getNn1305mut() == null : this.getNn1305mut().equals(other.getNn1305mut()))
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
        result = prime * result + ((getTn1301mu() == null) ? 0 : getTn1301mu().hashCode());
        result = prime * result + ((getNn1301mut() == null) ? 0 : getNn1301mut().hashCode());
        result = prime * result + ((getTn1302mu() == null) ? 0 : getTn1302mu().hashCode());
        result = prime * result + ((getNn1302mut() == null) ? 0 : getNn1302mut().hashCode());
        result = prime * result + ((getTn1303mu() == null) ? 0 : getTn1303mu().hashCode());
        result = prime * result + ((getNn1303mut() == null) ? 0 : getNn1303mut().hashCode());
        result = prime * result + ((getTn1304mu() == null) ? 0 : getTn1304mu().hashCode());
        result = prime * result + ((getNn1304mut() == null) ? 0 : getNn1304mut().hashCode());
        result = prime * result + ((getTn1305mu() == null) ? 0 : getTn1305mu().hashCode());
        result = prime * result + ((getNn1305mut() == null) ? 0 : getNn1305mut().hashCode());
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
        sb.append(", tn1301mu=").append(tn1301mu);
        sb.append(", nn1301mut=").append(nn1301mut);
        sb.append(", tn1302mu=").append(tn1302mu);
        sb.append(", nn1302mut=").append(nn1302mut);
        sb.append(", tn1303mu=").append(tn1303mu);
        sb.append(", nn1303mut=").append(nn1303mut);
        sb.append(", tn1304mu=").append(tn1304mu);
        sb.append(", nn1304mut=").append(nn1304mut);
        sb.append(", tn1305mu=").append(tn1305mu);
        sb.append(", nn1305mut=").append(nn1305mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}