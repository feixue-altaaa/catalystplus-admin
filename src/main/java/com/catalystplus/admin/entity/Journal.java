package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 期刊信息表
 * @TableName journal
 */
@TableName(value ="journal")
@Data
public class Journal implements Serializable {
    /**
     * 期刊id, 使用雪花算法, 关闭自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * ISBN编号, 国际标准书号
     */
    private String isbn;

    /**
     * ISSN编号, 标准国际刊号
     */
    private String issn;

    /**
     * 带横杠版的issn
     */
    private String issnPrimaryFormatted;

    /**
     * 期刊名字, en_name:英文名
     */
    private String enName;

    /**
     * 期刊名字, cn_name:中文名
     */
    private String chName;

    /**
     * 期刊描述
     */
    private String description;

    /**
     * 封面图片地址链接
     */
    private String cover;

    /**
     * 期刊关联subject主题表
     */
    private Long subjectId;

    private String subjectName;

    /**
     * 关联publisher出版商表
     */
    private Long publisherId;

    /**
     * publisher名字
     */
    private String publisher;

    /**
     * 出版商的详细信息页链接
     */
    private String informationPageUrl;

    /**
     * 期刊影响因子
     */
    private Double impactFactor;

    /**
     * 是否为顶刊，0不是顶刊，1是顶刊
     */
    private Integer top;

    /**
     * 是否为开放性访问，0表示不行，1表示行
     */
    private Integer openAccess;

    /**
     * 是否为综述性期刊，0表示不是，1表示是
     */
    private Integer review;

    /**
     * Area Quartile in Category分区，1为一区，2为二区，3为三区，4为四区，以Area分区为标准
     */
    private Integer quartile;

    /**
     * Subject Quartile in Category分区，1为一区，2为二区，3为三区，4为四区
     */
    private Integer subQuartile;

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
        Journal other = (Journal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsbn() == null ? other.getIsbn() == null : this.getIsbn().equals(other.getIsbn()))
            && (this.getIssn() == null ? other.getIssn() == null : this.getIssn().equals(other.getIssn()))
            && (this.getIssnPrimaryFormatted() == null ? other.getIssnPrimaryFormatted() == null : this.getIssnPrimaryFormatted().equals(other.getIssnPrimaryFormatted()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getChName() == null ? other.getChName() == null : this.getChName().equals(other.getChName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCover() == null ? other.getCover() == null : this.getCover().equals(other.getCover()))
            && (this.getSubjectId() == null ? other.getSubjectId() == null : this.getSubjectId().equals(other.getSubjectId()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getInformationPageUrl() == null ? other.getInformationPageUrl() == null : this.getInformationPageUrl().equals(other.getInformationPageUrl()))
            && (this.getImpactFactor() == null ? other.getImpactFactor() == null : this.getImpactFactor().equals(other.getImpactFactor()))
            && (this.getTop() == null ? other.getTop() == null : this.getTop().equals(other.getTop()))
            && (this.getOpenAccess() == null ? other.getOpenAccess() == null : this.getOpenAccess().equals(other.getOpenAccess()))
            && (this.getReview() == null ? other.getReview() == null : this.getReview().equals(other.getReview()))
            && (this.getQuartile() == null ? other.getQuartile() == null : this.getQuartile().equals(other.getQuartile()))
            && (this.getSubQuartile() == null ? other.getSubQuartile() == null : this.getSubQuartile().equals(other.getSubQuartile()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIsbn() == null) ? 0 : getIsbn().hashCode());
        result = prime * result + ((getIssn() == null) ? 0 : getIssn().hashCode());
        result = prime * result + ((getIssnPrimaryFormatted() == null) ? 0 : getIssnPrimaryFormatted().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getChName() == null) ? 0 : getChName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCover() == null) ? 0 : getCover().hashCode());
        result = prime * result + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getInformationPageUrl() == null) ? 0 : getInformationPageUrl().hashCode());
        result = prime * result + ((getImpactFactor() == null) ? 0 : getImpactFactor().hashCode());
        result = prime * result + ((getTop() == null) ? 0 : getTop().hashCode());
        result = prime * result + ((getOpenAccess() == null) ? 0 : getOpenAccess().hashCode());
        result = prime * result + ((getReview() == null) ? 0 : getReview().hashCode());
        result = prime * result + ((getQuartile() == null) ? 0 : getQuartile().hashCode());
        result = prime * result + ((getSubQuartile() == null) ? 0 : getSubQuartile().hashCode());
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
        sb.append(", isbn=").append(isbn);
        sb.append(", issn=").append(issn);
        sb.append(", issnPrimaryFormatted=").append(issnPrimaryFormatted);
        sb.append(", enName=").append(enName);
        sb.append(", chName=").append(chName);
        sb.append(", description=").append(description);
        sb.append(", cover=").append(cover);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", publisherId=").append(publisherId);
        sb.append(", informationPageUrl=").append(informationPageUrl);
        sb.append(", impactFactor=").append(impactFactor);
        sb.append(", top=").append(top);
        sb.append(", openAccess=").append(openAccess);
        sb.append(", review=").append(review);
        sb.append(", quartile=").append(quartile);
        sb.append(", subQuartile=").append(subQuartile);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}