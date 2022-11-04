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
 * @TableName visualize
 */
@TableName(value ="visualize")
@Data
public class Visualize implements Serializable {
    /**
     * 数据统计主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 页面点击量page view
     */
    private Long pv;

    /**
     * 独立访客量unique visitor，用户IP去重统计
     */
    private Long uv;

    /**
     * 活跃用户量active user，用户ID去重统计，在某个时间区间范围内，无论访问多少次，只记一次
     */
    private Long au;

    /**
     * 注册用户量registrations user，统计在某个时间区间范围内，新增用户的ID
     */
    private Long ru;

    /**
     * 
     */
    private Long cu;

    /**
     * 
     */
    private Long ptl;

    /**
     * 
     */
    private Long ctl;

    /**
     * 
     */
    private Long dau;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Date createdTime;

    /**
     * 
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
        Visualize other = (Visualize) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPv() == null ? other.getPv() == null : this.getPv().equals(other.getPv()))
            && (this.getUv() == null ? other.getUv() == null : this.getUv().equals(other.getUv()))
            && (this.getAu() == null ? other.getAu() == null : this.getAu().equals(other.getAu()))
            && (this.getRu() == null ? other.getRu() == null : this.getRu().equals(other.getRu()))
            && (this.getCu() == null ? other.getCu() == null : this.getCu().equals(other.getCu()))
            && (this.getPtl() == null ? other.getPtl() == null : this.getPtl().equals(other.getPtl()))
            && (this.getCtl() == null ? other.getCtl() == null : this.getCtl().equals(other.getCtl()))
            && (this.getDau() == null ? other.getDau() == null : this.getDau().equals(other.getDau()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPv() == null) ? 0 : getPv().hashCode());
        result = prime * result + ((getUv() == null) ? 0 : getUv().hashCode());
        result = prime * result + ((getAu() == null) ? 0 : getAu().hashCode());
        result = prime * result + ((getRu() == null) ? 0 : getRu().hashCode());
        result = prime * result + ((getCu() == null) ? 0 : getCu().hashCode());
        result = prime * result + ((getPtl() == null) ? 0 : getPtl().hashCode());
        result = prime * result + ((getCtl() == null) ? 0 : getCtl().hashCode());
        result = prime * result + ((getDau() == null) ? 0 : getDau().hashCode());
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
        sb.append(", pv=").append(pv);
        sb.append(", uv=").append(uv);
        sb.append(", au=").append(au);
        sb.append(", ru=").append(ru);
        sb.append(", cu=").append(cu);
        sb.append(", ptl=").append(ptl);
        sb.append(", ctl=").append(ctl);
        sb.append(", dau=").append(dau);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}