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
@ApiModel("修改subject_journal的subjectId")
public class ModifySubjectVo implements Serializable {


    private static final long serialVersionUID = 300769555329849494L;

    @ApiModelProperty("期刊ID")
    private Long journalId;

    @ApiModelProperty("源主题ID")
    private Long sourceSubjectId;

    @ApiModelProperty("目标主题ID")
    private Long targetSubjectId;

}
