package com.catalystplus.admin.response.paper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Data
@ToString
@ApiModel("文献简要通用响应")
public class PaperResponse implements Serializable {

    private static final long serialVersionUID = 7758532570841708024L;

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
     * 文章今日阅读次数
     */
    @ApiModelProperty("文章今日阅读次数")
    private Long todayRead;

    /**
     * 截至今日文章阅读次数
     */
    @ApiModelProperty("截至今日文章阅读次数")
    private Long readTotal;

    /**
     * 今日文章收藏次数
     */
    @ApiModelProperty("今日文章收藏次数")
    private Long todayCollect;

    /**
     * 截至今日文章收藏次数
     */
    @ApiModelProperty("截至今日文章收藏次数")
    private Long collectTotal;

    /**
     * 今日文章标签次数
     */
    @ApiModelProperty("今日文章标签次数")
    private Long todayTag;

    /**
     * 截至今日文章标签次数
     */
    @ApiModelProperty("截至今日文章标签次数")
    private Long tagTotal;

    /**
     * 今日文章做笔记次数
     */
    @ApiModelProperty("今日文章做笔记次数")
    private Long todayNote;

    /**
     * 截至今日文章做笔记次数
     */
    @ApiModelProperty("截至今日文章做笔记次数")
    private Long noteTotal;

    /**
     * 今日点赞热度
     */
    @ApiModelProperty("今日点赞热度")
    private Long todayGood;

    /**
     * 截至今日点赞热度
     */
    @ApiModelProperty("截至今日点赞热度")
    private Long goodTotal;


}
