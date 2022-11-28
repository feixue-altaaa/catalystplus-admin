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
 * @TableName user_major_military
 */
@TableName(value ="user_major_military")
@Data
public class UserMajorMilitary implements Serializable {
    /**
     * 军事学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增军事思想及军事历史专业用户总数, Total Number of 1101 Major Users
     */
    private Long tn1101mu;

    /**
     * 今日新增军事思想及军事历史专业用户数, Number of New 1101 Major Users Today
     */
    private Long nn1101mut;

    /**
     * 截至今日新增战略学专业用户总数, Total Number of 1102 Major Users
     */
    private Long tn1102mu;

    /**
     * 今日新增战略学专业用户数, Number of New 1102 Major Users Today
     */
    private Long nn1102mut;

    /**
     * 截至今日新增战役学专业用户总数, Total Number of 1103 Major Users
     */
    private Long tn1103mu;

    /**
     * 今日新增战役学专业用户数, Number of New 1103 Major Users Today
     */
    private Long nn1103mut;

    /**
     * 截至今日新增战术学专业用户总数, Total Number of 1104 Major Users
     */
    private Long tn1104mu;

    /**
     * 今日新增战术学专业用户数, Number of New 1104 Major Users Today
     */
    private Long nn1104mut;

    /**
     * 截至今日新增军队指挥学专业用户总数, Total Number of 1105 Major Users
     */
    private Long tn1105mu;

    /**
     * 今日新增军队指挥学专业用户数, Number of New 1105 Major Users Today
     */
    private Long nn1105mut;

    /**
     * 截至今日新增军事管理学专业用户总数, Total Number of 1106 Major Users
     */
    private Long tn1106mu;

    /**
     * 今日新增军事管理学专业用户数, Number of New 1106 Major Users Today
     */
    private Long nn1106mut;

    /**
     * 截至今日新增军队政治工作学专业用户总数, Total Number of 1107 Major Users
     */
    private Long tn1107mu;

    /**
     * 今日新增军队政治工作学专业用户数, Number of New 1107 Major Users Today
     */
    private Long nn1107mut;

    /**
     * 截至今日新增军事后勤学专业用户总数, Total Number of 1108 Major Users
     */
    private Long tn1108mu;

    /**
     * 今日新增军事后勤学专业用户数, Number of New 1108 Major Users Today
     */
    private Long nn1108mut;

    /**
     * 截至今日新增军事装备学专业用户总数, Total Number of 1109 Major Users
     */
    private Long tn1109mu;

    /**
     * 今日新增军事装备学专业用户数, Number of New 1109 Major Users Today
     */
    private Long nn1109mut;

    /**
     * 截至今日新增军事训练学专业用户总数, Total Number of 1110 Major Users
     */
    private Long tn1110mu;

