package com.ethan.world.security.core.annotations;

import java.lang.annotation.*;

/**
 * @author zhenghui
 * @Description 认证声明注解
 * @Date 2022/6/19
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PreAuthenticated {
}
