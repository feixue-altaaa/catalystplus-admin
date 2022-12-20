package com.catalystplus.admin.response.journal;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@ApiModel("期刊信息模糊查询响应")
public class JournalSimpleResponse implements Serializable {

    private static final long serialVersionUID = -4593355789475347267L;

    /**
     * 期刊名字, en_name:英文名
     */
    @ApiModelProperty("期刊英文名字")
    private String enName;

    /**
     * 带横杠版的issn，对外宣称的
     */
    private String issnPrimaryFormattedL;

}
