package com.catalystplus.admin.vo.summary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("期刊文章浏览汇总接口")
public class SummaryVo implements Serializable {

    private static final long serialVersionUID = -4437282533710920669L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("今日时间")
    private  String localDateTime;

}
