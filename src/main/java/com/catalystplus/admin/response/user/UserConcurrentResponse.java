package com.catalystplus.admin.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@ApiModel("用户在线信息响应")
public class UserConcurrentResponse implements Serializable {

    private static final long serialVersionUID = -1418215832640693576L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("数量")
    private Long num;

}
