package com.xxxx.server.common.config.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxxx.server.common.utils.R;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当访问接口没有权限的时候 自定义返回结果
 *
 * @author : 刘可
 * @date : 2022-01-26 16:01
 **/
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {



    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        R r = R.error(403,"权限不足，请联系管理员！上帝");
        out.write(new ObjectMapper().writeValueAsString(r));
        out.flush();
        out.close();
    }
}
