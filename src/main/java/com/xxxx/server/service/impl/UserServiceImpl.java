package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.common.config.security.jwt.JwtTokenUtill;
import com.xxxx.server.common.dto.RegisterDTO;
import com.xxxx.server.common.utils.R;
import com.xxxx.server.pojo.User;
import com.xxxx.server.mapper.UserMapper;
import com.xxxx.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

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
    public R login(String username, String password, String code,HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StringUtils.isEmpty(code) ||  !code.equalsIgnoreCase(captcha)){
            return R.error("验证码输入有误,请重新输入！");
        }

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

    /**
     * 注册功能
     * @param registerDTO
     * @return
     */
    @Override
    public R register(RegisterDTO registerDTO) {
        List<User> userList = this.baseMapper.selectList(new QueryWrapper<User>()
                .eq("username", registerDTO.getName()).or().eq("email", registerDTO.getEmail()));

        if (userList.size() > 0){
            return R.error("账号或邮箱已经存在");
        }

        User user = User.builder()
                .username(registerDTO.getName())
                .alias(registerDTO.getName())
                .password(passwordEncoder.encode(registerDTO.getPass()))
                .avatar("https://s3.ax1x.com/2020/12/01/DfHNo4.jpg")
                .email(registerDTO.getEmail())
                .score(0)
                .enabled(true)
                .createTime(LocalDateTime.now())
                .build();
        this.save(user);
        return R.ok();
    }

}
