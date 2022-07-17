package com.xxxx.server.controller.other;

import com.xxxx.server.common.utils.R;
import com.xxxx.server.common.vo.UserLoginVo;
import com.xxxx.server.pojo.User;
import com.xxxx.server.service.IUserService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author : liuke
 * @date : 2022-07-14 17:38
 **/
@RestController
public class LoginController {

    @Autowired
    IUserService userService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public R login(@RequestBody UserLoginVo userLoginVo, HttpServletRequest request){
        return  userService.login(userLoginVo.getUsername(),userLoginVo.getPassword(),userLoginVo.getCode(),request);
    }

    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/user/info")
    public User getCurrentUserInfo(Principal principal){
        if (null == principal){
            return null;
        }
        String username = principal.getName();
        User user  =  userService.getCurrentUserInfoByUserName(username);
        user.setPassword(null);
        return  user;

    }



    @ApiOperation("退出登录")
    @GetMapping("/logout")
    public R logout(){
        return R.ok("注销成功");
    }




}
