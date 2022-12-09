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
 * @TableName user_active
 */
@TableName(value ="user_active")
@Data
public class UserActive implements Serializable {
    /**
     * 用户活跃id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日用户总数, Total Number of Users
     */
    private Long tnu;

    /**
     * 今日新增用户数, Number of New Users Today
     */
    private Long nnut;

    /**
     * 今日活跃用户数, Daily Active Users
     */
    private Long dau;

    /**
     * 日活占比（今日活跃用户数除以用户总数）, Percentage of Daily Active Users
     */
    private Double pdau;

    /**
     * 本周活跃用户数, Weekly Active Users, 只在每周的最后一天显示
     */
    private Long wau;

    /**
     * 周活占比（本周活跃用户数除以用户总数）, Percentage of Weekly Active Users, 只在每周的最后一天显示
     */
    private Double pwau;

    /**
     * 本月活跃用户数, Monthly Active Users, 只在每月的最后一天显示
     */
    private Long mau;

    /**
     * 月活占比（本月活跃用户数除以用户总数）, Percentage of Monthly Active Users, 只在每月的最后一天显示
     */
    private Double pmau;

    /**
     * 七天前用户留存数, Weekly Number of Retained Users
     */
    private Long wnru;

    /**
     * 七天前用户留存率, Weekly Users Retention Rate
     */
    private Double wurr;

    /**
     * 一个月前用户留存数, Monthly Number of Retained Users
     */
    private Long mnru;

    /**
     * 一个月前用户留存率, Monthly Users Retention Rate
     */
    private Double murr;

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
        UserActive other = (UserActive) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTnu() == null ? other.getTnu() == null : this.getTnu().equals(other.getTnu()))
            && (this.getNnut() == null ? other.getNnut() == null : this.getNnut().equals(other.getNnut()))
            && (this.getDau() == null ? other.getDau() == null : this.getDau().equals(other.getDau()))
            && (this.getPdau() == null ? other.getPdau() == null : this.getPdau().equals(other.getPdau()))
            && (this.getWau() == null ? other.getWau() == null : this.getWau().equals(other.getWau()))
            && (this.getPwau() == null ? other.getPwau() == null : this.getPwau().equals(other.getPwau()))
            && (this.getMau() == null ? other.getMau() == null : this.getMau().equals(other.getMau()))
            && (this.getPmau() == null ? other.getPmau() == null : this.getPmau().equals(other.getPmau()))
            && (this.getWnru() == null ? other.getWnru() == null : this.getWnru().equals(other.getWnru()))
            && (this.getWurr() == null ? other.getWurr() == null : this.getWurr().equals(other.getWurr()))
            && (this.getMnru() == null ? other.getMnru() == null : this.getMnru().equals(other.getMnru()))
            && (this.getMurr() == null ? other.getMurr() == null : this.getMurr().equals(other.getMurr()))
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
        result = prime * result + ((getTnu() == null) ? 0 : getTnu().hashCode());
        result = prime * result + ((getNnut() == null) ? 0 : getNnut().hashCode());
        result = prime * result + ((getDau() == null) ? 0 : getDau().hashCode());
        result = prime * result + ((getPdau() == null) ? 0 : getPdau().hashCode());
        result = prime * result + ((getWau() == null) ? 0 : getWau().hashCode());
        result = prime * result + ((getPwau() == null) ? 0 : getPwau().hashCode());
        result = prime * result + ((getMau() == null) ? 0 : getMau().hashCode());
        result = prime * result + ((getPmau() == null) ? 0 : getPmau().hashCode());
        result = prime * result + ((getWnru() == null) ? 0 : getWnru().hashCode());
        result = prime * result + ((getWurr() == null) ? 0 : getWurr().hashCode());
        result = prime * result + ((getMnru() == null) ? 0 : getMnru().hashCode());
        result = prime * result + ((getMurr() == null) ? 0 : getMurr().hashCode());
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
        sb.append(", tnu=").append(tnu);
        sb.append(", nnut=").append(nnut);
        sb.append(", dau=").append(dau);
        sb.append(", pdau=").append(pdau);
        sb.append(", wau=").append(wau);
        sb.append(", pwau=").append(pwau);
        sb.append(", mau=").append(mau);
        sb.append(", pmau=").append(pmau);
        sb.append(", wnru=").append(wnru);
        sb.append(", wurr=").append(wurr);
        sb.append(", mnru=").append(mnru);
        sb.append(", murr=").append(murr);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}