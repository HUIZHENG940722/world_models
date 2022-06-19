package com.ethan.world.security.core.handler;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhenghui
 * @Description 认证失败处理类
 * @Date 2022/6/18
 */
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(
        HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException, ServletException {
        String s = JSONUtil.toJsonStr(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
        ServletUtil.write(response, s, MediaType.APPLICATION_JSON_VALUE);
    }
}
