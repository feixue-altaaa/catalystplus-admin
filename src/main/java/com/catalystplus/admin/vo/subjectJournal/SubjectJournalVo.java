package com.catalystplus.admin.vo.subjectJournal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("批量修改主题")
public class SubjectJournalVo implements Serializable {

    private static final long serialVersionUID = 4934463495861441770L;

    @ApiModelProperty("期刊ID")
    Long journalId;

    @ApiModelProperty("源主题ID数组")
    List<Long> sourceSubjectIds;

    @ApiModelProperty("目标主题ID数组")
    List<Long> targetSubjectIds;
}
