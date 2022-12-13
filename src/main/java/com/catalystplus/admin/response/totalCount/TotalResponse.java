package com.catalystplus.admin.response.totalCount;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@ApiModel("total_count截至今日响应")
public class TotalResponse implements Serializable {

    private static final long serialVersionUID = 7489935072611746156L;

    /**
     * id，自增
     */
    @ApiModelProperty("自增ID")
    private Long id;

    /**
     * 截至今日文章阅读次数
     */
    @ApiModelProperty("截至今日文章阅读次数")
    private Long readTotal;

    /**
     * 截至今日文章收藏次数
     */
    @ApiModelProperty("截至今日文章收藏次数")
    private Long collectTotal;

    /**
     * 截至今日文章标签次数
     */
    @ApiModelProperty("截至今日文章标签次数")
    private Long tagTotal;

    /**
     * 截至今日文章做笔记次数
     */
    @ApiModelProperty("截至今日文章做笔记次数")
    private Long noteTotal;

    /**
     * 截至今日点赞热度
     */
    @ApiModelProperty("截至今日点赞热度")
    private Long goodTotal;

    /**
     * 截至今日期刊订阅总量
     */
    @ApiModelProperty("截至今日期刊订阅总量")
    private Long subscriptionTotal;

    /**
     * 截至今日文章阅读用户次数
     */
    private Long readTotalUser;

    /**
     * 截至今日文章收藏用户次数
     */
    private Long collectTotalUser;

    /**
     * 截至今日文章标签用户次数
     */
    private Long tagTotalUser;

    /**
     * 截至今日文章做笔记用户次数
     */
    private Long noteTotalUser;

    /**
     * 截至今日点赞用户热度
     */
    private Long goodTotalUser;

    /**
     * 截至今日期刊订阅用户总量
     */
    private Long subscriptionTotalUser;
}
