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
 * @TableName user_major_pedagogy
 */
@TableName(value ="user_major_pedagogy")
@Data
public class UserMajorPedagogy implements Serializable {
    /**
     * 教育学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增教育学专业用户总数, Total Number of 0401 Major Users
     */
    private Long tn0401mu;

    /**
     * 今日新增教育学专业用户数, Number of New 0401 Major Users Today
     */
    private Long nn0401mut;

    /**
     * 截至今日新增心理学专业用户总数, Total Number of 0402 Major Users
     */
    private Long tn0402mu;

    /**
     * 今日新增心理学专业用户数, Number of New 0402 Major Users Today
     */
    private Long nn0402mut;

    /**
     * 截至今日新增体育学专业用户总数, Total Number of 0403 Major Users
     */
    private Long tn0403mu;

    /**
     * 今日新增体育学专业用户数, Number of New 0403 Major Users Today
     */
    private Long nn0403mut;

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
        UserMajorPedagogy other = (UserMajorPedagogy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn0401mu() == null ? other.getTn0401mu() == null : this.getTn0401mu().equals(other.getTn0401mu()))
            && (this.getNn0401mut() == null ? other.getNn0401mut() == null : this.getNn0401mut().equals(other.getNn0401mut()))
            && (this.getTn0402mu() == null ? other.getTn0402mu() == null : this.getTn0402mu().equals(other.getTn0402mu()))
            && (this.getNn0402mut() == null ? other.getNn0402mut() == null : this.getNn0402mut().equals(other.getNn0402mut()))
            && (this.getTn0403mu() == null ? other.getTn0403mu() == null : this.getTn0403mu().equals(other.getTn0403mu()))
            && (this.getNn0403mut() == null ? other.getNn0403mut() == null : this.getNn0403mut().equals(other.getNn0403mut()))
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
        result = prime * result + ((getTn0401mu() == null) ? 0 : getTn0401mu().hashCode());
        result = prime * result + ((getNn0401mut() == null) ? 0 : getNn0401mut().hashCode());
        result = prime * result + ((getTn0402mu() == null) ? 0 : getTn0402mu().hashCode());
        result = prime * result + ((getNn0402mut() == null) ? 0 : getNn0402mut().hashCode());
        result = prime * result + ((getTn0403mu() == null) ? 0 : getTn0403mu().hashCode());
        result = prime * result + ((getNn0403mut() == null) ? 0 : getNn0403mut().hashCode());
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
        sb.append(", tn0401mu=").append(tn0401mu);
        sb.append(", nn0401mut=").append(nn0401mut);
        sb.append(", tn0402mu=").append(tn0402mu);
        sb.append(", nn0402mut=").append(nn0402mut);
        sb.append(", tn0403mu=").append(tn0403mu);
        sb.append(", nn0403mut=").append(nn0403mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}