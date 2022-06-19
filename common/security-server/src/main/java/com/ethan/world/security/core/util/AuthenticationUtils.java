package com.ethan.world.security.core.util;

import com.ethan.world.security.core.AuthenticationUser;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author zhenghui
 * @Description 认证工具类
 * @Date 2022/6/19
 */
public class AuthenticationUtils {

    public static AuthenticationUser getAuthenticationUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return null;
        }
        return context.getAuthentication().getPrincipal() instanceof AuthenticationUser
            ? (AuthenticationUser) context.getAuthentication() : null;
    }
}
