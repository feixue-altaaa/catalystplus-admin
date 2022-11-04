package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文献详细表
 * @TableName paper
 */
@TableName(value ="paper")
@Data
public class Paper implements Serializable {
    /**
     * 论文关键字id, 使用雪花算法, 关闭自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 文献详细链接
     */
    private String detailUrl;

    /**
     * 关联journal期刊信息
     */
    private Long journalId;

    /**
     * 期刊名字
     */
    private String journalName;

    /**
     * 文献名，英文名en_name
     */
    private String enName;

    /**
     * 文献名，中文名cn_name
     */
    private String chName;

    /**
     * 论文关键字, 格式: 关键词之间使用下划线_分隔, keyword1 _ keyword2，下划线之间有空格
     */
    private String keyword;

    /**
     * 文献图片网址
     */
    private String imageUrl;

    /**
     * 文献发表确切时间，使用这个时间
     */
    private String coverDateStart;

    /**
     * doi: 论文唯一识别号，可以作为链接点开
     */
    private String doi;

    /**
     * 论文pdf下载链接
     */
    private String pdfDownloadUrl;

    /**
     * sci-hub的搜索下载链接地址，先提供这个url，不行尝试hub_pdf_url
     */
    private String hubJumpUrl;

    /**
     * sci-hub的pdf下载链接地址
     */
    private String hubPdfUrl;

    /**
     * 作者信息，格式: author1 _ author2, 下划线之间有空格
     */
    private String authors;

    /**
     * 摘要, 英文摘要en_abstract
     */
    private String enAbstract;

    /**
     * 摘要, 中文摘要ch_abstract
     */
    private String chAbstract;

    /**
     * 论文创新点
     */
    private String highlights;

    /**
     * 文献图文摘要图片链接
     */
    private String graphicalAbstract;

    /**
     * 热度, popularity = a*(clickCount(平方) + 时间频率(平方))
     */
    private Long popularity;

    /**
     * 每篇文章的点击次数
     */
    private Long clickCount;

    /**
     * 时间评率, 定时任务
     */
    private Long timeFrequency;

    /**
     * 文献点赞数
     */
    private Long good;

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
        Paper other = (Paper) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDetailUrl() == null ? other.getDetailUrl() == null : this.getDetailUrl().equals(other.getDetailUrl()))
            && (this.getJournalId() == null ? other.getJournalId() == null : this.getJournalId().equals(other.getJournalId()))
            && (this.getJournalName() == null ? other.getJournalName() == null : this.getJournalName().equals(other.getJournalName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getChName() == null ? other.getChName() == null : this.getChName().equals(other.getChName()))
            && (this.getKeyword() == null ? other.getKeyword() == null : this.getKeyword().equals(other.getKeyword()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getCoverDateStart() == null ? other.getCoverDateStart() == null : this.getCoverDateStart().equals(other.getCoverDateStart()))
            && (this.getDoi() == null ? other.getDoi() == null : this.getDoi().equals(other.getDoi()))
            && (this.getPdfDownloadUrl() == null ? other.getPdfDownloadUrl() == null : this.getPdfDownloadUrl().equals(other.getPdfDownloadUrl()))
            && (this.getHubJumpUrl() == null ? other.getHubJumpUrl() == null : this.getHubJumpUrl().equals(other.getHubJumpUrl()))
            && (this.getHubPdfUrl() == null ? other.getHubPdfUrl() == null : this.getHubPdfUrl().equals(other.getHubPdfUrl()))
            && (this.getAuthors() == null ? other.getAuthors() == null : this.getAuthors().equals(other.getAuthors()))
            && (this.getEnAbstract() == null ? other.getEnAbstract() == null : this.getEnAbstract().equals(other.getEnAbstract()))
            && (this.getChAbstract() == null ? other.getChAbstract() == null : this.getChAbstract().equals(other.getChAbstract()))
            && (this.getHighlights() == null ? other.getHighlights() == null : this.getHighlights().equals(other.getHighlights()))
            && (this.getGraphicalAbstract() == null ? other.getGraphicalAbstract() == null : this.getGraphicalAbstract().equals(other.getGraphicalAbstract()))
            && (this.getPopularity() == null ? other.getPopularity() == null : this.getPopularity().equals(other.getPopularity()))
            && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
            && (this.getTimeFrequency() == null ? other.getTimeFrequency() == null : this.getTimeFrequency().equals(other.getTimeFrequency()))
            && (this.getGood() == null ? other.getGood() == null : this.getGood().equals(other.getGood()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDetailUrl() == null) ? 0 : getDetailUrl().hashCode());
        result = prime * result + ((getJournalId() == null) ? 0 : getJournalId().hashCode());
        result = prime * result + ((getJournalName() == null) ? 0 : getJournalName().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getChName() == null) ? 0 : getChName().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getCoverDateStart() == null) ? 0 : getCoverDateStart().hashCode());
        result = prime * result + ((getDoi() == null) ? 0 : getDoi().hashCode());
        result = prime * result + ((getPdfDownloadUrl() == null) ? 0 : getPdfDownloadUrl().hashCode());
        result = prime * result + ((getHubJumpUrl() == null) ? 0 : getHubJumpUrl().hashCode());
        result = prime * result + ((getHubPdfUrl() == null) ? 0 : getHubPdfUrl().hashCode());
        result = prime * result + ((getAuthors() == null) ? 0 : getAuthors().hashCode());
        result = prime * result + ((getEnAbstract() == null) ? 0 : getEnAbstract().hashCode());
        result = prime * result + ((getChAbstract() == null) ? 0 : getChAbstract().hashCode());
        result = prime * result + ((getHighlights() == null) ? 0 : getHighlights().hashCode());
        result = prime * result + ((getGraphicalAbstract() == null) ? 0 : getGraphicalAbstract().hashCode());
        result = prime * result + ((getPopularity() == null) ? 0 : getPopularity().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
        result = prime * result + ((getTimeFrequency() == null) ? 0 : getTimeFrequency().hashCode());
        result = prime * result + ((getGood() == null) ? 0 : getGood().hashCode());
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
        sb.append(", detailUrl=").append(detailUrl);
        sb.append(", journalId=").append(journalId);
        sb.append(", journalName=").append(journalName);
        sb.append(", enName=").append(enName);
        sb.append(", chName=").append(chName);
        sb.append(", keyword=").append(keyword);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", coverDateStart=").append(coverDateStart);
        sb.append(", doi=").append(doi);
        sb.append(", pdfDownloadUrl=").append(pdfDownloadUrl);
        sb.append(", hubJumpUrl=").append(hubJumpUrl);
        sb.append(", hubPdfUrl=").append(hubPdfUrl);
        sb.append(", authors=").append(authors);
        sb.append(", enAbstract=").append(enAbstract);
        sb.append(", chAbstract=").append(chAbstract);
        sb.append(", highlights=").append(highlights);
        sb.append(", graphicalAbstract=").append(graphicalAbstract);
        sb.append(", popularity=").append(popularity);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", timeFrequency=").append(timeFrequency);
        sb.append(", good=").append(good);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}