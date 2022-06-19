package com.ethan.world.security.core;

import lombok.Data;

import java.util.List;

/**
 * @author zhenghui
 * @Description 认证用户
 * @Date 2022/6/19
 */
@Data
public class AuthenticationUser {
    private Integer id;

    private Integer userType;

    private Integer tenantId;

    private List<String> scopes;
}
