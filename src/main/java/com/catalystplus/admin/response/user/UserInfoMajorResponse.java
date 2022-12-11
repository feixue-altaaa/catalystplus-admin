package com.catalystplus.admin.response.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@ApiModel("根据专业查询的用户信息返回响应")
public class UserInfoMajorResponse implements Serializable {

    private static final long serialVersionUID = -1418228707640693576L;

    @ApiModelProperty("指标名称")
    private String id;

    @ApiModelProperty("今日新增数量")
    private Integer addNumber;

    @ApiModelProperty("截至今日总数量")
    private Integer totalNumber;

    @ApiModelProperty("最大用户总人数")
    private Integer maxTotalNumber;
}
