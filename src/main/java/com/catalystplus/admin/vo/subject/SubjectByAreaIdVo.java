package com.catalystplus.admin.vo.subject;

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
@ApiModel("通过areaId查询主题接口")
public class SubjectByAreaIdVo implements Serializable {


    private static final long serialVersionUID = -2476099675993487324L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("领域ID")
    private Long areaId;

    @ApiModelProperty("当前页码")
    private Integer pageNo = 1;

    @ApiModelProperty("每页数量")
    private Integer pageSize = 20;

}
