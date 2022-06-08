package com.ethan.world.account.member.domain.bo;

import lombok.Data;

/**
 * @author zhenghui
 * @Description 更新会员用户BO
 * @Date 2022/6/4
 */
@Data
public class UpdateMemberUserBo {
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
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private Integer deleted;
}
