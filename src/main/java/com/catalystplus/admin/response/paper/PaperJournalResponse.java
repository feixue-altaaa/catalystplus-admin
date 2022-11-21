package com.catalystplus.admin.response.paper;

import com.catalystplus.admin.entity.PaperJournalData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("按领域查询文章期刊总数响应")
public class PaperJournalResponse implements Serializable {

    private static final long serialVersionUID = 2248575726147415430L;

    @ApiModelProperty("总的文章期刊总数")
    private PaperJournalData totalPaperJournalData;

    @ApiModelProperty("按领域查询文章期刊总数")
    List<PaperJournalData> paperJournalDatas;
}
