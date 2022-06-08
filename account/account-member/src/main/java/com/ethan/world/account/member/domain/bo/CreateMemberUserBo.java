package com.ethan.world.account.member.domain.bo;

import lombok.Data;

/**
 * @author zhenghui
 * @Description 创建会员用户BO
 * @Date 2022/6/4
 */
@Data
public class CreateMemberUserBo {

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册 IP
     */
    private String registerIp;
}
