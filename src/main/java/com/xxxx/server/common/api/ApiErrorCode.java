package com.xxxx.server.common.api;

/**
 * 错误代码枚举类
 *
 * @author : liuke
 * @date : 2022-05-22 12:50
 **/
public enum ApiErrorCode implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    FAILED(-1, "操作失败"),
    /**
     * 未登录，Token过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 权限不足
     */
    FORBIDDEN(403, "权限不足"),
    /**
     * 参数校验错误
     */
    VALIDATE_FAILED(404, "参数检验失败");

    private final Integer code;
    private final String message;

    ApiErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String toString() {
        return "ApiErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
