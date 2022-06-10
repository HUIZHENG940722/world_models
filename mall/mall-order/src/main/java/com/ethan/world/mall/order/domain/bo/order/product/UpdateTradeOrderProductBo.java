package com.ethan.world.mall.order.domain.bo.order.product;

import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderAfterSaleStatusEnum;
import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderStatusEnum;

/**
 * @Author zWX1058539
 * @Description 更新交易订单商品项BO
 * @Date 2022/6/10
 */
public class UpdateTradeOrderProductBo {

    /**
     * 订单项状态
     */
    private TradeOrderStatusEnum status;

    /**
     * 最终总金额，单位：分
     */
    private Integer presentTotal;

    /**
     * 退款总金额，单位：分
     */
    private Integer refundTotal;

    /**
     * 售后状态
     */
    private TradeOrderAfterSaleStatusEnum afterSaleStatus;

    /**
     * 售后订单编号
     */
    private Integer afterSaleOrderId;
}
