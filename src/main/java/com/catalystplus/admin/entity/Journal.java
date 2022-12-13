package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 期刊信息表
 * @TableName journal
 */
@TableName(value ="journal")
@Data
public class Journal implements Serializable {
    /**
     * id，自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 期刊id，使用自带id, 关闭自增
     */
    private Long journalId;

    /**
     * ISBN编号, 国际标准书号
     */
    private String isbn;

    /**
     * ISSN编号, 标准国际刊号，对外宣称的
     */
    private String issnL;

    /**
     * 带横杠版的issn，对外宣称的
     */
    private String issnPrimaryFormattedL;

    /**
     * ISSN(打印版编号)
     */
    private String issnPrint;

    /**
     * 带横杠版的ISSN(打印版编号)
     */
    private String issnPrintPrimaryFormatted;

    /**
     * ISSN(网络版编号)
     */
    private String issnOnline;

    /**
     * 带横杠版的ISSN(网络版编号)
     */
    private String issnOnlinePrimaryFormatted;

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
    private String enDescription;

    /**
     * 期刊描述，中文描述
     */
    private String chDescription;

    /**
     * 封面图片地址链接
     */
    private String cover;

    /**
     * 封面图片base64数据
     */
    private String coverBase64;

    /**
     * 期刊关联subject主题表,
     */
    private Long subjectId;

    /**
     * 关联publisher出版商表
     */
    private Long publisherId;

    /**
     * 期刊的名字
     */
    private String publisherName;

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
    private LocalDateTime createdTime;

