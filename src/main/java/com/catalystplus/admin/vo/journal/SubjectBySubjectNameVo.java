package com.catalystplus.admin.vo.journal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("通过主体名称查找主题详细信息")
public class SubjectBySubjectNameVo implements Serializable {

    private static final long serialVersionUID = -2922216179553319453L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("主题名称")
    private String subjectName;

    @ApiModelProperty("领域ID")
    private Long areaId;

}
