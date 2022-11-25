package com.catalystplus.admin.vo.paperCount;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("文章期刊总数接口")
public class PaperCountVo implements Serializable {

    private static final long serialVersionUID = 2664657437318866346L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("领域ID")
    private Long areaId;

}
