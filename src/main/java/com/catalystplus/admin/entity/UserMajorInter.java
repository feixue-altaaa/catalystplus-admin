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
 * @TableName user_major_inter
 */
@TableName(value ="user_major_inter")
@Data
public class UserMajorInter implements Serializable {
    /**
     * 交叉学科专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增集成电路科学与工程专业用户总数, Total Number of 1401 Major Users
     */
    private Long tn1401mu;

    /**
     * 今日新增集成电路科学与工程专业用户数, Number of New 1401 Major Users Today
     */
    private Long nn1401mut;

    /**
     * 截至今日新增国家安全学专业用户总数, Total Number of 1402 Major Users
     */
    private Long tn1402mu;

    /**
     * 今日新增国家安全学专业用户数, Number of New 1402 Major Users Today
     */
    private Long nn1402mut;

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
        UserMajorInter other = (UserMajorInter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn1401mu() == null ? other.getTn1401mu() == null : this.getTn1401mu().equals(other.getTn1401mu()))
            && (this.getNn1401mut() == null ? other.getNn1401mut() == null : this.getNn1401mut().equals(other.getNn1401mut()))
            && (this.getTn1402mu() == null ? other.getTn1402mu() == null : this.getTn1402mu().equals(other.getTn1402mu()))
            && (this.getNn1402mut() == null ? other.getNn1402mut() == null : this.getNn1402mut().equals(other.getNn1402mut()))
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
        result = prime * result + ((getTn1401mu() == null) ? 0 : getTn1401mu().hashCode());
        result = prime * result + ((getNn1401mut() == null) ? 0 : getNn1401mut().hashCode());
        result = prime * result + ((getTn1402mu() == null) ? 0 : getTn1402mu().hashCode());
        result = prime * result + ((getNn1402mut() == null) ? 0 : getNn1402mut().hashCode());
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
        sb.append(", tn1401mu=").append(tn1401mu);
        sb.append(", nn1401mut=").append(nn1401mut);
        sb.append(", tn1402mu=").append(tn1402mu);
        sb.append(", nn1402mut=").append(nn1402mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}