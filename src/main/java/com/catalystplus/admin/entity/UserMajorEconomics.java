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
 * @TableName user_major_economics
 */
@TableName(value ="user_major_economics")
@Data
public class UserMajorEconomics implements Serializable {
    /**
     * 经济学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增理论经济学专业用户总数, Total Number of 0201 Major Users
     */
    private Long tn0201mu;

    /**
     * 今日新增理论经济学专业用户数, Number of New 0201 Major Users Today
     */
    private Long nn0201mut;

    /**
     * 截至今日新增应用经济学专业用户总数, Total Number of 0202 Major Users
     */
    private Long tn0202mu;

    /**
     * 今日新增应用经济学专业用户数, Number of New 0202 Major Users Today
     */
    private Long nn0202mut;

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
        UserMajorEconomics other = (UserMajorEconomics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn0201mu() == null ? other.getTn0201mu() == null : this.getTn0201mu().equals(other.getTn0201mu()))
            && (this.getNn0201mut() == null ? other.getNn0201mut() == null : this.getNn0201mut().equals(other.getNn0201mut()))
            && (this.getTn0202mu() == null ? other.getTn0202mu() == null : this.getTn0202mu().equals(other.getTn0202mu()))
            && (this.getNn0202mut() == null ? other.getNn0202mut() == null : this.getNn0202mut().equals(other.getNn0202mut()))
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
        result = prime * result + ((getTn0201mu() == null) ? 0 : getTn0201mu().hashCode());
        result = prime * result + ((getNn0201mut() == null) ? 0 : getNn0201mut().hashCode());
        result = prime * result + ((getTn0202mu() == null) ? 0 : getTn0202mu().hashCode());
        result = prime * result + ((getNn0202mut() == null) ? 0 : getNn0202mut().hashCode());
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
        sb.append(", tn0201mu=").append(tn0201mu);
        sb.append(", nn0201mut=").append(nn0201mut);
        sb.append(", tn0202mu=").append(tn0202mu);
        sb.append(", nn0202mut=").append(nn0202mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}