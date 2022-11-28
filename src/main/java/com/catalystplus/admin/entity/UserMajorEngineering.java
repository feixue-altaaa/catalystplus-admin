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
 * @TableName user_major_engineering
 */
@TableName(value ="user_major_engineering")
@Data
public class UserMajorEngineering implements Serializable {
    /**
     * 工学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增力学专业用户总数, Total Number of 0801 Major Users
     */
    private Long tn0801mu;

    /**
     * 今日新增力学专业用户数, Number of New 0801 Major Users Today
     */
    private Long nn0801mut;

    /**
     * 截至今日新增机械工程专业用户总数, Total Number of 0802 Major Users
     */
    private Long tn0802mu;

    /**
     * 今日新增机械工程专业用户数, Number of New 0802 Major Users Today
     */
    private Long nn0802mut;

    /**
     * 截至今日新增光学工程专业用户总数, Total Number of 0803 Major Users
     */
    private Long tn0803mu;

    /**
     * 今日新增光学工程专业用户数, Number of New 0803 Major Users Today
     */
    private Long nn0803mut;

    /**
     * 截至今日新增仪器科学与技术专业用户总数, Total Number of 0804 Major Users
     */
    private Long tn0804mu;

    /**
     * 今日新增仪器科学与技术专业用户数, Number of New 0804 Major Users Today
     */
    private Long nn0804mut;

    /**
     * 截至今日新增材料科学与工程专业用户总数, Total Number of 0805 Major Users
     */
    private Long tn0805mu;

    /**
     * 今日新增材料科学与工程专业用户数, Number of New 0805 Major Users Today
     */
    private Long nn0805mut;

    /**
     * 截至今日新增冶金工程专业用户总数, Total Number of 0806 Major Users
     */
    private Long tn0806mu;

    /**
     * 今日新增冶金工程专业用户数, Number of New 0806 Major Users Today
     */
    private Long nn0806mut;

    /**
     * 截至今日新增动力工程及工程热物理专业用户总数, Total Number of 0807 Major Users
     */
    private Long tn0807mu;

    /**
     * 今日新增动力工程及工程热物理专业用户数, Number of New 0807 Major Users Today
     */
    private Long nn0807mut;

    /**
     * 截至今日新增电气工程专业用户总数, Total Number of 0808 Major Users
     */
    private Long tn0808mu;

    /**
     * 今日新增电气工程专业用户数, Number of New 0808 Major Users Today
     */
    private Long nn0808mut;

    /**
     * 截至今日新增电子科学与技术专业用户总数, Total Number of 0809 Major Users
     */
    private Long tn0809mu;

    /**
     * 今日新增电子科学与技术专业用户数, Number of New 0809 Major Users Today
     */
    private Long nn0809mut;

    /**
     * 截至今日新增信息与通信工程专业用户总数, Total Number of 0810 Major Users
     */
    private Long tn0810mu;

    /**
     * 今日新增信息与通信工程专业用户数, Number of New 0810 Major Users Today
     */
    private Long nn0810mut;

    /**
     * 截至今日新增控制科学与工程专业用户总数, Total Number of 0811 Major Users
     */
    private Long tn0811mu;

    /**
     * 今日新增控制科学与工程专业用户数, Number of New 0811 Major Users Today
     */
    private Long nn0811mut;

    /**
     * 截至今日新增计算机科学与技术专业用户总数, Total Number of 0812 Major Users
     */
    private Long tn0812mu;

    /**
     * 今日新增计算机科学与技术专业用户数, Number of New 0812 Major Users Today
     */
    private Long nn0812mut;

    /**
     * 截至今日新增建筑学专业用户总数, Total Number of 0813 Major Users
     */
    private Long tn0813mu;

    /**
     * 今日新增建筑学专业用户数, Number of New 0813 Major Users Today
     */
    private Long nn0813mut;

    /**
     * 截至今日新增土木工程专业用户总数, Total Number of 0814 Major Users
     */
    private Long tn0814mu;

    /**
     * 今日新增土木工程专业用户数, Number of New 0814 Major Users Today
     */
    private Long nn0814mut;

    /**
     * 截至今日新增水利工程专业用户总数, Total Number of 0815 Major Users
     */
    private Long tn0815mu;

    /**
     * 今日新增水利工程专业用户数, Number of New 0815 Major Users Today
     */
    private Long nn0815mut;

