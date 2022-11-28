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
 * @TableName user_major_jurisprudence
 */
@TableName(value ="user_major_jurisprudence")
@Data
public class UserMajorJurisprudence implements Serializable {
    /**
     * 法学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增法学专业用户总数, Total Number of 0301 Major Users
     */
    private Long tn0301mu;

    /**
     * 今日新增法学专业用户数, Number of New 0301 Major Users Today
     */
    private Long nn0301mut;

    /**
     * 截至今日新增政治学专业用户总数, Total Number of 0302 Major Users
     */
    private Long tn0302mu;

    /**
     * 今日新增政治学专业用户数, Number of New 0302 Major Users Today
     */
    private Long nn0302mut;

    /**
     * 截至今日新增社会学专业用户总数, Total Number of 0303 Major Users
     */
    private Long tn0303mu;

    /**
     * 今日新增社会学专业用户数, Number of New 0303 Major Users Today
     */
    private Long nn0303mut;

    /**
     * 截至今日新增民族学专业用户总数, Total Number of 0304 Major Users
     */
    private Long tn0304mu;

    /**
     * 今日新增民族学专业用户数, Number of New 0304 Major Users Today
     */
    private Long nn0304mut;

    /**
     * 截至今日新增马克思主义理论专业用户总数, Total Number of 0305 Major Users
     */
    private Long tn0305mu;

    /**
     * 今日新增马克思主义理论专业用户数, Number of New 0305 Major Users Today
     */
    private Long nn0305mut;

    /**
     * 截至今日新增公安学专业用户总数, Total Number of 0306 Major Users
     */
    private Long tn0306mu;

    /**
     * 今日新增公安学专业用户数, Number of New 0306 Major Users Today
     */
    private Long nn0306mut;

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
        UserMajorJurisprudence other = (UserMajorJurisprudence) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn0301mu() == null ? other.getTn0301mu() == null : this.getTn0301mu().equals(other.getTn0301mu()))
            && (this.getNn0301mut() == null ? other.getNn0301mut() == null : this.getNn0301mut().equals(other.getNn0301mut()))
            && (this.getTn0302mu() == null ? other.getTn0302mu() == null : this.getTn0302mu().equals(other.getTn0302mu()))
            && (this.getNn0302mut() == null ? other.getNn0302mut() == null : this.getNn0302mut().equals(other.getNn0302mut()))
            && (this.getTn0303mu() == null ? other.getTn0303mu() == null : this.getTn0303mu().equals(other.getTn0303mu()))
            && (this.getNn0303mut() == null ? other.getNn0303mut() == null : this.getNn0303mut().equals(other.getNn0303mut()))
            && (this.getTn0304mu() == null ? other.getTn0304mu() == null : this.getTn0304mu().equals(other.getTn0304mu()))
            && (this.getNn0304mut() == null ? other.getNn0304mut() == null : this.getNn0304mut().equals(other.getNn0304mut()))
            && (this.getTn0305mu() == null ? other.getTn0305mu() == null : this.getTn0305mu().equals(other.getTn0305mu()))
            && (this.getNn0305mut() == null ? other.getNn0305mut() == null : this.getNn0305mut().equals(other.getNn0305mut()))
            && (this.getTn0306mu() == null ? other.getTn0306mu() == null : this.getTn0306mu().equals(other.getTn0306mu()))
            && (this.getNn0306mut() == null ? other.getNn0306mut() == null : this.getNn0306mut().equals(other.getNn0306mut()))
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
        result = prime * result + ((getTn0301mu() == null) ? 0 : getTn0301mu().hashCode());
        result = prime * result + ((getNn0301mut() == null) ? 0 : getNn0301mut().hashCode());
        result = prime * result + ((getTn0302mu() == null) ? 0 : getTn0302mu().hashCode());
        result = prime * result + ((getNn0302mut() == null) ? 0 : getNn0302mut().hashCode());
        result = prime * result + ((getTn0303mu() == null) ? 0 : getTn0303mu().hashCode());
        result = prime * result + ((getNn0303mut() == null) ? 0 : getNn0303mut().hashCode());
        result = prime * result + ((getTn0304mu() == null) ? 0 : getTn0304mu().hashCode());
        result = prime * result + ((getNn0304mut() == null) ? 0 : getNn0304mut().hashCode());
        result = prime * result + ((getTn0305mu() == null) ? 0 : getTn0305mu().hashCode());
        result = prime * result + ((getNn0305mut() == null) ? 0 : getNn0305mut().hashCode());
        result = prime * result + ((getTn0306mu() == null) ? 0 : getTn0306mu().hashCode());
        result = prime * result + ((getNn0306mut() == null) ? 0 : getNn0306mut().hashCode());
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
        sb.append(", tn0301mu=").append(tn0301mu);
        sb.append(", nn0301mut=").append(nn0301mut);
        sb.append(", tn0302mu=").append(tn0302mu);
        sb.append(", nn0302mut=").append(nn0302mut);
        sb.append(", tn0303mu=").append(tn0303mu);
        sb.append(", nn0303mut=").append(nn0303mut);
        sb.append(", tn0304mu=").append(tn0304mu);
        sb.append(", nn0304mut=").append(nn0304mut);
        sb.append(", tn0305mu=").append(tn0305mu);
        sb.append(", nn0305mut=").append(nn0305mut);
        sb.append(", tn0306mu=").append(tn0306mu);
        sb.append(", nn0306mut=").append(nn0306mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}