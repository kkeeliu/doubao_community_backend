package com.xxxx.server.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录Vo
 *
 * @author : liuke
 * @date : 2022-07-14 17:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVo {

    @ApiModelProperty(value = "用户名",required = true)
    private String username;


    @ApiModelProperty(value = "密码",required = true)
    private String password;

    @ApiModelProperty(value = "验证码",required = true)
    private String code;

    /**
     * 记住我功能
     */
    @ApiModelProperty(value = "记住我",required = true)
    private Boolean rememberMe;


}
