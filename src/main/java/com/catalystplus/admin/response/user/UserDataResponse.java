package com.catalystplus.admin.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@ApiModel("用户通用响应")
public class UserDataResponse implements Serializable {

    private static final long serialVersionUID = 9024647345623301970L;

    /**
     * 用户总数量
     */
    @ApiModelProperty("用户总数量")
    private Long tnu;

    /**
     * 今日新增用户数
     */
    @ApiModelProperty("今日新增用户数")
    private Long nnut;

    /**
     * 日活跃用户数
     */
    @ApiModelProperty("日活跃用户数")
    private Long dau;

    /**
     * 日活占比
     */
    @ApiModelProperty("日活占比")
    private Long pdau;

    /**
     * 周活跃用户数
     */
    @ApiModelProperty("周活跃用户数")
    private Long wau;

    /**
     * 周活占比
     */
    @ApiModelProperty("周活占比")
    private Long pwau;

    /**
     * 月活跃用户数
     */
    @ApiModelProperty("月活跃用户数")
    private Long mau;

    /**
     * 月活占比
     */
    @ApiModelProperty("月活占比")
    private Long pmau;

}
