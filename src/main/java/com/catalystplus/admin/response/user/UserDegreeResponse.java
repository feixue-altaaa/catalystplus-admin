package com.catalystplus.admin.response.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@ApiModel("用户学历信息响应")
public class UserDegreeResponse implements Serializable {

    private static final long serialVersionUID = -1418212132640693576L;
}
