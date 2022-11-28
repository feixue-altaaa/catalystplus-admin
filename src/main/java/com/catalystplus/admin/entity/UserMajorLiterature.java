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
 * @TableName user_major_literature
 */
@TableName(value ="user_major_literature")
@Data
public class UserMajorLiterature implements Serializable {
    /**
     * 文学专业用户信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日新增中国语言文学专业用户总数, Total Number of 0501 Major Users
     */
    private Long tn0501mu;

    /**
     * 今日新增中国语言文学专业用户数, Number of New 0501 Major Users Today
     */
    private Long nn0501mut;

    /**
     * 截至今日新增外国语言文学专业用户总数, Total Number of 0502 Major Users
     */
    private Long tn0502mu;

    /**
     * 今日新增外国语言文学专业用户数, Number of New 0502 Major Users Today
     */
    private Long nn0502mut;

    /**
     * 截至今日新增新闻传播学专业用户总数, Total Number of 0503 Major Users
     */
    private Long tn0503mu;

    /**
     * 今日新增新闻传播学专业用户数, Number of New 0503 Major Users Today
     */
    private Long nn0503mut;

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
        UserMajorLiterature other = (UserMajorLiterature) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn0501mu() == null ? other.getTn0501mu() == null : this.getTn0501mu().equals(other.getTn0501mu()))
            && (this.getNn0501mut() == null ? other.getNn0501mut() == null : this.getNn0501mut().equals(other.getNn0501mut()))
            && (this.getTn0502mu() == null ? other.getTn0502mu() == null : this.getTn0502mu().equals(other.getTn0502mu()))
            && (this.getNn0502mut() == null ? other.getNn0502mut() == null : this.getNn0502mut().equals(other.getNn0502mut()))
            && (this.getTn0503mu() == null ? other.getTn0503mu() == null : this.getTn0503mu().equals(other.getTn0503mu()))
            && (this.getNn0503mut() == null ? other.getNn0503mut() == null : this.getNn0503mut().equals(other.getNn0503mut()))
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
        result = prime * result + ((getTn0501mu() == null) ? 0 : getTn0501mu().hashCode());
        result = prime * result + ((getNn0501mut() == null) ? 0 : getNn0501mut().hashCode());
        result = prime * result + ((getTn0502mu() == null) ? 0 : getTn0502mu().hashCode());
        result = prime * result + ((getNn0502mut() == null) ? 0 : getNn0502mut().hashCode());
        result = prime * result + ((getTn0503mu() == null) ? 0 : getTn0503mu().hashCode());
        result = prime * result + ((getNn0503mut() == null) ? 0 : getNn0503mut().hashCode());
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
        sb.append(", tn0501mu=").append(tn0501mu);
        sb.append(", nn0501mut=").append(nn0501mut);
        sb.append(", tn0502mu=").append(tn0502mu);
        sb.append(", nn0502mut=").append(nn0502mut);
        sb.append(", tn0503mu=").append(tn0503mu);
        sb.append(", nn0503mut=").append(nn0503mut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}