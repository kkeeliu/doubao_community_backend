package com.xxxx.server.common.config.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxxx.server.common.utils.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 未登录或者token失效时去访问接口，得到的自定义返回结果
 *
 * @author : 刘可
 * @date : 2022-01-26 15:33
 **/
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        R r = R.error(401,"尚未登录，请重新登录！");
        out.write(new ObjectMapper().writeValueAsString(r));
        out.flush();
        out.close();
    }
}
