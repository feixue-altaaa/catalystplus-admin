package com.catalystplus.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文献详细表
 * @TableName paper 逻辑表名
 */
@TableName(value ="paper")
@Data
public class Paper implements Serializable {
    /**
     * 论文关键字id, 使用雪花算法, 关闭自增
     */
    //当配置了shardingsphere-jdbc的分布式序列时，自动使用shardingsphere-jdbc的分布式序列
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 出版商名称
     */
    private String publisher;

    /**
     * 出版商id
     */
    private Long publisherId;

    /**
     * 关联出版刊物信息
     */
    private Long publicationId;

    /**
     * 出版刊物名称
     */
    private String publicationName;

    /**
     * 出版刊物类型 示例：jounal / book / ...
     */
    private String publicationType;

    /**
     * 出版刊物封面图片链接
     */
    private String publicationCover;

    /**
     * 文献类型 具体以各个站点给到的数据为准：
     * Elseiver的paper_type 数据示例：text  /full-text/...
     * Nature 的paper_type 数据示例：article  /news/...
     * 这里的数据不做同一的规范，以站点为准
     */
    private String paperType;

    /**
     * 文献详细链接
     */
    private String paperUrl;

    /**
     * 文献名，英文名en_name，携带html标签
     */
    private String enNameHtml;

    /**
     * 文献名，英文名en_name
     */
    private String enName;

    /**
     * 文献名，中文名ch_name
     */
    private String chName;

    /**
     * 摘要, 英文摘要, 携带html源码信息
     */
    private String abstractHtml;

    /**
     * 摘要, 英文摘要en_abstract
     */
    private String enAbstract;

    /**
     * 摘要, 中文摘要ch_abstract
     */
    private String chAbstract;

    /**
     * 文献图文摘要图片链接
     */
    private String graphicalAbstract;

    /**
     * 论文关键字, 格式: 关键词之间使用用竖线分割, 竖线两边有空格，keyword1 | keyword2
     */
    private String keywords;

    /**
     * 作者信息，格式: author1 | author2, 用竖线分割，竖线两边有空格
     */
    private String authors;

    /**
     * doi: 论文唯一识别号
     */
    private String doi;

    /**
     * 论文pdf下载链接,来自出版商提供的
     */
    private String pdfPublisher;

    /**
     * 论文pdf下载链接,来自Sci-Hub提供的
     */
    private String pdfHub;

    /**
     * 文献所在期刊的卷号
     */
    private String volume;

    /**
     * 文献所在期刊的期号
     */
    private String issue;

    /**
     * 论文在期刊的首页-页码
     */
    private String firstPage;

    /**
     * 论文在期刊的末尾页-页码
     */
    private String lastPage;

    /**
     * 版权所属
     */
    private String copyrightLine;

    /**
     * 引用文献数量
     */
    private Integer referenceNums;

    /**
     * 引用文献内容
     */
    private String referenceContent;

    /**
     * 被引用文献数量
     */
    private Integer citationNums;

    /**
     * 被引用文献内容
     */
    private String citationContent;

    /**
     * 文献发表确切时间，使用这个时间
     */
    private String coverDateStart;

    /**
     * 文献发表时间
     */
    private String coverDateText;

    /**
     * 论文网上可见时间
     */
    private String availableOnline;

    /**
     * 出版社开始接收时间，多个接收的时间， 格式: 关键词之间使用竖线 | 分隔, received1 | received2，下划线之间有空格
     */
    private String receiveds;

    /**
     * 出版社驳回修订时间，多个驳回修订时间， 格式: 关键词之间使用竖线 | 分隔, received1 | received2，下划线之间有空格
     */
    private String reviseds;

    /**
     * 出版社接受时间
     */
    private String accepted;

    /**
     * 英文版发表时间
     */
    private String publicationDate;

    /**
     * 文献的其他信息放入该类目, 暂不解析
     */
    private String elseMessage;

    /**
     * 热度, popularity = a*(clickCount(平方) + 时间频率(平方))
     */
    private Long popularity;

