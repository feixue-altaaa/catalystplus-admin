package com.catalystplus.admin.vo.journal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 蓝染
 * @Date 2022/9/30 15:54
 * @Version 1.1
 */
@Data
@ApiModel("通过subjectId查询journal期刊接口")
public class JournalBySubjectIdVo implements Serializable {


    private static final long serialVersionUID = -8916644991954099553L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("主题ID")
    private Long subjectId;

    @ApiModelProperty("当前页码")
    private Integer pageNo = 1;

    @ApiModelProperty("每页数量")
    private Integer pageSize = 10;

}
