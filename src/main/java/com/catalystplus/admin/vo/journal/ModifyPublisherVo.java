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
@ApiModel("修改journal的publisherId")
public class ModifyPublisherVo implements Serializable {


    private static final long serialVersionUID = -1728047756660780244L;

    @ApiModelProperty("journalId期刊ID")
    private Long journalId;

    @ApiModelProperty("新修改的publisherId")
    private Long publisherId;

}
