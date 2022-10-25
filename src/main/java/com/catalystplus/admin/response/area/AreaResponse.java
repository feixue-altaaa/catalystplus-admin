package com.catalystplus.admin.response.area;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author 蓝染
 * @Date 2022/10/2 13:15
 * @Version 1.1
 */
@Data
@ToString
@ApiModel("领域响应")
public class AreaResponse implements Serializable {

    private static final long serialVersionUID = 3628571300888149497L;


    /**
     * 领域id
     */
    @ApiModelProperty("领域ID")
    private Long id;

    /**
     * 领域名字, en_name:英文名
     */
    @ApiModelProperty("领域英文名")
    private String enName;

    /**
     * 领域名字, cn_name:中文名
     */
    @ApiModelProperty("领域中文名")
    private String chName;

}