    /**
     * 截至今日新增测绘科学与技术专业用户总数, Total Number of 0816 Major Users
     */
    private Long tn0816mu;

    /**
     * 今日新增测绘科学与技术专业用户数, Number of New 0816 Major Users Today
     */
    private Long nn0816mut;

    /**
     * 截至今日新增化学工程与技术专业用户总数, Total Number of 0817 Major Users
     */
    private Long tn0817mu;

    /**
     * 今日新增化学工程与技术专业用户数, Number of New 0817 Major Users Today
     */
    private Long nn0817mut;

    /**
     * 截至今日新增地质资源与地质工程专业用户总数, Total Number of 0818 Major Users
     */
    private Long tn0818mu;

    /**
     * 今日新增地质资源与地质工程专业用户数, Number of New 0818 Major Users Today
     */
    private Long nn0818mut;

    /**
     * 截至今日新增矿业工程专业用户总数, Total Number of 0819 Major Users
     */
    private Long tn0819mu;

    /**
     * 今日新增矿业工程专业用户数, Number of New 0819 Major Users Today
     */
    private Long nn0819mut;

    /**
     * 截至今日新增石油与天然气工程专业用户总数, Total Number of 0820 Major Users
     */
    private Long tn0820mu;

    /**
     * 今日新增石油与天然气工程专业用户数, Number of New 0820 Major Users Today
     */
    private Long nn0820mut;

    /**
     * 截至今日新增纺织科学与工程专业用户总数, Total Number of 0821 Major Users
     */
    private Long tn0821mu;

    /**
     * 今日新增纺织科学与工程专业用户数, Number of New 0821 Major Users Today
     */
    private Long nn0821mut;

    /**
     * 截至今日新增轻工技术与工程专业用户总数, Total Number of 0822 Major Users
     */
    private Long tn0822mu;

    /**
     * 今日新增轻工技术与工程专业用户数, Number of New 0822 Major Users Today
     */
    private Long nn0822mut;

    /**
     * 截至今日新增交通运输工程专业用户总数, Total Number of 0823 Major Users
     */
    private Long tn0823mu;

    /**
     * 今日新增交通运输工程专业用户数, Number of New 0823 Major Users Today
     */
    private Long nn0823mut;

    /**
     * 截至今日新增船舶与海洋工程专业用户总数, Total Number of 0824 Major Users
     */
    private Long tn0824mu;

    /**
     * 今日新增船舶与海洋工程专业用户数, Number of New 0824 Major Users Today
     */
    private Long nn0824mut;

    /**
     * 截至今日新增航空宇航科学与技术专业用户总数, Total Number of 0825 Major Users
     */
    private Long tn0825mu;

    /**
     * 今日新增航空宇航科学与技术专业用户数, Number of New 0825 Major Users Today
     */
    private Long nn0825mut;

    /**
     * 截至今日新增兵器科学与技术专业用户总数, Total Number of 0826 Major Users
     */
    private Long tn0826mu;

    /**
     * 今日新增兵器科学与技术专业用户数, Number of New 0826 Major Users Today
     */
    private Long nn0826mut;

    /**
     * 截至今日新增核科学与技术专业用户总数, Total Number of 0827 Major Users
     */
    private Long tn0827mu;

    /**
     * 今日新增核科学与技术专业用户数, Number of New 0827 Major Users Today
     */
    private Long nn0827mut;

    /**
     * 截至今日新增农业工程专业用户总数, Total Number of 0828 Major Users
     */
    private Long tn0828mu;

    /**
     * 今日新增农业工程专业用户数, Number of New 0828 Major Users Today
     */
    private Long nn0828mut;

    /**
     * 截至今日新增林业工程专业用户总数, Total Number of 0829 Major Users
     */
    private Long tn0829mu;

    /**
     * 今日新增林业工程专业用户数, Number of New 0829 Major Users Today
     */
    private Long nn0829mut;

    /**
     * 截至今日新增环境科学与工程专业用户总数, Total Number of 0830 Major Users
     */
    private Long tn0830mu;

    /**
     * 今日新增环境科学与工程专业用户数, Number of New 0830 Major Users Today
     */
    private Long nn0830mut;

    /**
     * 截至今日新增生物医学工程专业用户总数, Total Number of 0831 Major Users
     */
    private Long tn0831mu;

