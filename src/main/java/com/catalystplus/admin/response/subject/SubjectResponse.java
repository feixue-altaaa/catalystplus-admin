package com.catalystplus.admin.response.subject;

import com.catalystplus.admin.response.journal.JournalResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/10/2 13:53
 * @Version 1.1
 */
@ToString
@Data
@ApiModel("主题通用响应")
public class SubjectResponse implements Serializable {

    private static final long serialVersionUID = 9024646867323301970L;

    @ApiModelProperty("主题ID")
    private Long id;

    /**
     * 主题英文名字en_name
     */
    @ApiModelProperty("主题英文名")
    private String enName;

    /**
     * 主题中文名字ch_name
     */
    @ApiModelProperty("主题中文名")
    private String chName;

    /**
     * 关联area领域表
     */
    @ApiModelProperty("关联领域ID")
    private Long areaId;

    /*
     * 领域名字
     */
    @ApiModelProperty("领域中文名")
    private String areaName;

    /**
     * 通过主题关键字搜索后，查询到的
     */
    @ApiModelProperty("一个主题关联的所有journal期刊")
    private List<JournalResponse> journals;


}
