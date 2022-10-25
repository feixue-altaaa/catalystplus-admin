package com.catalystplus.admin.response.publisher;

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
@ApiModel("出版商响应")
public class PublisherResponse implements Serializable {


    private static final long serialVersionUID = 3928551336532717021L;
    /**
     * 出版商id
     */
    @ApiModelProperty("出版商ID")
    private Long id;

    /**
     * 出版商名字
     */
    @ApiModelProperty("出版商英文名")
    private String name;

    /**
     * 出版商网页
     */
    @ApiModelProperty("出版商网址")
    private String websiteUrl;

}
