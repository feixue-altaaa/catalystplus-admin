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
 * @TableName user_discipline
 */
@TableName(value ="user_discipline")
@Data
public class UserDiscipline implements Serializable {
    /**
     * 用户学科信息id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 截至今日哲学用户总数, Total Numbr of philosophy Discipline Users
     */
    private Long tn01du;

    /**
     * 今日新增哲学用户数, Number of New philosophy Discipline Users Today
     */
    private Long nn01dut;

    /**
     * 截至今日经济学用户总数, Total Numbr of economics Discipline Users
     */
    private Long tn02du;

    /**
     * 今日新增经济学用户数, Number of New economics Discipline Users Today
     */
    private Long nn02dut;

    /**
     * 截至今日法学用户总数, Total Numbr of jurisprudence Discipline Users
     */
    private Long tn03du;

    /**
     * 今日新增法学用户数, Number of New jurisprudence Discipline Users Today
     */
    private Long nn03dut;

    /**
     * 截至今日教育学用户总数, Total Numbr of pedagogy Discipline Users
     */
    private Long tn04du;

    /**
     * 今日新增教育学用户数, Number of New pedagogy Discipline Users Today
     */
    private Long nn04dut;

    /**
     * 截至今日文学用户总数, Total Numbr of literature Discipline Users
     */
    private Long tn05du;

    /**
     * 今日新增文学用户数, Number of New literature Discipline Users Today
     */
    private Long nn05dut;

    /**
     * 截至今日历史学用户总数, Total Numbr of history Discipline Users
     */
    private Long tn06du;

    /**
     * 今日新增历史学用户数, Number of New history Discipline Users Today
     */
    private Long nn06dut;

    /**
     * 截至今日理学用户总数, Total Numbr of science Discipline Users
     */
    private Long tn07du;

    /**
     * 今日新增理学用户数, Number of New science Discipline Users Today
     */
    private Long nn07dut;

    /**
     * 截至今日工学用户总数, Total Numbr of engineering Discipline Users
     */
    private Long tn08du;

    /**
     * 今日新增工学用户数, Number of New engineering Discipline Users Today
     */
    private Long nn08dut;

    /**
     * 截至今日农学用户总数, Total Numbr of agronomy Discipline Users
     */
    private Long tn09du;

    /**
     * 今日新增农学用户数, Number of New agronomy Discipline Users Today
     */
    private Long nn09dut;

    /**
     * 截至今日医学用户总数, Total Numbr of medicine Discipline Users
     */
    private Long tn10du;

    /**
     * 今日新增医学用户数, Number of New medicine Discipline Users Today
     */
    private Long nn10dut;

    /**
     * 截至今日军事学用户总数, Total Numbr of military Discipline Users
     */
    private Long tn11du;

    /**
     * 今日新增军事学用户数, Number of New military Discipline Users Today
     */
    private Long nn11dut;

    /**
     * 截至今日管理学用户总数, Total Numbr of management Discipline Users
     */
    private Long tn12du;

    /**
     * 今日新增管理学学用户数, Number of New management Discipline Users Today
     */
    private Long nn12dut;

    /**
     * 截至今日艺术学用户总数, Total Numbr of art Discipline Users
     */
    private Long tn13du;

    /**
     * 今日新增艺术学用户数, Number of New art Discipline Users Today
     */
    private Long nn13dut;

    /**
     * 截至今日交叉学科用户总数, Total Numbr of inter Discipline Users
     */
    private Long tn14du;

