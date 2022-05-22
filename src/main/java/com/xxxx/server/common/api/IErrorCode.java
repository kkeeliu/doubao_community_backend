package com.xxxx.server.common.api;

/**
 * 错误代码
 *
 * @author : liuke
 * @date : 2022-05-22 12:49
 **/
public interface IErrorCode {
    /**
     * 错误编码: -1失败;200成功
     *
     * @return 错误编码
     */
    Integer getCode();

    /**
     * 错误描述
     *
     * @return 错误描述
     */
    String getMessage();
}
