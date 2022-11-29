package com.catalystplus.admin.vo.rank;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("文章期刊统计排行接口")
public class RankVo implements Serializable {

    private static final long serialVersionUID = -346045007432949610L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("日期类别")
    private String date;

    @ApiModelProperty("排名类别")
    private String categoryOfRanking;

}
