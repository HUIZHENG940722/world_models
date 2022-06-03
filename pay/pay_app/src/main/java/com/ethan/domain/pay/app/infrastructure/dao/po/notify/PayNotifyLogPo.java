package com.ethan.domain.pay.app.infrastructure.dao.po.notify;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 支付通知App的日志PO
 * @Date 2022/6/2
 */
@Data
@TableName(value = "pay_notify_log")
public class PayNotifyLogPo {

    /**
     * 日志编号，自增
     */
    private Integer id;

    /**
     * 通知编号
     */
    private Integer notifyId;

    /**
     * 请求参数
     */
    private String request;

    /**
     * 响应结果
     */
    private String response;

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
