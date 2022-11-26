package com.catalystplus.admin.vo.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("通过日期查询用户数据")
public class UserByDateVo implements Serializable {

    private static final long serialVersionUID = -234238929472968170L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("日期（比如：2022-11-26）")
    private String localDateTime;

}
