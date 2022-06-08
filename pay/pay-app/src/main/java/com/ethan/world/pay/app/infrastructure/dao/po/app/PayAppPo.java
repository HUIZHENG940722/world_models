package com.ethan.world.pay.app.infrastructure.dao.po.app;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 支付应用Po
 * @Date 2022/6/2
 */
@Data
@TableName(value = "pay_app")
public class PayAppPo {
    /**
     * 应用编码
     */
    private String id;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 异步通知地址
     */
    private String payNotifyUrl;

    /**
     * 状态：0->禁用;1->启用;
     */
    private Integer status;

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
