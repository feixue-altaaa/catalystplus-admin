package com.catalystplus.admin.exception;



import com.catalystplus.admin.response.ResponseCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    //错误码
    private Integer code;
    //错误消息
    private String message;

    /**
     *
     * @param message 错误消息
     */
    public BusinessException(String message) {
        this.message = message;
    }

    /**
     *
     * @param message 错误消息
     * @param code 错误码
     */
    public BusinessException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    /**
     *
     * @param message 错误消息
     * @param code 错误码
     * @param cause 原始异常对象
     */
    public BusinessException(String message, Integer code, Throwable cause) {
        super(cause);
        this.message = message;
        this.code = code;
    }

    /**
     *
     * @param responseCode 接收枚举类型
     */
    public BusinessException(ResponseCode responseCode) {
        this.message = responseCode.getMsg();
        this.code = responseCode.getCode();
    }

    /**
     *
     * @param responseCode 接收枚举类型
     * @param cause 原始异常对象
     */
    public BusinessException(ResponseCode responseCode, Throwable cause) {
        super(cause);
        this.message = responseCode.getMsg();
        this.code = responseCode.getCode();
    }
}
