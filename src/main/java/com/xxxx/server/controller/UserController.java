package com.xxxx.server.controller;


import com.xxxx.server.common.dto.RegisterDTO;
import com.xxxx.server.common.utils.R;
import com.xxxx.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public R register(@RequestBody RegisterDTO registerDTO){

        return userService.register(registerDTO);
    }
}
