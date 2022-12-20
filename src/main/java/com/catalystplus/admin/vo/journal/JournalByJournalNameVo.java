package com.catalystplus.admin.vo.journal;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("通过journal_name查询journal")
public class JournalByJournalNameVo implements Serializable {

    private static final long serialVersionUID = 3454045184149546935L;

    @ApiModelProperty("用户ID")
    private Long userId;

//    @ApiModelProperty("主题ID")
//    private Long subjectId;

    @ApiModelProperty("期刊名称")
    private String journalName;

    @ApiModelProperty("当前页码")
    private Integer pageNo = 1;

    @ApiModelProperty("每页数量")
    private Integer pageSize = 10;

}