    /**
     * 今日新增生物医学工程专业用户数, Number of New 0831 Major Users Today
     */
    private Long nn0831mut;

    /**
     * 截至今日新增食品科学与工程专业用户总数, Total Number of 0832 Major Users
     */
    private Long tn0832mu;

    /**
     * 今日新增食品科学与工程专业用户数, Number of New 0832 Major Users Today
     */
    private Long nn0832mut;

    /**
     * 截至今日新增城乡规划学专业用户总数, Total Number of 0833 Major Users
     */
    private Long tn0833mu;

    /**
     * 今日新增城乡规划学专业用户数, Number of New 0833 Major Users Today
     */
    private Long nn0833mut;

    /**
     * 截至今日新增风景园林学专业用户总数, Total Number of 0834 Major Users
     */
    private Long tn0834mu;

    /**
     * 今日新增风景园林学专业用户数, Number of New 0834 Major Users Today
     */
    private Long nn0834mut;

    /**
     * 截至今日新增软件工程专业用户总数, Total Number of 0835 Major Users
     */
    private Long tn0835mu;

    /**
     * 今日新增软件工程专业用户数, Number of New 0835 Major Users Today
     */
    private Long nn0835mut;

    /**
     * 截至今日新增生物工程专业用户总数, Total Number of 0836 Major Users
     */
    private Long tn0836mu;

    /**
     * 今日新增生物工程专业用户数, Number of New 0836 Major Users Today
     */
    private Long nn0836mut;

    /**
     * 截至今日新增安全科学与工程专业用户总数, Total Number of 0837 Major Users
     */
    private Long tn0837mu;

    /**
     * 今日新增安全科学与工程专业用户数, Number of New 0837 Major Users Today
     */
    private Long nn0837mut;

    /**
     * 截至今日新增公安技术专业用户总数, Total Number of 0838 Major Users
     */
    private Long tn0838mu;

    /**
     * 今日新增公安技术专业用户数, Number of New 0838 Major Users Today
     */
    private Long nn0838mut;

    /**
     * 截至今日新增网络空间安全专业用户总数, Total Number of 0839 Major Users
     */
    private Long tn0839mu;

