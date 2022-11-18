package com.catalystplus.admin.response.subject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@ApiModel("主题精简响应")
public class SubjectSimpleResponse implements Serializable {

    private static final long serialVersionUID = -3438372128724552800L;

    @ApiModelProperty("主题ID")
    private Long id;

    /**
     * 主题中文名字ch_name
     */
    @ApiModelProperty("主题中文名")
    private String chName;

}
