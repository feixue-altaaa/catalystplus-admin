package com.catalystplus.admin.vo.subject;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("分页查询subject")
public class SubjectPageVo implements Serializable {
    private static final long serialVersionUID = -234237629472968170L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("领域ID")
    private Long areaId;

    @ApiModelProperty("当前页码")
    private Integer pageNo = 1;

    @ApiModelProperty("每页数量")
    private Integer pageSize = 20;
}