    /**
     * 今日新增网络空间安全专业用户数, Number of New 0839 Major Users Today
     */
    private Long nn0839mut;

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
        UserMajorEngineering other = (UserMajorEngineering) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn0801mu() == null ? other.getTn0801mu() == null : this.getTn0801mu().equals(other.getTn0801mu()))
            && (this.getNn0801mut() == null ? other.getNn0801mut() == null : this.getNn0801mut().equals(other.getNn0801mut()))
            && (this.getTn0802mu() == null ? other.getTn0802mu() == null : this.getTn0802mu().equals(other.getTn0802mu()))
            && (this.getNn0802mut() == null ? other.getNn0802mut() == null : this.getNn0802mut().equals(other.getNn0802mut()))
            && (this.getTn0803mu() == null ? other.getTn0803mu() == null : this.getTn0803mu().equals(other.getTn0803mu()))
            && (this.getNn0803mut() == null ? other.getNn0803mut() == null : this.getNn0803mut().equals(other.getNn0803mut()))
            && (this.getTn0804mu() == null ? other.getTn0804mu() == null : this.getTn0804mu().equals(other.getTn0804mu()))
            && (this.getNn0804mut() == null ? other.getNn0804mut() == null : this.getNn0804mut().equals(other.getNn0804mut()))
            && (this.getTn0805mu() == null ? other.getTn0805mu() == null : this.getTn0805mu().equals(other.getTn0805mu()))
            && (this.getNn0805mut() == null ? other.getNn0805mut() == null : this.getNn0805mut().equals(other.getNn0805mut()))
            && (this.getTn0806mu() == null ? other.getTn0806mu() == null : this.getTn0806mu().equals(other.getTn0806mu()))
            && (this.getNn0806mut() == null ? other.getNn0806mut() == null : this.getNn0806mut().equals(other.getNn0806mut()))
            && (this.getTn0807mu() == null ? other.getTn0807mu() == null : this.getTn0807mu().equals(other.getTn0807mu()))
            && (this.getNn0807mut() == null ? other.getNn0807mut() == null : this.getNn0807mut().equals(other.getNn0807mut()))
            && (this.getTn0808mu() == null ? other.getTn0808mu() == null : this.getTn0808mu().equals(other.getTn0808mu()))
            && (this.getNn0808mut() == null ? other.getNn0808mut() == null : this.getNn0808mut().equals(other.getNn0808mut()))
            && (this.getTn0809mu() == null ? other.getTn0809mu() == null : this.getTn0809mu().equals(other.getTn0809mu()))
            && (this.getNn0809mut() == null ? other.getNn0809mut() == null : this.getNn0809mut().equals(other.getNn0809mut()))
            && (this.getTn0810mu() == null ? other.getTn0810mu() == null : this.getTn0810mu().equals(other.getTn0810mu()))
            && (this.getNn0810mut() == null ? other.getNn0810mut() == null : this.getNn0810mut().equals(other.getNn0810mut()))
            && (this.getTn0811mu() == null ? other.getTn0811mu() == null : this.getTn0811mu().equals(other.getTn0811mu()))
            && (this.getNn0811mut() == null ? other.getNn0811mut() == null : this.getNn0811mut().equals(other.getNn0811mut()))
            && (this.getTn0812mu() == null ? other.getTn0812mu() == null : this.getTn0812mu().equals(other.getTn0812mu()))
            && (this.getNn0812mut() == null ? other.getNn0812mut() == null : this.getNn0812mut().equals(other.getNn0812mut()))
            && (this.getTn0813mu() == null ? other.getTn0813mu() == null : this.getTn0813mu().equals(other.getTn0813mu()))
            && (this.getNn0813mut() == null ? other.getNn0813mut() == null : this.getNn0813mut().equals(other.getNn0813mut()))
            && (this.getTn0814mu() == null ? other.getTn0814mu() == null : this.getTn0814mu().equals(other.getTn0814mu()))
            && (this.getNn0814mut() == null ? other.getNn0814mut() == null : this.getNn0814mut().equals(other.getNn0814mut()))
            && (this.getTn0815mu() == null ? other.getTn0815mu() == null : this.getTn0815mu().equals(other.getTn0815mu()))
            && (this.getNn0815mut() == null ? other.getNn0815mut() == null : this.getNn0815mut().equals(other.getNn0815mut()))
            && (this.getTn0816mu() == null ? other.getTn0816mu() == null : this.getTn0816mu().equals(other.getTn0816mu()))
            && (this.getNn0816mut() == null ? other.getNn0816mut() == null : this.getNn0816mut().equals(other.getNn0816mut()))
            && (this.getTn0817mu() == null ? other.getTn0817mu() == null : this.getTn0817mu().equals(other.getTn0817mu()))
            && (this.getNn0817mut() == null ? other.getNn0817mut() == null : this.getNn0817mut().equals(other.getNn0817mut()))
            && (this.getTn0818mu() == null ? other.getTn0818mu() == null : this.getTn0818mu().equals(other.getTn0818mu()))
            && (this.getNn0818mut() == null ? other.getNn0818mut() == null : this.getNn0818mut().equals(other.getNn0818mut()))
            && (this.getTn0819mu() == null ? other.getTn0819mu() == null : this.getTn0819mu().equals(other.getTn0819mu()))
            && (this.getNn0819mut() == null ? other.getNn0819mut() == null : this.getNn0819mut().equals(other.getNn0819mut()))
            && (this.getTn0820mu() == null ? other.getTn0820mu() == null : this.getTn0820mu().equals(other.getTn0820mu()))
            && (this.getNn0820mut() == null ? other.getNn0820mut() == null : this.getNn0820mut().equals(other.getNn0820mut()))
            && (this.getTn0821mu() == null ? other.getTn0821mu() == null : this.getTn0821mu().equals(other.getTn0821mu()))
            && (this.getNn0821mut() == null ? other.getNn0821mut() == null : this.getNn0821mut().equals(other.getNn0821mut()))
            && (this.getTn0822mu() == null ? other.getTn0822mu() == null : this.getTn0822mu().equals(other.getTn0822mu()))
            && (this.getNn0822mut() == null ? other.getNn0822mut() == null : this.getNn0822mut().equals(other.getNn0822mut()))
            && (this.getTn0823mu() == null ? other.getTn0823mu() == null : this.getTn0823mu().equals(other.getTn0823mu()))
            && (this.getNn0823mut() == null ? other.getNn0823mut() == null : this.getNn0823mut().equals(other.getNn0823mut()))
            && (this.getTn0824mu() == null ? other.getTn0824mu() == null : this.getTn0824mu().equals(other.getTn0824mu()))
            && (this.getNn0824mut() == null ? other.getNn0824mut() == null : this.getNn0824mut().equals(other.getNn0824mut()))
            && (this.getTn0825mu() == null ? other.getTn0825mu() == null : this.getTn0825mu().equals(other.getTn0825mu()))
            && (this.getNn0825mut() == null ? other.getNn0825mut() == null : this.getNn0825mut().equals(other.getNn0825mut()))
            && (this.getTn0826mu() == null ? other.getTn0826mu() == null : this.getTn0826mu().equals(other.getTn0826mu()))
            && (this.getNn0826mut() == null ? other.getNn0826mut() == null : this.getNn0826mut().equals(other.getNn0826mut()))
            && (this.getTn0827mu() == null ? other.getTn0827mu() == null : this.getTn0827mu().equals(other.getTn0827mu()))
            && (this.getNn0827mut() == null ? other.getNn0827mut() == null : this.getNn0827mut().equals(other.getNn0827mut()))
            && (this.getTn0828mu() == null ? other.getTn0828mu() == null : this.getTn0828mu().equals(other.getTn0828mu()))
            && (this.getNn0828mut() == null ? other.getNn0828mut() == null : this.getNn0828mut().equals(other.getNn0828mut()))
            && (this.getTn0829mu() == null ? other.getTn0829mu() == null : this.getTn0829mu().equals(other.getTn0829mu()))
            && (this.getNn0829mut() == null ? other.getNn0829mut() == null : this.getNn0829mut().equals(other.getNn0829mut()))
            && (this.getTn0830mu() == null ? other.getTn0830mu() == null : this.getTn0830mu().equals(other.getTn0830mu()))
            && (this.getNn0830mut() == null ? other.getNn0830mut() == null : this.getNn0830mut().equals(other.getNn0830mut()))
            && (this.getTn0831mu() == null ? other.getTn0831mu() == null : this.getTn0831mu().equals(other.getTn0831mu()))
            && (this.getNn0831mut() == null ? other.getNn0831mut() == null : this.getNn0831mut().equals(other.getNn0831mut()))
            && (this.getTn0832mu() == null ? other.getTn0832mu() == null : this.getTn0832mu().equals(other.getTn0832mu()))
            && (this.getNn0832mut() == null ? other.getNn0832mut() == null : this.getNn0832mut().equals(other.getNn0832mut()))
            && (this.getTn0833mu() == null ? other.getTn0833mu() == null : this.getTn0833mu().equals(other.getTn0833mu()))
            && (this.getNn0833mut() == null ? other.getNn0833mut() == null : this.getNn0833mut().equals(other.getNn0833mut()))
            && (this.getTn0834mu() == null ? other.getTn0834mu() == null : this.getTn0834mu().equals(other.getTn0834mu()))
            && (this.getNn0834mut() == null ? other.getNn0834mut() == null : this.getNn0834mut().equals(other.getNn0834mut()))
            && (this.getTn0835mu() == null ? other.getTn0835mu() == null : this.getTn0835mu().equals(other.getTn0835mu()))
            && (this.getNn0835mut() == null ? other.getNn0835mut() == null : this.getNn0835mut().equals(other.getNn0835mut()))
            && (this.getTn0836mu() == null ? other.getTn0836mu() == null : this.getTn0836mu().equals(other.getTn0836mu()))
            && (this.getNn0836mut() == null ? other.getNn0836mut() == null : this.getNn0836mut().equals(other.getNn0836mut()))
            && (this.getTn0837mu() == null ? other.getTn0837mu() == null : this.getTn0837mu().equals(other.getTn0837mu()))
            && (this.getNn0837mut() == null ? other.getNn0837mut() == null : this.getNn0837mut().equals(other.getNn0837mut()))
            && (this.getTn0838mu() == null ? other.getTn0838mu() == null : this.getTn0838mu().equals(other.getTn0838mu()))
            && (this.getNn0838mut() == null ? other.getNn0838mut() == null : this.getNn0838mut().equals(other.getNn0838mut()))
            && (this.getTn0839mu() == null ? other.getTn0839mu() == null : this.getTn0839mu().equals(other.getTn0839mu()))
            && (this.getNn0839mut() == null ? other.getNn0839mut() == null : this.getNn0839mut().equals(other.getNn0839mut()))
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
        result = prime * result + ((getTn0801mu() == null) ? 0 : getTn0801mu().hashCode());
        result = prime * result + ((getNn0801mut() == null) ? 0 : getNn0801mut().hashCode());
        result = prime * result + ((getTn0802mu() == null) ? 0 : getTn0802mu().hashCode());
        result = prime * result + ((getNn0802mut() == null) ? 0 : getNn0802mut().hashCode());
        result = prime * result + ((getTn0803mu() == null) ? 0 : getTn0803mu().hashCode());
        result = prime * result + ((getNn0803mut() == null) ? 0 : getNn0803mut().hashCode());
        result = prime * result + ((getTn0804mu() == null) ? 0 : getTn0804mu().hashCode());
        result = prime * result + ((getNn0804mut() == null) ? 0 : getNn0804mut().hashCode());
        result = prime * result + ((getTn0805mu() == null) ? 0 : getTn0805mu().hashCode());
        result = prime * result + ((getNn0805mut() == null) ? 0 : getNn0805mut().hashCode());
        result = prime * result + ((getTn0806mu() == null) ? 0 : getTn0806mu().hashCode());
        result = prime * result + ((getNn0806mut() == null) ? 0 : getNn0806mut().hashCode());
        result = prime * result + ((getTn0807mu() == null) ? 0 : getTn0807mu().hashCode());
        result = prime * result + ((getNn0807mut() == null) ? 0 : getNn0807mut().hashCode());
        result = prime * result + ((getTn0808mu() == null) ? 0 : getTn0808mu().hashCode());
        result = prime * result + ((getNn0808mut() == null) ? 0 : getNn0808mut().hashCode());
        result = prime * result + ((getTn0809mu() == null) ? 0 : getTn0809mu().hashCode());
        result = prime * result + ((getNn0809mut() == null) ? 0 : getNn0809mut().hashCode());
        result = prime * result + ((getTn0810mu() == null) ? 0 : getTn0810mu().hashCode());
        result = prime * result + ((getNn0810mut() == null) ? 0 : getNn0810mut().hashCode());
        result = prime * result + ((getTn0811mu() == null) ? 0 : getTn0811mu().hashCode());
        result = prime * result + ((getNn0811mut() == null) ? 0 : getNn0811mut().hashCode());
        result = prime * result + ((getTn0812mu() == null) ? 0 : getTn0812mu().hashCode());
        result = prime * result + ((getNn0812mut() == null) ? 0 : getNn0812mut().hashCode());
        result = prime * result + ((getTn0813mu() == null) ? 0 : getTn0813mu().hashCode());
        result = prime * result + ((getNn0813mut() == null) ? 0 : getNn0813mut().hashCode());
        result = prime * result + ((getTn0814mu() == null) ? 0 : getTn0814mu().hashCode());
        result = prime * result + ((getNn0814mut() == null) ? 0 : getNn0814mut().hashCode());
        result = prime * result + ((getTn0815mu() == null) ? 0 : getTn0815mu().hashCode());
        result = prime * result + ((getNn0815mut() == null) ? 0 : getNn0815mut().hashCode());
        result = prime * result + ((getTn0816mu() == null) ? 0 : getTn0816mu().hashCode());
        result = prime * result + ((getNn0816mut() == null) ? 0 : getNn0816mut().hashCode());
        result = prime * result + ((getTn0817mu() == null) ? 0 : getTn0817mu().hashCode());
        result = prime * result + ((getNn0817mut() == null) ? 0 : getNn0817mut().hashCode());
        result = prime * result + ((getTn0818mu() == null) ? 0 : getTn0818mu().hashCode());
        result = prime * result + ((getNn0818mut() == null) ? 0 : getNn0818mut().hashCode());
        result = prime * result + ((getTn0819mu() == null) ? 0 : getTn0819mu().hashCode());
        result = prime * result + ((getNn0819mut() == null) ? 0 : getNn0819mut().hashCode());
        result = prime * result + ((getTn0820mu() == null) ? 0 : getTn0820mu().hashCode());
        result = prime * result + ((getNn0820mut() == null) ? 0 : getNn0820mut().hashCode());
        result = prime * result + ((getTn0821mu() == null) ? 0 : getTn0821mu().hashCode());
        result = prime * result + ((getNn0821mut() == null) ? 0 : getNn0821mut().hashCode());
        result = prime * result + ((getTn0822mu() == null) ? 0 : getTn0822mu().hashCode());
        result = prime * result + ((getNn0822mut() == null) ? 0 : getNn0822mut().hashCode());
        result = prime * result + ((getTn0823mu() == null) ? 0 : getTn0823mu().hashCode());
        result = prime * result + ((getNn0823mut() == null) ? 0 : getNn0823mut().hashCode());
        result = prime * result + ((getTn0824mu() == null) ? 0 : getTn0824mu().hashCode());
        result = prime * result + ((getNn0824mut() == null) ? 0 : getNn0824mut().hashCode());
        result = prime * result + ((getTn0825mu() == null) ? 0 : getTn0825mu().hashCode());
        result = prime * result + ((getNn0825mut() == null) ? 0 : getNn0825mut().hashCode());
        result = prime * result + ((getTn0826mu() == null) ? 0 : getTn0826mu().hashCode());
        result = prime * result + ((getNn0826mut() == null) ? 0 : getNn0826mut().hashCode());
        result = prime * result + ((getTn0827mu() == null) ? 0 : getTn0827mu().hashCode());
        result = prime * result + ((getNn0827mut() == null) ? 0 : getNn0827mut().hashCode());
        result = prime * result + ((getTn0828mu() == null) ? 0 : getTn0828mu().hashCode());
        result = prime * result + ((getNn0828mut() == null) ? 0 : getNn0828mut().hashCode());
        result = prime * result + ((getTn0829mu() == null) ? 0 : getTn0829mu().hashCode());
        result = prime * result + ((getNn0829mut() == null) ? 0 : getNn0829mut().hashCode());
        result = prime * result + ((getTn0830mu() == null) ? 0 : getTn0830mu().hashCode());
        result = prime * result + ((getNn0830mut() == null) ? 0 : getNn0830mut().hashCode());
        result = prime * result + ((getTn0831mu() == null) ? 0 : getTn0831mu().hashCode());
        result = prime * result + ((getNn0831mut() == null) ? 0 : getNn0831mut().hashCode());
        result = prime * result + ((getTn0832mu() == null) ? 0 : getTn0832mu().hashCode());
        result = prime * result + ((getNn0832mut() == null) ? 0 : getNn0832mut().hashCode());
        result = prime * result + ((getTn0833mu() == null) ? 0 : getTn0833mu().hashCode());
        result = prime * result + ((getNn0833mut() == null) ? 0 : getNn0833mut().hashCode());
        result = prime * result + ((getTn0834mu() == null) ? 0 : getTn0834mu().hashCode());
        result = prime * result + ((getNn0834mut() == null) ? 0 : getNn0834mut().hashCode());
        result = prime * result + ((getTn0835mu() == null) ? 0 : getTn0835mu().hashCode());
        result = prime * result + ((getNn0835mut() == null) ? 0 : getNn0835mut().hashCode());
        result = prime * result + ((getTn0836mu() == null) ? 0 : getTn0836mu().hashCode());
        result = prime * result + ((getNn0836mut() == null) ? 0 : getNn0836mut().hashCode());
        result = prime * result + ((getTn0837mu() == null) ? 0 : getTn0837mu().hashCode());
        result = prime * result + ((getNn0837mut() == null) ? 0 : getNn0837mut().hashCode());
        result = prime * result + ((getTn0838mu() == null) ? 0 : getTn0838mu().hashCode());
        result = prime * result + ((getNn0838mut() == null) ? 0 : getNn0838mut().hashCode());
        result = prime * result + ((getTn0839mu() == null) ? 0 : getTn0839mu().hashCode());
        result = prime * result + ((getNn0839mut() == null) ? 0 : getNn0839mut().hashCode());
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
        sb.append(", tn0801mu=").append(tn0801mu);
        sb.append(", nn0801mut=").append(nn0801mut);
        sb.append(", tn0802mu=").append(tn0802mu);
        sb.append(", nn0802mut=").append(nn0802mut);
        sb.append(", tn0803mu=").append(tn0803mu);
        sb.append(", nn0803mut=").append(nn0803mut);
        sb.append(", tn0804mu=").append(tn0804mu);
        sb.append(", nn0804mut=").append(nn0804mut);
        sb.append(", tn0805mu=").append(tn0805mu);
        sb.append(", nn0805mut=").append(nn0805mut);
        sb.append(", tn0806mu=").append(tn0806mu);
        sb.append(", nn0806mut=").append(nn0806mut);
        sb.append(", tn0807mu=").append(tn0807mu);
        sb.append(", nn0807mut=").append(nn0807mut);
        sb.append(", tn0808mu=").append(tn0808mu);
        sb.append(", nn0808mut=").append(nn0808mut);
        sb.append(", tn0809mu=").append(tn0809mu);
        sb.append(", nn0809mut=").append(nn0809mut);
        sb.append(", tn0810mu=").append(tn0810mu);
        sb.append(", nn0810mut=").append(nn0810mut);
        sb.append(", tn0811mu=").append(tn0811mu);
        sb.append(", nn0811mut=").append(nn0811mut);
        sb.append(", tn0812mu=").append(tn0812mu);
        sb.append(", nn0812mut=").append(nn0812mut);
        sb.append(", tn0813mu=").append(tn0813mu);
        sb.append(", nn0813mut=").append(nn0813mut);
        sb.append(", tn0814mu=").append(tn0814mu);
        sb.append(", nn0814mut=").append(nn0814mut);
        sb.append(", tn0815mu=").append(tn0815mu);
        sb.append(", nn0815mut=").append(nn0815mut);
        sb.append(", tn0816mu=").append(tn0816mu);
        sb.append(", nn0816mut=").append(nn0816mut);
        sb.append(", tn0817mu=").append(tn0817mu);
        sb.append(", nn0817mut=").append(nn0817mut);
        sb.append(", tn0818mu=").append(tn0818mu);
        sb.append(", nn0818mut=").append(nn0818mut);
        sb.append(", tn0819mu=").append(tn0819mu);
        sb.append(", nn0819mut=").append(nn0819mut);
        sb.append(", tn0820mu=").append(tn0820mu);
        sb.append(", nn0820mut=").append(nn0820mut);
        sb.append(", tn0821mu=").append(tn0821mu);
        sb.append(", nn0821mut=").append(nn0821mut);
        sb.append(", tn0822mu=").append(tn0822mu);
        sb.append(", nn0822mut=").append(nn0822mut);
        sb.append(", tn0823mu=").append(tn0823mu);
        sb.append(", nn0823mut=").append(nn0823mut);
        sb.append(", tn0824mu=").append(tn0824mu);
        sb.append(", nn0824mut=").append(nn0824mut);
        sb.append(", tn0825mu=").append(tn0825mu);
        sb.append(", nn0825mut=").append(nn0825mut);
        sb.append(", tn0826mu=").append(tn0826mu);
        sb.append(", nn0826mut=").append(nn0826mut);
        sb.append(", tn0827mu=").append(tn0827mu);
        sb.append(", nn0827mut=").append(nn0827mut);
        sb.append(", tn0828mu=").append(tn0828mu);
        sb.append(", nn0828mut=").append(nn0828mut);
        sb.append(", tn0829mu=").append(tn0829mu);
        sb.append(", nn0829mut=").append(nn0829mut);
        sb.append(", tn0830mu=").append(tn0830mu);
        sb.append(", nn0830mut=").append(nn0830mut);
        sb.append(", tn0831mu=").append(tn0831mu);
        sb.append(", nn0831mut=").append(nn0831mut);
        sb.append(", tn0832mu=").append(tn0832mu);
        sb.append(", nn0832mut=").append(nn0832mut);
        sb.append(", tn0833mu=").append(tn0833mu);
        sb.append(", nn0833mut=").append(nn0833mut);
        sb.append(", tn0834mu=").append(tn0834mu);
        sb.append(", nn0834mut=").append(nn0834mut);
        sb.append(", tn0835mu=").append(tn0835mu);
        sb.append(", nn0835mut=").append(nn0835mut);
        sb.append(", tn0836mu=").append(tn0836mu);
        sb.append(", nn0836mut=").append(nn0836mut);
        sb.append(", tn0837mu=").append(tn0837mu);
        sb.append(", nn0837mut=").append(nn0837mut);
        sb.append(", tn0838mu=").append(tn0838mu);
        sb.append(", nn0838mut=").append(nn0838mut);
        sb.append(", tn0839mu=").append(tn0839mu);
        sb.append(", nn0839mut=").append(nn0839mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}