    /**
     * 今日新增交叉学科用户数, Number of New inter Discipline Users Today
     */
    private Long nn14dut;

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
        UserDiscipline other = (UserDiscipline) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTn01du() == null ? other.getTn01du() == null : this.getTn01du().equals(other.getTn01du()))
            && (this.getNn01dut() == null ? other.getNn01dut() == null : this.getNn01dut().equals(other.getNn01dut()))
            && (this.getTn02du() == null ? other.getTn02du() == null : this.getTn02du().equals(other.getTn02du()))
            && (this.getNn02dut() == null ? other.getNn02dut() == null : this.getNn02dut().equals(other.getNn02dut()))
            && (this.getTn03du() == null ? other.getTn03du() == null : this.getTn03du().equals(other.getTn03du()))
            && (this.getNn03dut() == null ? other.getNn03dut() == null : this.getNn03dut().equals(other.getNn03dut()))
            && (this.getTn04du() == null ? other.getTn04du() == null : this.getTn04du().equals(other.getTn04du()))
            && (this.getNn04dut() == null ? other.getNn04dut() == null : this.getNn04dut().equals(other.getNn04dut()))
            && (this.getTn05du() == null ? other.getTn05du() == null : this.getTn05du().equals(other.getTn05du()))
            && (this.getNn05dut() == null ? other.getNn05dut() == null : this.getNn05dut().equals(other.getNn05dut()))
            && (this.getTn06du() == null ? other.getTn06du() == null : this.getTn06du().equals(other.getTn06du()))
            && (this.getNn06dut() == null ? other.getNn06dut() == null : this.getNn06dut().equals(other.getNn06dut()))
            && (this.getTn07du() == null ? other.getTn07du() == null : this.getTn07du().equals(other.getTn07du()))
            && (this.getNn07dut() == null ? other.getNn07dut() == null : this.getNn07dut().equals(other.getNn07dut()))
            && (this.getTn08du() == null ? other.getTn08du() == null : this.getTn08du().equals(other.getTn08du()))
            && (this.getNn08dut() == null ? other.getNn08dut() == null : this.getNn08dut().equals(other.getNn08dut()))
            && (this.getTn09du() == null ? other.getTn09du() == null : this.getTn09du().equals(other.getTn09du()))
            && (this.getNn09dut() == null ? other.getNn09dut() == null : this.getNn09dut().equals(other.getNn09dut()))
            && (this.getTn10du() == null ? other.getTn10du() == null : this.getTn10du().equals(other.getTn10du()))
            && (this.getNn10dut() == null ? other.getNn10dut() == null : this.getNn10dut().equals(other.getNn10dut()))
            && (this.getTn11du() == null ? other.getTn11du() == null : this.getTn11du().equals(other.getTn11du()))
            && (this.getNn11dut() == null ? other.getNn11dut() == null : this.getNn11dut().equals(other.getNn11dut()))
            && (this.getTn12du() == null ? other.getTn12du() == null : this.getTn12du().equals(other.getTn12du()))
            && (this.getNn12dut() == null ? other.getNn12dut() == null : this.getNn12dut().equals(other.getNn12dut()))
            && (this.getTn13du() == null ? other.getTn13du() == null : this.getTn13du().equals(other.getTn13du()))
            && (this.getNn13dut() == null ? other.getNn13dut() == null : this.getNn13dut().equals(other.getNn13dut()))
            && (this.getTn14du() == null ? other.getTn14du() == null : this.getTn14du().equals(other.getTn14du()))
            && (this.getNn14dut() == null ? other.getNn14dut() == null : this.getNn14dut().equals(other.getNn14dut()))
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
        result = prime * result + ((getTn01du() == null) ? 0 : getTn01du().hashCode());
        result = prime * result + ((getNn01dut() == null) ? 0 : getNn01dut().hashCode());
        result = prime * result + ((getTn02du() == null) ? 0 : getTn02du().hashCode());
        result = prime * result + ((getNn02dut() == null) ? 0 : getNn02dut().hashCode());
        result = prime * result + ((getTn03du() == null) ? 0 : getTn03du().hashCode());
        result = prime * result + ((getNn03dut() == null) ? 0 : getNn03dut().hashCode());
        result = prime * result + ((getTn04du() == null) ? 0 : getTn04du().hashCode());
        result = prime * result + ((getNn04dut() == null) ? 0 : getNn04dut().hashCode());
        result = prime * result + ((getTn05du() == null) ? 0 : getTn05du().hashCode());
        result = prime * result + ((getNn05dut() == null) ? 0 : getNn05dut().hashCode());
        result = prime * result + ((getTn06du() == null) ? 0 : getTn06du().hashCode());
        result = prime * result + ((getNn06dut() == null) ? 0 : getNn06dut().hashCode());
        result = prime * result + ((getTn07du() == null) ? 0 : getTn07du().hashCode());
        result = prime * result + ((getNn07dut() == null) ? 0 : getNn07dut().hashCode());
        result = prime * result + ((getTn08du() == null) ? 0 : getTn08du().hashCode());
        result = prime * result + ((getNn08dut() == null) ? 0 : getNn08dut().hashCode());
        result = prime * result + ((getTn09du() == null) ? 0 : getTn09du().hashCode());
        result = prime * result + ((getNn09dut() == null) ? 0 : getNn09dut().hashCode());
        result = prime * result + ((getTn10du() == null) ? 0 : getTn10du().hashCode());
        result = prime * result + ((getNn10dut() == null) ? 0 : getNn10dut().hashCode());
        result = prime * result + ((getTn11du() == null) ? 0 : getTn11du().hashCode());
        result = prime * result + ((getNn11dut() == null) ? 0 : getNn11dut().hashCode());
        result = prime * result + ((getTn12du() == null) ? 0 : getTn12du().hashCode());
        result = prime * result + ((getNn12dut() == null) ? 0 : getNn12dut().hashCode());
        result = prime * result + ((getTn13du() == null) ? 0 : getTn13du().hashCode());
        result = prime * result + ((getNn13dut() == null) ? 0 : getNn13dut().hashCode());
        result = prime * result + ((getTn14du() == null) ? 0 : getTn14du().hashCode());
        result = prime * result + ((getNn14dut() == null) ? 0 : getNn14dut().hashCode());
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
        sb.append(", tn01du=").append(tn01du);
        sb.append(", nn01dut=").append(nn01dut);
        sb.append(", tn02du=").append(tn02du);
        sb.append(", nn02dut=").append(nn02dut);
        sb.append(", tn03du=").append(tn03du);
        sb.append(", nn03dut=").append(nn03dut);
        sb.append(", tn04du=").append(tn04du);
        sb.append(", nn04dut=").append(nn04dut);
        sb.append(", tn05du=").append(tn05du);
        sb.append(", nn05dut=").append(nn05dut);
        sb.append(", tn06du=").append(tn06du);
        sb.append(", nn06dut=").append(nn06dut);
        sb.append(", tn07du=").append(tn07du);
        sb.append(", nn07dut=").append(nn07dut);
        sb.append(", tn08du=").append(tn08du);
        sb.append(", nn08dut=").append(nn08dut);
        sb.append(", tn09du=").append(tn09du);
        sb.append(", nn09dut=").append(nn09dut);
        sb.append(", tn10du=").append(tn10du);
        sb.append(", nn10dut=").append(nn10dut);
        sb.append(", tn11du=").append(tn11du);
        sb.append(", nn11dut=").append(nn11dut);
        sb.append(", tn12du=").append(tn12du);
        sb.append(", nn12dut=").append(nn12dut);
        sb.append(", tn13du=").append(tn13du);
        sb.append(", nn13dut=").append(nn13dut);
        sb.append(", tn14du=").append(tn14du);
        sb.append(", nn14dut=").append(nn14dut);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}