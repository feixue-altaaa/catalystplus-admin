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
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * 用户信息id
     */
    @TableId
    private Long id;

    /**
     * 截至今日本科生总数, Total Number of Undergraduates
     */
    private Long tnu;

    /**
     * 今日新增本科生数, Number of New Undergraduates Today
     */
    private Long nnut;

    /**
     * 截至今日硕士生总数, Total Number of Masters
     */
    private Long tnm;

    /**
     * 今日新增硕士生数, Number of New Masters Today
     */
    private Long nnmt;

    /**
     * 截至今日博士生总数, Total Number of Doctors
     */
    private Long tnd;

    /**
     * 今日新增博士生数, Number of New Doctors Today
     */
    private Long nndt;

    /**
     * 截至今日老师总数, Total Number of Teachers
     */
    private Long tnt;

    /**
     * 今日新增老师数, Number of New Teachers Today
     */
    private Long nntt;

    /**
     * 截至今日C9用户总数, Total Number of C9 Users
     */
    private Long tncu;

    /**
     * 今日新增C9用户数, Number of New C9 Users Today
     */
    private Long nncut;

    /**
     * 截至今日985用户总数, Total Number of 985 Users
     */
    private Long tn985u;

    /**
     * 今日新增985用户数, Number of New 985 Users Today
     */
    private Long nn985ut;

    /**
     * 截至今日211用户总数, Total Number of 211 Users
     */
    private Long tn211u;

    /**
     * 今日新增211用户数, Number of New 211 Users Today
     */
    private Long nn211ut;

    /**
     * 截至今日一本院校用户总数, Total Number of First Batch University Users
     */
    private Long tnfbuu;

    /**
     * 今日新增一本院校用户数, Number of New First Batch University Users Today
     */
    private Long nnfbuu;

    /**
     * 截至今日其他院校用户总数, Total Number of Other University Users
     */
    private Long tnouu;

    /**
     * 今日新增其他院校用户数, Number of New Other University Users Today
     */
    private Long nnouut;

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
        UserInfo other = (UserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTnu() == null ? other.getTnu() == null : this.getTnu().equals(other.getTnu()))
            && (this.getNnut() == null ? other.getNnut() == null : this.getNnut().equals(other.getNnut()))
            && (this.getTnm() == null ? other.getTnm() == null : this.getTnm().equals(other.getTnm()))
            && (this.getNnmt() == null ? other.getNnmt() == null : this.getNnmt().equals(other.getNnmt()))
            && (this.getTnd() == null ? other.getTnd() == null : this.getTnd().equals(other.getTnd()))
            && (this.getNndt() == null ? other.getNndt() == null : this.getNndt().equals(other.getNndt()))
            && (this.getTnt() == null ? other.getTnt() == null : this.getTnt().equals(other.getTnt()))
            && (this.getNntt() == null ? other.getNntt() == null : this.getNntt().equals(other.getNntt()))
            && (this.getTncu() == null ? other.getTncu() == null : this.getTncu().equals(other.getTncu()))
            && (this.getNncut() == null ? other.getNncut() == null : this.getNncut().equals(other.getNncut()))
            && (this.getTn985u() == null ? other.getTn985u() == null : this.getTn985u().equals(other.getTn985u()))
            && (this.getNn985ut() == null ? other.getNn985ut() == null : this.getNn985ut().equals(other.getNn985ut()))
            && (this.getTn211u() == null ? other.getTn211u() == null : this.getTn211u().equals(other.getTn211u()))
            && (this.getNn211ut() == null ? other.getNn211ut() == null : this.getNn211ut().equals(other.getNn211ut()))
            && (this.getTnfbuu() == null ? other.getTnfbuu() == null : this.getTnfbuu().equals(other.getTnfbuu()))
            && (this.getNnfbuu() == null ? other.getNnfbuu() == null : this.getNnfbuu().equals(other.getNnfbuu()))
            && (this.getTnouu() == null ? other.getTnouu() == null : this.getTnouu().equals(other.getTnouu()))
            && (this.getNnouut() == null ? other.getNnouut() == null : this.getNnouut().equals(other.getNnouut()))
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
        result = prime * result + ((getTnm() == null) ? 0 : getTnm().hashCode());
        result = prime * result + ((getNnmt() == null) ? 0 : getNnmt().hashCode());
        result = prime * result + ((getTnd() == null) ? 0 : getTnd().hashCode());
        result = prime * result + ((getNndt() == null) ? 0 : getNndt().hashCode());
        result = prime * result + ((getTnt() == null) ? 0 : getTnt().hashCode());
        result = prime * result + ((getNntt() == null) ? 0 : getNntt().hashCode());
        result = prime * result + ((getTncu() == null) ? 0 : getTncu().hashCode());
        result = prime * result + ((getNncut() == null) ? 0 : getNncut().hashCode());
        result = prime * result + ((getTn985u() == null) ? 0 : getTn985u().hashCode());
        result = prime * result + ((getNn985ut() == null) ? 0 : getNn985ut().hashCode());
        result = prime * result + ((getTn211u() == null) ? 0 : getTn211u().hashCode());
        result = prime * result + ((getNn211ut() == null) ? 0 : getNn211ut().hashCode());
        result = prime * result + ((getTnfbuu() == null) ? 0 : getTnfbuu().hashCode());
        result = prime * result + ((getNnfbuu() == null) ? 0 : getNnfbuu().hashCode());
        result = prime * result + ((getTnouu() == null) ? 0 : getTnouu().hashCode());
        result = prime * result + ((getNnouut() == null) ? 0 : getNnouut().hashCode());
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
        sb.append(", tnm=").append(tnm);
        sb.append(", nnmt=").append(nnmt);
        sb.append(", tnd=").append(tnd);
        sb.append(", nndt=").append(nndt);
        sb.append(", tnt=").append(tnt);
        sb.append(", nntt=").append(nntt);
        sb.append(", tncu=").append(tncu);
        sb.append(", nncut=").append(nncut);
        sb.append(", tn985u=").append(tn985u);
        sb.append(", nn985ut=").append(nn985ut);
        sb.append(", tn211u=").append(tn211u);
        sb.append(", nn211ut=").append(nn211ut);
        sb.append(", tnfbuu=").append(tnfbuu);
        sb.append(", nnfbuu=").append(nnfbuu);
        sb.append(", tnouu=").append(tnouu);
        sb.append(", nnouut=").append(nnouut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}