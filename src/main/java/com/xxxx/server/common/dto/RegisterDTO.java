package com.xxxx.server.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 注册DTO
 *
 * @author : liuke
 * @date : 2022-07-22 16:41
 **/
@Data
public class RegisterDTO {

    @NotEmpty(message = "请输入账号")
    @Length(min = 2, max = 15, message = "长度在2-15")
    @ApiModelProperty(value = "账号",required = true)
    private String name;

    @NotEmpty(message = "请输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    @ApiModelProperty(value = "密码",required = true)
    private String pass;

    @NotEmpty(message = "请再次输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    @ApiModelProperty(value = "二次密码",required = true)
    private String checkPass;

    @NotEmpty(message = "请输入电子邮箱")
    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "电子邮箱",required = true)
    private String email;
}
