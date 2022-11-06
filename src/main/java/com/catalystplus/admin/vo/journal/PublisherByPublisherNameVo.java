package com.catalystplus.admin.vo.journal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("通过出版者名称获取其详细信息")
public class PublisherByPublisherNameVo implements Serializable {

    private static final long serialVersionUID = -2319758760876244101L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("出版者名称")
    private String publisherName;

}
