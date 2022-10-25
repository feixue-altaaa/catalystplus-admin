package com.catalystplus.admin.response.journal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

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

    @ApiModelProperty("期刊ID")
    private Long id;

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
     * 期刊关联subject主题表
     */
    @ApiModelProperty("关联表主题subjectName名字")
    private String subjectName;


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
}
