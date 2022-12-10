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
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 本科生
     */
    private Long undergraduates;

    /**
     * 硕士生
     */
    private Long masters;

    /**
     * 博士生
     */
    private Long doctors;

    /**
     * 老师
     */
    private Long teachers;

    /**
     * c9院校用户
     */
    private Long universityC9;

    /**
     * 985院校用户
     */
    private Long university985;

    /**
     * 211院校用户
     */
    private Long university211;

    /**
     * 其他院校用户
     */
    private Long universityOther;

    /**
     * 学科
     */
    private Long discipline;

    /**
     * 专业
     */
    private Long major;

    /**
     * 今日新增数量
     */
    private Long addNumber;

    /**
     * 截至今日总数量
     */
    private Long totalNumber;

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
            && (this.getUndergraduates() == null ? other.getUndergraduates() == null : this.getUndergraduates().equals(other.getUndergraduates()))
            && (this.getMasters() == null ? other.getMasters() == null : this.getMasters().equals(other.getMasters()))
            && (this.getDoctors() == null ? other.getDoctors() == null : this.getDoctors().equals(other.getDoctors()))
            && (this.getTeachers() == null ? other.getTeachers() == null : this.getTeachers().equals(other.getTeachers()))
            && (this.getUniversityC9() == null ? other.getUniversityC9() == null : this.getUniversityC9().equals(other.getUniversityC9()))
            && (this.getUniversity985() == null ? other.getUniversity985() == null : this.getUniversity985().equals(other.getUniversity985()))
            && (this.getUniversity211() == null ? other.getUniversity211() == null : this.getUniversity211().equals(other.getUniversity211()))
            && (this.getUniversityOther() == null ? other.getUniversityOther() == null : this.getUniversityOther().equals(other.getUniversityOther()))
            && (this.getDiscipline() == null ? other.getDiscipline() == null : this.getDiscipline().equals(other.getDiscipline()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getAddNumber() == null ? other.getAddNumber() == null : this.getAddNumber().equals(other.getAddNumber()))
            && (this.getTotalNumber() == null ? other.getTotalNumber() == null : this.getTotalNumber().equals(other.getTotalNumber()))
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
        result = prime * result + ((getUndergraduates() == null) ? 0 : getUndergraduates().hashCode());
        result = prime * result + ((getMasters() == null) ? 0 : getMasters().hashCode());
        result = prime * result + ((getDoctors() == null) ? 0 : getDoctors().hashCode());
        result = prime * result + ((getTeachers() == null) ? 0 : getTeachers().hashCode());
        result = prime * result + ((getUniversityC9() == null) ? 0 : getUniversityC9().hashCode());
        result = prime * result + ((getUniversity985() == null) ? 0 : getUniversity985().hashCode());
        result = prime * result + ((getUniversity211() == null) ? 0 : getUniversity211().hashCode());
        result = prime * result + ((getUniversityOther() == null) ? 0 : getUniversityOther().hashCode());
        result = prime * result + ((getDiscipline() == null) ? 0 : getDiscipline().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getAddNumber() == null) ? 0 : getAddNumber().hashCode());
        result = prime * result + ((getTotalNumber() == null) ? 0 : getTotalNumber().hashCode());
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
        sb.append(", undergraduates=").append(undergraduates);
        sb.append(", masters=").append(masters);
        sb.append(", doctors=").append(doctors);
        sb.append(", teachers=").append(teachers);
        sb.append(", universityC9=").append(universityC9);
        sb.append(", university985=").append(university985);
        sb.append(", university211=").append(university211);
        sb.append(", universityOther=").append(universityOther);
        sb.append(", discipline=").append(discipline);
        sb.append(", major=").append(major);
        sb.append(", addNumber=").append(addNumber);
        sb.append(", totalNumber=").append(totalNumber);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}