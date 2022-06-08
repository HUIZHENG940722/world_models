package com.ethan.world.account.admin.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author zhenghui
 * @Description 用户PO
 * @Date 2022/6/3
 */
@Data
@TableName(value = "admin_user")
public class AdminUserPo {

    /**
     * 用户编码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户性别
     */
    private Integer sex;

    /**
     * 注册 IP
     */
    private String registerIp;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private Date loginDate;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;
}
