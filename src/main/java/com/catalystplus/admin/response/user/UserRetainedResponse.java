package com.catalystplus.admin.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@ApiModel("用户留存信息响应")
public class UserRetainedResponse implements Serializable {

    private static final long serialVersionUID = -141821585450693576L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("留存数")
    private Long num;

    @ApiModelProperty("留存率")
    private Double rate;
}
