package com.ethan.domain.pay.app.infrastructure.dao.po.notify;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 支付通知APP任务PO
 * @Date 2022/6/2
 */
@Data
@TableName(value = "pay_notify_task")
public class PayNotifyTaskPo {

    /**
     * 通知频率，单位为秒。
     *
     * 算上首次的通知，实际是一共 1 + 8 = 9 次。
     */
    public static final Integer[] NOTIFY_FREQUENCY = new Integer[]{
            15, 15, 30, 180,
            1800, 1800, 1800, 3600
    };

    /**
     * 编号，自增
     */
    private Integer id;

    /**
     * 应用编号
     */
    private String appId;

    /**
     * 类型
     *
     * 外键 {@link com.ethan.domain.pay.app.infrastructure.dao.enums.PayNotifyTypeEnum}
     */
    private Integer type;

    /**
     * 通知状态
     *
     * 外键 {@link com.ethan.domain.pay.app.infrastructure.dao.enums.PayNotifyStatusEnum}
     */
    private Integer status;

    /**
     * 是否激活中，即处于正在 MQ 异步通知中
     */
    private Boolean active;

    /**
     * 下一次通知时间
     */
    private Date nextNotifyTime;

    /**
     * 最后一次执行时间
     */
    private Date lastExecuteTime;

    /**
     * 当前通知次数
     */
    private Integer notifyTimes;

    /**
     * 最大可通知次数
     */
    private Integer maxNotifyTimes;

    /**
     * 通知地址
     */
    private String notifyUrl;

    /**
     * 支付数据
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Transaction transaction;

    /**
     * 退款数据
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Refund refund;

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

    @Data
    public static class Transaction {

        /**
         * 应用订单编号
         */
        private String orderId;
        /**
         * 交易编号
         *
         * {@link PayTransactionDO#getId()}
         */
        private Integer transactionId;
        /**
         * 交易拓展编号
         *
         * {@link PayTransactionExtensionDO#getId()}
         */
        private Integer transactionExtensionId;

    }

    @Data
    public static class Refund {

        /**
         * 应用订单编号
         */
        private String orderId;
        /**
         * 交易编号
         *
         * {@link PayTransactionDO#getId()}
         */
        private Integer transactionId;
        /**
         * 退款单编号
         */
        private Integer refundId;

    }
}
