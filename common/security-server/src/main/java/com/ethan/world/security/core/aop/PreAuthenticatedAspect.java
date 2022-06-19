package com.ethan.world.security.core.aop;

import com.ethan.world.security.core.annotations.PreAuthenticated;
import com.ethan.world.security.core.util.AuthenticationUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;

/**
 * @author zhenghui
 * @Description 认证注解切面配置
 * @Date 2022/6/19
 */
@Aspect
public class PreAuthenticatedAspect {

    @Around("@annotation(preAuthenticated)")
    public Object around(ProceedingJoinPoint joinPoint, PreAuthenticated preAuthenticated) throws Throwable {
        if (AuthenticationUtils.getAuthenticationUser() == null) {
            throw new  RuntimeException(String.valueOf(HttpStatus.UNAUTHORIZED));
        }
        return joinPoint.proceed();
    }
}
