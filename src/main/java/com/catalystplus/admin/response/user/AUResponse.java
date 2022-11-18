package com.catalystplus.admin.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@ApiModel("用户活跃信息响应")
public class AUResponse implements Serializable {

    private static final long serialVersionUID = -1418217707640693576L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("数量")
    private Long num;

    @ApiModelProperty("占比")
    private Double percent;
}
