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

    @ApiModelProperty(value = "用户名")
    private String username;


    @ApiModelProperty(value = "密码")
    private String password;
}
