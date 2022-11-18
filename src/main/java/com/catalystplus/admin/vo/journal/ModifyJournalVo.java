package com.catalystplus.admin.vo.journal;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("修改期刊详细信息")
public class ModifyJournalVo implements Serializable {

    private static final long serialVersionUID = 4178437529347271507L;

    @ApiModelProperty("期刊ID")
    private long journalId;

//    @ApiModelProperty("源领域ID")
//    private long sourceAreaId;
//    @ApiModelProperty("目标领域ID")
//    private long targetAreaId;

    @ApiModelProperty("源review")
    private Integer sourceReview;
    @ApiModelProperty("目标review")
    private Integer targetReview;


    @ApiModelProperty("源期刊分区")
    private Integer sourceQuartile;
    @ApiModelProperty("目标期刊分区")
    private Integer targetQuartile;

    @ApiModelProperty("源顶刊信息")
    private Integer sourceTop;
    @ApiModelProperty("目标顶刊信息")
    private Integer targetTop;


}
