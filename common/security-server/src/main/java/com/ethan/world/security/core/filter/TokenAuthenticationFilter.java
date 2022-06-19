package com.ethan.world.security.core.filter;

import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhenghui
 * @Description Token过滤器，验证token的有效性
 * @Date 2022/6/18
 */
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1 从请求中获取token
        String tokenStr = request.getHeader("Authorization");
        String token = null;
        if (StrUtil.isNotEmpty(tokenStr) && tokenStr.trim().startsWith("Bearer ")) {
            token = tokenStr.trim().substring(7);
        }
        // 2 获取当前用户类型
        Integer loginUserType;
        if (StrUtil.isNotEmpty(token)) {
            loginUserType = (Integer) request.getAttribute("login_user_type");
        }
        // 3 验证当前用户是否是有效用户
        // 4 放行
        filterChain.doFilter(request, response);
    }
}