    /**
     * 每篇文章的点击次数
     */
    private Long clickCount;

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
        Paper other = (Paper) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPublisher() == null ? other.getPublisher() == null : this.getPublisher().equals(other.getPublisher()))
                && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
                && (this.getPublicationId() == null ? other.getPublicationId() == null : this.getPublicationId().equals(other.getPublicationId()))
                && (this.getPublicationName() == null ? other.getPublicationName() == null : this.getPublicationName().equals(other.getPublicationName()))
                && (this.getPublicationType() == null ? other.getPublicationType() == null : this.getPublicationType().equals(other.getPublicationType()))
                && (this.getPublicationCover() == null ? other.getPublicationCover() == null : this.getPublicationCover().equals(other.getPublicationCover()))
                && (this.getPaperType() == null ? other.getPaperType() == null : this.getPaperType().equals(other.getPaperType()))
                && (this.getPaperUrl() == null ? other.getPaperUrl() == null : this.getPaperUrl().equals(other.getPaperUrl()))
                && (this.getEnNameHtml() == null ? other.getEnNameHtml() == null : this.getEnNameHtml().equals(other.getEnNameHtml()))
                && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
                && (this.getChName() == null ? other.getChName() == null : this.getChName().equals(other.getChName()))
                && (this.getAbstractHtml() == null ? other.getAbstractHtml() == null : this.getAbstractHtml().equals(other.getAbstractHtml()))
                && (this.getEnAbstract() == null ? other.getEnAbstract() == null : this.getEnAbstract().equals(other.getEnAbstract()))
                && (this.getChAbstract() == null ? other.getChAbstract() == null : this.getChAbstract().equals(other.getChAbstract()))
                && (this.getGraphicalAbstract() == null ? other.getGraphicalAbstract() == null : this.getGraphicalAbstract().equals(other.getGraphicalAbstract()))
                && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
                && (this.getAuthors() == null ? other.getAuthors() == null : this.getAuthors().equals(other.getAuthors()))
                && (this.getDoi() == null ? other.getDoi() == null : this.getDoi().equals(other.getDoi()))
                && (this.getPdfPublisher() == null ? other.getPdfPublisher() == null : this.getPdfPublisher().equals(other.getPdfPublisher()))
                && (this.getPdfHub() == null ? other.getPdfHub() == null : this.getPdfHub().equals(other.getPdfHub()))
                && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
                && (this.getIssue() == null ? other.getIssue() == null : this.getIssue().equals(other.getIssue()))
                && (this.getFirstPage() == null ? other.getFirstPage() == null : this.getFirstPage().equals(other.getFirstPage()))
                && (this.getLastPage() == null ? other.getLastPage() == null : this.getLastPage().equals(other.getLastPage()))
                && (this.getCopyrightLine() == null ? other.getCopyrightLine() == null : this.getCopyrightLine().equals(other.getCopyrightLine()))
                && (this.getReferenceNums() == null ? other.getReferenceNums() == null : this.getReferenceNums().equals(other.getReferenceNums()))
                && (this.getReferenceContent() == null ? other.getReferenceContent() == null : this.getReferenceContent().equals(other.getReferenceContent()))
                && (this.getCitationNums() == null ? other.getCitationNums() == null : this.getCitationNums().equals(other.getCitationNums()))
                && (this.getCitationContent() == null ? other.getCitationContent() == null : this.getCitationContent().equals(other.getCitationContent()))
                && (this.getCoverDateStart() == null ? other.getCoverDateStart() == null : this.getCoverDateStart().equals(other.getCoverDateStart()))
                && (this.getCoverDateText() == null ? other.getCoverDateText() == null : this.getCoverDateText().equals(other.getCoverDateText()))
                && (this.getAvailableOnline() == null ? other.getAvailableOnline() == null : this.getAvailableOnline().equals(other.getAvailableOnline()))
                && (this.getReceiveds() == null ? other.getReceiveds() == null : this.getReceiveds().equals(other.getReceiveds()))
                && (this.getReviseds() == null ? other.getReviseds() == null : this.getReviseds().equals(other.getReviseds()))
                && (this.getAccepted() == null ? other.getAccepted() == null : this.getAccepted().equals(other.getAccepted()))
                && (this.getPublicationDate() == null ? other.getPublicationDate() == null : this.getPublicationDate().equals(other.getPublicationDate()))
                && (this.getElseMessage() == null ? other.getElseMessage() == null : this.getElseMessage().equals(other.getElseMessage()))
                && (this.getPopularity() == null ? other.getPopularity() == null : this.getPopularity().equals(other.getPopularity()))
                && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
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
        result = prime * result + ((getPublisher() == null) ? 0 : getPublisher().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getPublicationId() == null) ? 0 : getPublicationId().hashCode());
        result = prime * result + ((getPublicationName() == null) ? 0 : getPublicationName().hashCode());
        result = prime * result + ((getPublicationType() == null) ? 0 : getPublicationType().hashCode());
        result = prime * result + ((getPublicationCover() == null) ? 0 : getPublicationCover().hashCode());
        result = prime * result + ((getPaperType() == null) ? 0 : getPaperType().hashCode());
        result = prime * result + ((getPaperUrl() == null) ? 0 : getPaperUrl().hashCode());
        result = prime * result + ((getEnNameHtml() == null) ? 0 : getEnNameHtml().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getChName() == null) ? 0 : getChName().hashCode());
        result = prime * result + ((getAbstractHtml() == null) ? 0 : getAbstractHtml().hashCode());
        result = prime * result + ((getEnAbstract() == null) ? 0 : getEnAbstract().hashCode());
        result = prime * result + ((getChAbstract() == null) ? 0 : getChAbstract().hashCode());
        result = prime * result + ((getGraphicalAbstract() == null) ? 0 : getGraphicalAbstract().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getAuthors() == null) ? 0 : getAuthors().hashCode());
        result = prime * result + ((getDoi() == null) ? 0 : getDoi().hashCode());
        result = prime * result + ((getPdfPublisher() == null) ? 0 : getPdfPublisher().hashCode());
        result = prime * result + ((getPdfHub() == null) ? 0 : getPdfHub().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getIssue() == null) ? 0 : getIssue().hashCode());
        result = prime * result + ((getFirstPage() == null) ? 0 : getFirstPage().hashCode());
        result = prime * result + ((getLastPage() == null) ? 0 : getLastPage().hashCode());
        result = prime * result + ((getCopyrightLine() == null) ? 0 : getCopyrightLine().hashCode());
        result = prime * result + ((getReferenceNums() == null) ? 0 : getReferenceNums().hashCode());
        result = prime * result + ((getReferenceContent() == null) ? 0 : getReferenceContent().hashCode());
        result = prime * result + ((getCitationNums() == null) ? 0 : getCitationNums().hashCode());
        result = prime * result + ((getCitationContent() == null) ? 0 : getCitationContent().hashCode());
        result = prime * result + ((getCoverDateStart() == null) ? 0 : getCoverDateStart().hashCode());
        result = prime * result + ((getCoverDateText() == null) ? 0 : getCoverDateText().hashCode());
        result = prime * result + ((getAvailableOnline() == null) ? 0 : getAvailableOnline().hashCode());
        result = prime * result + ((getReceiveds() == null) ? 0 : getReceiveds().hashCode());
        result = prime * result + ((getReviseds() == null) ? 0 : getReviseds().hashCode());
        result = prime * result + ((getAccepted() == null) ? 0 : getAccepted().hashCode());
        result = prime * result + ((getPublicationDate() == null) ? 0 : getPublicationDate().hashCode());
        result = prime * result + ((getElseMessage() == null) ? 0 : getElseMessage().hashCode());
        result = prime * result + ((getPopularity() == null) ? 0 : getPopularity().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
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
        sb.append(", publisher=").append(publisher);
        sb.append(", publisherId=").append(publisherId);
        sb.append(", publicationId=").append(publicationId);
        sb.append(", publicationName=").append(publicationName);
        sb.append(", publicationType=").append(publicationType);
        sb.append(", publicationCover=").append(publicationCover);
        sb.append(", paperType=").append(paperType);
        sb.append(", paperUrl=").append(paperUrl);
        sb.append(", enNameHtml=").append(enNameHtml);
        sb.append(", enName=").append(enName);
        sb.append(", chName=").append(chName);
        sb.append(", abstractHtml=").append(abstractHtml);
        sb.append(", enAbstract=").append(enAbstract);
        sb.append(", chAbstract=").append(chAbstract);
        sb.append(", graphicalAbstract=").append(graphicalAbstract);
        sb.append(", keywords=").append(keywords);
        sb.append(", authors=").append(authors);
        sb.append(", doi=").append(doi);
        sb.append(", pdfPublisher=").append(pdfPublisher);
        sb.append(", pdfHub=").append(pdfHub);
        sb.append(", volume=").append(volume);
        sb.append(", issue=").append(issue);
        sb.append(", firstPage=").append(firstPage);
        sb.append(", lastPage=").append(lastPage);
        sb.append(", copyrightLine=").append(copyrightLine);
        sb.append(", referenceNums=").append(referenceNums);
        sb.append(", referenceContent=").append(referenceContent);
        sb.append(", citationNums=").append(citationNums);
        sb.append(", citationContent=").append(citationContent);
        sb.append(", coverDateStart=").append(coverDateStart);
        sb.append(", coverDateText=").append(coverDateText);
        sb.append(", availableOnline=").append(availableOnline);
        sb.append(", receiveds=").append(receiveds);
        sb.append(", reviseds=").append(reviseds);
        sb.append(", accepted=").append(accepted);
        sb.append(", publicationDate=").append(publicationDate);
        sb.append(", elseMessage=").append(elseMessage);
        sb.append(", popularity=").append(popularity);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", good=").append(good);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}