    /**
     * 今日新增军事训练学专业用户数, Number of New 1110 Major Users Today
     */
    private Long nn1110mut;

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
        UserMajorMilitary other = (UserMajorMilitary) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn1101mu() == null ? other.getTn1101mu() == null : this.getTn1101mu().equals(other.getTn1101mu()))
            && (this.getNn1101mut() == null ? other.getNn1101mut() == null : this.getNn1101mut().equals(other.getNn1101mut()))
            && (this.getTn1102mu() == null ? other.getTn1102mu() == null : this.getTn1102mu().equals(other.getTn1102mu()))
            && (this.getNn1102mut() == null ? other.getNn1102mut() == null : this.getNn1102mut().equals(other.getNn1102mut()))
            && (this.getTn1103mu() == null ? other.getTn1103mu() == null : this.getTn1103mu().equals(other.getTn1103mu()))
            && (this.getNn1103mut() == null ? other.getNn1103mut() == null : this.getNn1103mut().equals(other.getNn1103mut()))
            && (this.getTn1104mu() == null ? other.getTn1104mu() == null : this.getTn1104mu().equals(other.getTn1104mu()))
            && (this.getNn1104mut() == null ? other.getNn1104mut() == null : this.getNn1104mut().equals(other.getNn1104mut()))
            && (this.getTn1105mu() == null ? other.getTn1105mu() == null : this.getTn1105mu().equals(other.getTn1105mu()))
            && (this.getNn1105mut() == null ? other.getNn1105mut() == null : this.getNn1105mut().equals(other.getNn1105mut()))
            && (this.getTn1106mu() == null ? other.getTn1106mu() == null : this.getTn1106mu().equals(other.getTn1106mu()))
            && (this.getNn1106mut() == null ? other.getNn1106mut() == null : this.getNn1106mut().equals(other.getNn1106mut()))
            && (this.getTn1107mu() == null ? other.getTn1107mu() == null : this.getTn1107mu().equals(other.getTn1107mu()))
            && (this.getNn1107mut() == null ? other.getNn1107mut() == null : this.getNn1107mut().equals(other.getNn1107mut()))
            && (this.getTn1108mu() == null ? other.getTn1108mu() == null : this.getTn1108mu().equals(other.getTn1108mu()))
            && (this.getNn1108mut() == null ? other.getNn1108mut() == null : this.getNn1108mut().equals(other.getNn1108mut()))
            && (this.getTn1109mu() == null ? other.getTn1109mu() == null : this.getTn1109mu().equals(other.getTn1109mu()))
            && (this.getNn1109mut() == null ? other.getNn1109mut() == null : this.getNn1109mut().equals(other.getNn1109mut()))
            && (this.getTn1110mu() == null ? other.getTn1110mu() == null : this.getTn1110mu().equals(other.getTn1110mu()))
            && (this.getNn1110mut() == null ? other.getNn1110mut() == null : this.getNn1110mut().equals(other.getNn1110mut()))
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
        result = prime * result + ((getTn1101mu() == null) ? 0 : getTn1101mu().hashCode());
        result = prime * result + ((getNn1101mut() == null) ? 0 : getNn1101mut().hashCode());
        result = prime * result + ((getTn1102mu() == null) ? 0 : getTn1102mu().hashCode());
        result = prime * result + ((getNn1102mut() == null) ? 0 : getNn1102mut().hashCode());
        result = prime * result + ((getTn1103mu() == null) ? 0 : getTn1103mu().hashCode());
        result = prime * result + ((getNn1103mut() == null) ? 0 : getNn1103mut().hashCode());
        result = prime * result + ((getTn1104mu() == null) ? 0 : getTn1104mu().hashCode());
        result = prime * result + ((getNn1104mut() == null) ? 0 : getNn1104mut().hashCode());
        result = prime * result + ((getTn1105mu() == null) ? 0 : getTn1105mu().hashCode());
        result = prime * result + ((getNn1105mut() == null) ? 0 : getNn1105mut().hashCode());
        result = prime * result + ((getTn1106mu() == null) ? 0 : getTn1106mu().hashCode());
        result = prime * result + ((getNn1106mut() == null) ? 0 : getNn1106mut().hashCode());
        result = prime * result + ((getTn1107mu() == null) ? 0 : getTn1107mu().hashCode());
        result = prime * result + ((getNn1107mut() == null) ? 0 : getNn1107mut().hashCode());
        result = prime * result + ((getTn1108mu() == null) ? 0 : getTn1108mu().hashCode());
        result = prime * result + ((getNn1108mut() == null) ? 0 : getNn1108mut().hashCode());
        result = prime * result + ((getTn1109mu() == null) ? 0 : getTn1109mu().hashCode());
        result = prime * result + ((getNn1109mut() == null) ? 0 : getNn1109mut().hashCode());
        result = prime * result + ((getTn1110mu() == null) ? 0 : getTn1110mu().hashCode());
        result = prime * result + ((getNn1110mut() == null) ? 0 : getNn1110mut().hashCode());
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
        sb.append(", tn1101mu=").append(tn1101mu);
        sb.append(", nn1101mut=").append(nn1101mut);
        sb.append(", tn1102mu=").append(tn1102mu);
        sb.append(", nn1102mut=").append(nn1102mut);
        sb.append(", tn1103mu=").append(tn1103mu);
        sb.append(", nn1103mut=").append(nn1103mut);
        sb.append(", tn1104mu=").append(tn1104mu);
        sb.append(", nn1104mut=").append(nn1104mut);
        sb.append(", tn1105mu=").append(tn1105mu);
        sb.append(", nn1105mut=").append(nn1105mut);
        sb.append(", tn1106mu=").append(tn1106mu);
        sb.append(", nn1106mut=").append(nn1106mut);
        sb.append(", tn1107mu=").append(tn1107mu);
        sb.append(", nn1107mut=").append(nn1107mut);
        sb.append(", tn1108mu=").append(tn1108mu);
        sb.append(", nn1108mut=").append(nn1108mut);
        sb.append(", tn1109mu=").append(tn1109mu);
        sb.append(", nn1109mut=").append(nn1109mut);
        sb.append(", tn1110mu=").append(tn1110mu);
        sb.append(", nn1110mut=").append(nn1110mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}