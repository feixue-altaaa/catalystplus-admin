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
 * @TableName discipline_major
 */
@TableName(value ="discipline_major")
@Data
public class DisciplineMajor implements Serializable {
    /**
     * 学科专业id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学科代码
     */
    private Integer disciplineCode;

    /**
     * 学科名称
     */
    private String disciplineName;

    /**
     * 一级专业代码
     */
    private Integer majorCode;

    /**
     * 一级专业名称
     */
    private String majorName;

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
        DisciplineMajor other = (DisciplineMajor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDisciplineCode() == null ? other.getDisciplineCode() == null : this.getDisciplineCode().equals(other.getDisciplineCode()))
            && (this.getDisciplineName() == null ? other.getDisciplineName() == null : this.getDisciplineName().equals(other.getDisciplineName()))
            && (this.getMajorCode() == null ? other.getMajorCode() == null : this.getMajorCode().equals(other.getMajorCode()))
            && (this.getMajorName() == null ? other.getMajorName() == null : this.getMajorName().equals(other.getMajorName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDisciplineCode() == null) ? 0 : getDisciplineCode().hashCode());
        result = prime * result + ((getDisciplineName() == null) ? 0 : getDisciplineName().hashCode());
        result = prime * result + ((getMajorCode() == null) ? 0 : getMajorCode().hashCode());
        result = prime * result + ((getMajorName() == null) ? 0 : getMajorName().hashCode());
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
        sb.append(", disciplineCode=").append(disciplineCode);
        sb.append(", disciplineName=").append(disciplineName);
        sb.append(", majorCode=").append(majorCode);
        sb.append(", majorName=").append(majorName);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}