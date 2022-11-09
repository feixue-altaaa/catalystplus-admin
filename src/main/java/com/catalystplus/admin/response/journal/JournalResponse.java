package com.catalystplus.admin.response.journal;

import com.catalystplus.admin.entity.Subject;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/10/2 14:27
 * @Version 1.1
 */
@ToString
@Data
@ApiModel("期刊信息通用响应")
public class JournalResponse implements Serializable {

    private static final long serialVersionUID = -1418217707640656576L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("表序列，除了查找文献以外，其他都用这个这个id")
    private Long id;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("真实唯一journalId，查找文献用这个id")
    private Long journalId;

    /**
     * 期刊名字, en_name:英文名
     */
    @ApiModelProperty("期刊英文名字")
    private String enName;

    /**
     * 期刊名字, cn_name:中文名
     */
    @ApiModelProperty("期刊中文文字")
    private String chName;


    /**
     * 期刊关联subject主题表
     */
    @ApiModelProperty("关联表主题subjectId")
    private Long subjectId;


    /**
     * 关联publisher出版商表
     */
    @ApiModelProperty("期刊出版商ID")
    private Long publisherId;


    /**
     * 关联publisher出版商表
     */
    @ApiModelProperty("期刊出版商")
    private String publisher;

    /**
     * ISSN编号, 标准国际刊号
     */
    @ApiModelProperty("带横杆版期刊ISSN")
    private String issn;

    /**
     * Area Quartile in Category分区，1为一区，2为二区，3为三区，4为四区，以Area分区为标准
     */
    @ApiModelProperty("期刊分区")
    private Integer quartile;

    /**
     * 是否为顶刊，0不是顶刊，1是顶刊
     */
    @ApiModelProperty("是否为顶刊")
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
     * 出版商的详细信息页链接
     */
    @ApiModelProperty("期刊官方网址")
    private String informationPageUrl;

    /**
     * 领域名字, cn_name:中文名
     */
    @ApiModelProperty("领域中文名称")
    private String areaChName;

    /**
     * 主题中文名字ch_name
     */
    @ApiModelProperty("关联表主题subjectChName名字")
    private List<String> subjectChNames;

}
