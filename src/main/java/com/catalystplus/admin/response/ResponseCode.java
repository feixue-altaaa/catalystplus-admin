package com.catalystplus.admin.response;

/**
 * @author 蓝染
 * 响应码、提示信息
 */
public enum ResponseCode {


    SUCCESS(200, "success"),
    ERROR(-1, "服务器内部错误"),
    FAIL(300, "fail"),
    INNER_ERROR(500, "内部错误"),
    NOT_FOUND(501, "无法找到"),

    CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式"),
    NO_PERMISSION(1005, "无权限访问！"),
    UNAUTHORIZED(401, "无权限"),
    INVALID_TOKEN(1004, "无效的token"),


    //-1xx 服务器错误
    BAD_SQL_GRAMMAR_ERROR(-101, "sql语法错误"),
    SERVLET_ERROR(-102, "servlet请求异常"), //-2xx 参数校验
    UPLOAD_ERROR(-103, "文件上传错误"),
    EXPORT_DATA_ERROR(104, "数据导出失败"),


    //-2xx 参数校验
    MOBILE_NULL_ERROR(-202, "手机号码不能为空"),
    MOBILE_ERROR(-203, "手机号码不正确"),
    PASSWORD_NULL_ERROR(-204, "密码不能为空"),
    CODE_NULL_ERROR(-205, "验证码不能为空"),
    CODE_ERROR(-206, "验证码错误"),
    MOBILE_EXIST_ERROR(-207, "手机号已被注册"),
    LOGIN_MOBILE_ERROR(-208, "用户不存在"),
    LOGIN_PASSWORD_ERROR(-209, "密码错误"),
    LOGIN_LOKED_ERROR(-210, "用户被锁定"),
    LOGIN_AUTH_ERROR(-211, "未登录"),
    LOGIN_USERID_ERROR(-212, "用户userId不能为空"),
    LOGIN_KEY_AUTHOR_ERROR(-213, "关键字与作者不能同时为空"),
    LOGIN_SUB_ERROR(-214, "是否订阅不能为空, false 或者 true"),
    LOGIN_PAPERID_ERROR(-215, "paperId不能为空"),
    FAVOURITE_NOSELECT_ERROR(-216, "noSelect字段不能为空"),
    FAVOURITE_TAGIDS_ERROR(-217, "tagIds集合不能为空"),
    FAVOURITE_ALLMATCH_ERROR(-218, "是否全匹配allmatch不能为空"),
    SUBJECT_AREAID_ERROR(-219, "areaId不能为空"),
    JOURNAL_SUBJECTID_ERROR(-220, "subjectId不能为空"),
    JOURNALNAME_ERROR(-221, "journalName不能为空"),
    KEYWORD_AUTHOR_ERROR(-222, "keyword和author不能同时为空"),
    KEYWORD_ERROR(-223, "keyword不能为空"),
    AUTHOR_ERROR(-224, "author不能为空"),
    TAGNAME_ERROR(-225, "tagName不能为空"),
    TAGEXIST_ERROR(-226, "标签已经存在"),
    TAGID_ERROR(-227, "tagId不能为空"),
    JOURNAL_SUBSCRIBE_ERROR(-228, "journalId不能为空"),
    KEYWORDIDS_AUTHORIDS_ERROR(-229, "keywordIds与authorIds不能同时为空"),
    SUBJECT_SUBSCRIBE_ERROR(-230, "subjectId不能为空"),
    SUBSCRIPTIONID_ERROR(-231, "subscription不能为空"),
    OTPTYPE_NULL_ERROR(-232, "手机号码不能为空"),
    MOBILE_NOT_EXIST_ERROR(-233, "手机号没有注册"),
    SUBJECTNAME_ERROR(-234, "subjectName不能为空"),
    KEYWORDNAME_ERROR(-235, "keywordName不能为空"),
    KEYWORDID_ERROR(-236, "keywordId不能为空"),
    TITLENAME_ERROR(-237, "titleName不能为空"),
    ABSTRACTNAME_ERROR(-238, "abstractName不能为空"),

    USER_BIND_IDCARD_EXIST_ERROR(-301, "身份证号码已绑定"),
    USER_NO_BIND_ERROR(302, "用户未绑定"),
    USER_NO_AMOUNT_ERROR(303, "用户信息未审核"),

    ALIYUN_RESPONSE_ERROR(-501, "阿里云短信服务响应失败"),
    ALIYUN_SMS_LIMIT_CONTROL_ERROR(-502, "短信发送过于频繁"),//业务限流
    ALIYUN_SMS_ERROR(-503, "短信发送失败"),//其他失败

    WEIXIN_CALLBACK_PARAM_ERROR(-601, "回调参数不正确"),
    WEIXIN_FETCH_ACCESSTOKEN_ERROR(-602, "获取access_token失败"),
    WEIXIN_FETCH_USERINFO_ERROR(-603, "获取用户信息失败"),
    ;


    private final int code;

    private final String msg;

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
