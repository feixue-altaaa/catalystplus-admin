package com.catalystplus.admin.vo.journal;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("通过领域名称查询领域详细信息")
public class AreaByAreaNameVo implements Serializable {

    private static final long serialVersionUID = -8573944127768173893L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("领域名称")
    private String areaName;

}
