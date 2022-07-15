package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.common.config.security.jwt.JwtTokenUtill;
import com.xxxx.server.common.utils.R;
import com.xxxx.server.pojo.User;
import com.xxxx.server.mapper.UserMapper;
import com.xxxx.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    JwtTokenUtill jwtTokenUtill;


    @Override
    public R login(String username, String password, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails && ! passwordEncoder.matches(password,userDetails.getPassword())){
            return R.error("用户名或密码不正确！");
        }

        if (!userDetails.isEnabled()){
            return R.error("该账户已经被禁用了，请联系管理员！");
        }

        //更新security登陆用户对象
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        //生成token
        String token = jwtTokenUtill.generateToken(userDetails);
        HashMap<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return R.ok().put("data",tokenMap);
    }

    @Override
    public User getCurrentUserInfoByUserName(String username) {
        return this.getOne(new QueryWrapper<User>().eq("username",username));
    }

}
