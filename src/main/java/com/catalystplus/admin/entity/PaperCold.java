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
 *
 * @TableName paper_cold
 */
@TableName(value = "paper_cold")
@Data
public class PaperCold implements Serializable {
    /**
     * 论文冷门信息id, 使用雪花算法, 关闭自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关联paper文献表
     */
    private Long paperId;

    /**
     * 卷,期
     */
    private String volume;

    /**
     * 文献发表时间
     */
    private String coverDateText;

    /**
     * 论文网上可见时间
     */
    private String availableOnline;

    /**
     * 出版社开始接收时间
     */
    private String received;

    /**
     * 出版社驳回修订时间
     */
    private String revised;

    /**
     * 出版社接受时间
     */
    private String accepted;

    /**
     * 英文版发表时间
     */
    private String publicationDate;

    /**
     * 记录版本号
     */
    private String versionOfRecord;

    /**
     * 详细时间戳
     */
    private String detailTimestamp;

    /**
     * 版权所属
     */
    private String copyrightLine;

    /**
     * 内部数据
     */
    private String cid;

    /**
     * 内部数据
     */
    private String eid;

    /**
     * 可以关联hub
     */
    private String hubEid;

    /**
     * 外部上一期期刊的关键词信息
     */
    private String issuePii;

    /**
     * 内部上一期期刊的关键词信息
     */
    private String pii;

    /**
     * 论文在期刊的首页
     */
    private String firstPage;

    /**
     * 论文在期刊的末尾页
     */
    private String lastPage;

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
        PaperCold other = (PaperCold) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPaperId() == null ? other.getPaperId() == null : this.getPaperId().equals(other.getPaperId()))
                && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
                && (this.getCoverDateText() == null ? other.getCoverDateText() == null : this.getCoverDateText().equals(other.getCoverDateText()))
                && (this.getAvailableOnline() == null ? other.getAvailableOnline() == null : this.getAvailableOnline().equals(other.getAvailableOnline()))
                && (this.getReceived() == null ? other.getReceived() == null : this.getReceived().equals(other.getReceived()))
                && (this.getRevised() == null ? other.getRevised() == null : this.getRevised().equals(other.getRevised()))
                && (this.getAccepted() == null ? other.getAccepted() == null : this.getAccepted().equals(other.getAccepted()))
                && (this.getPublicationDate() == null ? other.getPublicationDate() == null : this.getPublicationDate().equals(other.getPublicationDate()))
                && (this.getVersionOfRecord() == null ? other.getVersionOfRecord() == null : this.getVersionOfRecord().equals(other.getVersionOfRecord()))
                && (this.getDetailTimestamp() == null ? other.getDetailTimestamp() == null : this.getDetailTimestamp().equals(other.getDetailTimestamp()))
                && (this.getCopyrightLine() == null ? other.getCopyrightLine() == null : this.getCopyrightLine().equals(other.getCopyrightLine()))
                && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
                && (this.getEid() == null ? other.getEid() == null : this.getEid().equals(other.getEid()))
                && (this.getHubEid() == null ? other.getHubEid() == null : this.getHubEid().equals(other.getHubEid()))
                && (this.getIssuePii() == null ? other.getIssuePii() == null : this.getIssuePii().equals(other.getIssuePii()))
                && (this.getPii() == null ? other.getPii() == null : this.getPii().equals(other.getPii()))
                && (this.getFirstPage() == null ? other.getFirstPage() == null : this.getFirstPage().equals(other.getFirstPage()))
                && (this.getLastPage() == null ? other.getLastPage() == null : this.getLastPage().equals(other.getLastPage()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
                && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPaperId() == null) ? 0 : getPaperId().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getCoverDateText() == null) ? 0 : getCoverDateText().hashCode());
        result = prime * result + ((getAvailableOnline() == null) ? 0 : getAvailableOnline().hashCode());
        result = prime * result + ((getReceived() == null) ? 0 : getReceived().hashCode());
        result = prime * result + ((getRevised() == null) ? 0 : getRevised().hashCode());
        result = prime * result + ((getAccepted() == null) ? 0 : getAccepted().hashCode());
        result = prime * result + ((getPublicationDate() == null) ? 0 : getPublicationDate().hashCode());
        result = prime * result + ((getVersionOfRecord() == null) ? 0 : getVersionOfRecord().hashCode());
        result = prime * result + ((getDetailTimestamp() == null) ? 0 : getDetailTimestamp().hashCode());
        result = prime * result + ((getCopyrightLine() == null) ? 0 : getCopyrightLine().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getEid() == null) ? 0 : getEid().hashCode());
        result = prime * result + ((getHubEid() == null) ? 0 : getHubEid().hashCode());
        result = prime * result + ((getIssuePii() == null) ? 0 : getIssuePii().hashCode());
        result = prime * result + ((getPii() == null) ? 0 : getPii().hashCode());
        result = prime * result + ((getFirstPage() == null) ? 0 : getFirstPage().hashCode());
        result = prime * result + ((getLastPage() == null) ? 0 : getLastPage().hashCode());
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
        sb.append(", paperId=").append(paperId);
        sb.append(", volume=").append(volume);
        sb.append(", coverDateText=").append(coverDateText);
        sb.append(", availableOnline=").append(availableOnline);
        sb.append(", received=").append(received);
        sb.append(", revised=").append(revised);
        sb.append(", accepted=").append(accepted);
        sb.append(", publicationDate=").append(publicationDate);
        sb.append(", versionOfRecord=").append(versionOfRecord);
        sb.append(", detailTimestamp=").append(detailTimestamp);
        sb.append(", copyrightLine=").append(copyrightLine);
        sb.append(", cid=").append(cid);
        sb.append(", eid=").append(eid);
        sb.append(", hubEid=").append(hubEid);
        sb.append(", issuePii=").append(issuePii);
        sb.append(", pii=").append(pii);
        sb.append(", firstPage=").append(firstPage);
        sb.append(", lastPage=").append(lastPage);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}