    /**
     * 更新时间, 数据有变更自动更新时间
     */
    private LocalDateTime updatedTime;

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
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getJournalId() == null ? other.getJournalId() == null : this.getJournalId().equals(other.getJournalId()))
            && (this.getIsbn() == null ? other.getIsbn() == null : this.getIsbn().equals(other.getIsbn()))
            && (this.getIssnL() == null ? other.getIssnL() == null : this.getIssnL().equals(other.getIssnL()))
            && (this.getIssnPrimaryFormattedL() == null ? other.getIssnPrimaryFormattedL() == null : this.getIssnPrimaryFormattedL().equals(other.getIssnPrimaryFormattedL()))
            && (this.getIssnPrint() == null ? other.getIssnPrint() == null : this.getIssnPrint().equals(other.getIssnPrint()))
            && (this.getIssnPrintPrimaryFormatted() == null ? other.getIssnPrintPrimaryFormatted() == null : this.getIssnPrintPrimaryFormatted().equals(other.getIssnPrintPrimaryFormatted()))
            && (this.getIssnOnline() == null ? other.getIssnOnline() == null : this.getIssnOnline().equals(other.getIssnOnline()))
            && (this.getIssnOnlinePrimaryFormatted() == null ? other.getIssnOnlinePrimaryFormatted() == null : this.getIssnOnlinePrimaryFormatted().equals(other.getIssnOnlinePrimaryFormatted()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getChName() == null ? other.getChName() == null : this.getChName().equals(other.getChName()))
            && (this.getEnDescription() == null ? other.getEnDescription() == null : this.getEnDescription().equals(other.getEnDescription()))
            && (this.getChDescription() == null ? other.getChDescription() == null : this.getChDescription().equals(other.getChDescription()))
            && (this.getCover() == null ? other.getCover() == null : this.getCover().equals(other.getCover()))
            && (this.getCoverBase64() == null ? other.getCoverBase64() == null : this.getCoverBase64().equals(other.getCoverBase64()))
            && (this.getSubjectId() == null ? other.getSubjectId() == null : this.getSubjectId().equals(other.getSubjectId()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getPublisherName() == null ? other.getPublisherName() == null : this.getPublisherName().equals(other.getPublisherName()))
            && (this.getInformationPageUrl() == null ? other.getInformationPageUrl() == null : this.getInformationPageUrl().equals(other.getInformationPageUrl()))
            && (this.getImpactFactor() == null ? other.getImpactFactor() == null : this.getImpactFactor().equals(other.getImpactFactor()))
            && (this.getTop() == null ? other.getTop() == null : this.getTop().equals(other.getTop()))
            && (this.getOpenAccess() == null ? other.getOpenAccess() == null : this.getOpenAccess().equals(other.getOpenAccess()))
            && (this.getReview() == null ? other.getReview() == null : this.getReview().equals(other.getReview()))
            && (this.getQuartile() == null ? other.getQuartile() == null : this.getQuartile().equals(other.getQuartile()))
            && (this.getSubQuartile() == null ? other.getSubQuartile() == null : this.getSubQuartile().equals(other.getSubQuartile()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getJournalId() == null) ? 0 : getJournalId().hashCode());
        result = prime * result + ((getIsbn() == null) ? 0 : getIsbn().hashCode());
        result = prime * result + ((getIssnL() == null) ? 0 : getIssnL().hashCode());
        result = prime * result + ((getIssnPrimaryFormattedL() == null) ? 0 : getIssnPrimaryFormattedL().hashCode());
        result = prime * result + ((getIssnPrint() == null) ? 0 : getIssnPrint().hashCode());
        result = prime * result + ((getIssnPrintPrimaryFormatted() == null) ? 0 : getIssnPrintPrimaryFormatted().hashCode());
        result = prime * result + ((getIssnOnline() == null) ? 0 : getIssnOnline().hashCode());
        result = prime * result + ((getIssnOnlinePrimaryFormatted() == null) ? 0 : getIssnOnlinePrimaryFormatted().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getChName() == null) ? 0 : getChName().hashCode());
        result = prime * result + ((getEnDescription() == null) ? 0 : getEnDescription().hashCode());
        result = prime * result + ((getChDescription() == null) ? 0 : getChDescription().hashCode());
        result = prime * result + ((getCover() == null) ? 0 : getCover().hashCode());
        result = prime * result + ((getCoverBase64() == null) ? 0 : getCoverBase64().hashCode());
        result = prime * result + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getPublisherName() == null) ? 0 : getPublisherName().hashCode());
        result = prime * result + ((getInformationPageUrl() == null) ? 0 : getInformationPageUrl().hashCode());
        result = prime * result + ((getImpactFactor() == null) ? 0 : getImpactFactor().hashCode());
        result = prime * result + ((getTop() == null) ? 0 : getTop().hashCode());
        result = prime * result + ((getOpenAccess() == null) ? 0 : getOpenAccess().hashCode());
        result = prime * result + ((getReview() == null) ? 0 : getReview().hashCode());
        result = prime * result + ((getQuartile() == null) ? 0 : getQuartile().hashCode());
        result = prime * result + ((getSubQuartile() == null) ? 0 : getSubQuartile().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", journalId=").append(journalId);
        sb.append(", isbn=").append(isbn);
        sb.append(", issnL=").append(issnL);
        sb.append(", issnPrimaryFormattedL=").append(issnPrimaryFormattedL);
        sb.append(", issnPrint=").append(issnPrint);
        sb.append(", issnPrintPrimaryFormatted=").append(issnPrintPrimaryFormatted);
        sb.append(", issnOnline=").append(issnOnline);
        sb.append(", issnOnlinePrimaryFormatted=").append(issnOnlinePrimaryFormatted);
        sb.append(", enName=").append(enName);
        sb.append(", chName=").append(chName);
        sb.append(", enDescription=").append(enDescription);
        sb.append(", chDescription=").append(chDescription);
        sb.append(", cover=").append(cover);
        sb.append(", coverBase64=").append(coverBase64);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", publisherId=").append(publisherId);
        sb.append(", publisherName=").append(publisherName);
        sb.append(", informationPageUrl=").append(informationPageUrl);
        sb.append(", impactFactor=").append(impactFactor);
        sb.append(", top=").append(top);
        sb.append(", openAccess=").append(openAccess);
        sb.append(", review=").append(review);
        sb.append(", quartile=").append(quartile);
        sb.append(", subQuartile=").append(subQuartile);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}