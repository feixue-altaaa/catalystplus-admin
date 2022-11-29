package com.catalystplus.admin.response.paper;

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

    @ApiModelProperty("文献ID")
    private Long id;

    /**
     * 文献详细链接
     */
    @ApiModelProperty("文献详细链接地址")
    private String detailUrl;

    /**
     * 关联journal期刊信息
     */
    @ApiModelProperty("关联期刊表journalId")
    private Long journalId;

    /**
     * 关联journal期刊信息
     */
    @ApiModelProperty("期刊名字")
    private String journalName;

    /**
     * 文献名，英文名en_name
     */
    @ApiModelProperty("文献英文名")
    private String enName;

    /**
     * 文献名，中文名cn_name
     */
    @ApiModelProperty("文献中文名")
    private String chName;

    /**
     * 论文关键字, 格式: 关键词之间使用下划线_分隔, keyword1 _ keyword2，下划线之间有空格
     */
    @ApiModelProperty("文献所有关键字")
    private List<String> keywordList;

    /**
     * 文献图片网址
     */
    @ApiModelProperty("文献图片链接地址")
    private String imageUrl;

    /**
     * 文献发表确切时间，使用这个时间
     */
    @ApiModelProperty("文献发表确切时间，主要使用这个时间")
    private String coverDateStart;

    /**
     * doi: 论文唯一识别号，可以作为链接点开
     */
    @ApiModelProperty("文献唯一标识号")
    private String doi;

    /**
     * 论文pdf下载链接
     */
    @ApiModelProperty("文献PDF下载地址")
    private String pdfDownloadUrl;

    /**
     * sci-hub的搜索下载链接地址，先提供这个url，不行尝试hub_pdf_url
     */
    @ApiModelProperty("sci-hub的搜索下载链接地址，先提供这个url，不行尝试hub_pdf_url")
    private String hubJumpUrl;

    /**
     * sci-hub的pdf下载链接地址
     */
    @ApiModelProperty("sci-hub的pdf下载链接地址")
    private String hubPdfUrl;

    /**
     * 作者信息，格式: author1 _ author2, 下划线之间有空格
     */
    @ApiModelProperty("文献所有作者信息")
    private List<String> authorList;

    /**
     * 摘要, 英文摘要en_abstract
     */
    @ApiModelProperty("文献英文摘要")
    private String enAbstract;

    /**
     * 摘要, 中文摘要ch_abstract
     */
    @ApiModelProperty("文献中文摘要")
    private String chAbstract;

    /**
     * 论文创新点
     */
    @ApiModelProperty("文献创新点")
    private String highlights;

    /**
     * 文献图文摘要链接地址
     */
    @ApiModelProperty("文献图片摘要链接地址")
    private String graphicalAbstract;

    /**
     * 热度, popularity = a*(clickCount(平方) + 时间频率(平方))
     */
    @ApiModelProperty("文献热度")
    private Long popularity;

    /**
     * 文献点赞数
     */
    @ApiModelProperty("文献点赞数")
    private Long good;


    /**
     * 是否订阅收藏喜欢
     */
    @ApiModelProperty("用户是否喜欢该期刊，false表示不喜欢，true表示喜欢")
    private Boolean favourite;


}
