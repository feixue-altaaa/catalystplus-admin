package com.catalystplus.admin.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

import static com.catalystplus.admin.config.GlobalAspect.*;


/**
 * @Author 蓝染
 * @Date 2022/9/21 19:25
 * @Version 1.1
 */
@Data
@ToString
@ApiModel("标准响应格式")
@Slf4j
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -1222614520893986846L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("全局请求ID")
    private String globalId = GLOBAL_ID.get();

    @ApiModelProperty("返回数据")
    private T data;
    /**
     * 错误码
     */
    @ApiModelProperty("返回代码，200表示成功，401表示没有权限，300表示失败（大部分失败响应使用的这个编号）")
    private int code;
    /**
     * 错误信息
     */
    @ApiModelProperty("返回详细信息，显示失败详细信息")
    private String msg;

    @ApiModelProperty("当前页码")
    private Integer pageNo = PAGE_NO.get();

    @ApiModelProperty("每页数量")
    private Integer pageSize = PAGE_SIZE.get();

    @ApiModelProperty("查询总数")
    private Long pageTotal = PAGE_TOTAL.get();

    public Response() {
    }

    public Response(Long userId, T data, int code, String msg) {
        this.userId = userId;
        this.data = data;
        this.code = code;
        this.msg = msg;
    }


    public static <T> Response<T> success(Long userId, T data) {
        return new Response<T>(userId, data, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }

    public static <T> Response<T> success(Long userId, T data, Response response) {
        return new Response<T>(userId, data, response.getCode(), response.getMsg());
    }

    public static <T> Response<T> error(Long userId) {
        return new Response<T>(userId, null, ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMsg());
    }

    public static <T> Response<T> error(Long userId, String msg) {
        return new Response<T>(userId, null, ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> Response<T> error(Long userId, int code, String msg) {
        return new Response<T>(userId, null, code, msg);
    }

    public static <T> Response<T> fail(Long userId) {
        return new Response<T>(userId, null, ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg());
    }

    public static <T> Response<T> fail(Long userId, ResponseCode responseCode) {
        return new Response<T>(userId, null, responseCode.getCode(), responseCode.getMsg());
    }

    public static <T> Response<T> fail(Long userId, String msg) {
        return new Response<T>(userId, null, ResponseCode.FAIL.getCode(), msg);
    }

    public static <T> Response<T> fail(Long userId, Integer code, String msg) {
        return new Response<T>(userId, null, code, msg);
    }

    public static <T> Response<T> fail(Long userId, T data) {
        return new Response<T>(userId, data, ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg());
    }


    public static <T> Response<T> fail(Response response) {
        return new Response<T>(response.getUserId(), null, response.getCode(), response.getMsg());
    }

    public static <T> Response<T> notFound(Long userId) {
        return new Response<T>(userId, null, ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getMsg());
    }

    /**
     * 系统异常，为了不影响客户，返回数据未查的
     *
     * @param <T>
     * @return
     */
    public static <T> Response<T> internalError(Long userId) {
        return new Response<T>(userId, null, ResponseCode.INNER_ERROR.getCode(), ResponseCode.INNER_ERROR.getMsg());
    }

    public static <T> Response<T> internalError(Long userId, String msg) {
        //setResponseStatus(500);
        return new Response<T>(userId, null, ResponseCode.INNER_ERROR.getCode(), msg);
    }

    public static <T> Response<T> needLoginError(Long userId, String msg) {
        setResponseStatus(500);
        return new Response<T>(userId, null, ResponseCode.UNAUTHORIZED.getCode(), msg);
    }

    private static void setResponseStatus(int i) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            //log.warn("failed to set response, because can't get HttpServletResponse");
            return;
        }
        final HttpServletResponse response = servletRequestAttributes.getResponse();
        if (response == null) {
            //log.warn("failed to set response, because can't get HttpServletResponse");
            return;
        }
        response.setStatus(i);
    }


}
