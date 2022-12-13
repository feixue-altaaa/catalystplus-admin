package com.catalystplus.admin.response.totalCount;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
@ApiModel("tocal_count通用响应")
public class TotalCountResponse implements Serializable {

    private static final long serialVersionUID = -2906993922799552745L;

    /**
     * id，自增
     */
//    @ApiModelProperty("自增ID")
//    private Long id;

            List<Map> totalCount = new ArrayList<>();

//    Map<String,Long> paperRead;
//
//    Map<String,Long> paperCollect;
//
//    Map<String,Long> paperTag;
//
//    Map<String,Long> paperNote;
//
//    Map<String,Long> paperGood;
//
//    Map<String,Long> journalSubscription;

    /**
     * 今日文章阅读次数
     */
//    @ApiModelProperty("今日文章阅读次数")
//    private Long todayRead;
//
//    /**
//     * 今日文章收藏次数
//     */
//    @ApiModelProperty("今日文章收藏次数")
//    private Long todayCollect;
//
//    /**
//     * 今日文章标签次数
//     */
//    @ApiModelProperty("今日文章标签次数")
//    private Long todayTag;
//
//    /**
//     * 今日文章做笔记次数
//     */
//    @ApiModelProperty("今日文章做笔记次数")
//    private Long todayNote;
//
//    /**
//     * 今日点赞热度
//     */
//    @ApiModelProperty("今日点赞热度")
//    private Long todayGood;
//
//    /**
//     * 今日期刊订阅总量
//     */
//    @ApiModelProperty("今日期刊订阅总量")
//    private Long todaySubscription;
//
//    /**
//     * 截至今日文章阅读次数
//     */
//    @ApiModelProperty("截至今日文章阅读次数")
//    private Long readTotal;
//
//    /**
//     * 截至今日文章收藏次数
//     */
//    @ApiModelProperty("截至今日文章收藏次数")
//    private Long collectTotal;
//
//    /**
//     * 截至今日文章标签次数
//     */
//    @ApiModelProperty("截至今日文章标签次数")
//    private Long tagTotal;
//
//    /**
//     * 截至今日文章做笔记次数
//     */
//    @ApiModelProperty("截至今日文章做笔记次数")
//    private Long noteTotal;
//
//    /**
//     * 截至今日点赞热度
//     */
//    @ApiModelProperty("截至今日点赞热度")
//    private Long goodTotal;
//
//    /**
//     * 截至今日期刊订阅总量
//     */
//    @ApiModelProperty("截至今日期刊订阅总量")
//    private Long subscriptionTotal;
//
//
//
//    @ApiModelProperty("期刊订阅当日人均次数")
//    private Long todayPerCapitaSubscription;
//
//    @ApiModelProperty("期刊订阅截至当日人均次数")
//    private Long totalPerCapitaSubscription;
//
//    @ApiModelProperty("文章阅读今日人均次数")
//    private Long todayPerCapitaRead;
//
//    @ApiModelProperty("文章阅读截至今日人均次数")
//    private Long totalPerCapitaRead;
//
//    @ApiModelProperty("文章收藏今日人均次数")
//    private Long todayPerCapitaCollect;
//
//    @ApiModelProperty("文章收藏截至今日人均次数")
//    private Long totalPerCapitaCollect;
//
//    @ApiModelProperty("文章打标签今日人均次数")
//    private Long todayPerCapitaTag;
//
//    @ApiModelProperty("文章打标签截至今日人均次数")
//    private Long totalPerCapitaTag;
//
//    @ApiModelProperty("文章做笔记今日人均次数")
//    private Long todayPerCapitaNote;
//
//    @ApiModelProperty("文章做笔记截至今日人均次数")
//    private Long totalPerCapitaNote;
//
//    @ApiModelProperty("文章热度今日人均次数")
//    private Long todayPerCapitaGood;
//
//    @ApiModelProperty("文章热度截至今日人均次数")
//    private Long totalPerCapitaGood;

}
