package com.catalystplus.admin.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@ApiModel("用户信息通用响应")
public class UserInfoResponse implements Serializable {

    private static final long serialVersionUID = -1418558707640693576L;

    @ApiModelProperty("指标名称")
    private String id;

    @ApiModelProperty("今日新增数量")
    private Long addNumber;

    @ApiModelProperty("截至今日总数量")
    private Long totalNumber;

}
