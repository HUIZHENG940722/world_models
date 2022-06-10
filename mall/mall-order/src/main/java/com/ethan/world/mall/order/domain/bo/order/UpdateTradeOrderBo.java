package com.ethan.world.mall.order.domain.bo.order;

import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderStatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 更新交易订单BO
 * @Date 2022/6/10
 */
@Data
public class UpdateTradeOrderBo {

    /**
     * 状态值
     */
    private TradeOrderStatusEnum orderStatus;

    /**
     * 交易关闭或完成的时间
     */
    private Date endTime;

    /**
     * 最终金额，单位：分，由支付金额和退款金额组成
     */
    private Integer presentPrice;

    /**
     * 实际已付金额，单位：分
     */
    private Integer payPrice;

    /**
     * 退款金额，单位：分
     */
    private Integer refundPrice;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 支付订单编号：对接支付业务的支付订单编号
     */
    private Integer payTransactionId;

    /**
     * 支付成功的支付渠道
     */
    private Integer payChannel;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 收货时间
     */
    private Date receiveTime;
}
