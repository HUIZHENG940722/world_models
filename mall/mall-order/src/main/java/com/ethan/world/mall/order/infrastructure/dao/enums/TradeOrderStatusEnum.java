package com.ethan.world.mall.order.infrastructure.dao.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author zWX1058539
 * @Description 交易订单状态枚举
 * @Date 2022/6/9
 */
@AllArgsConstructor
@Getter
public enum TradeOrderStatusEnum {
    WAITING_PAYMENT(10, "等待付款"),
    WAIT_SHIPMENT(20, "等待发货"),
    ALREADY_SHIPMENT(30, "已发货"),
    COMPLETED(40, "已完成"),
    CLOSED(50, "已关闭");

    /**
     * 状态值
     */
    @EnumValue
    private final Integer value;

    /**
     * 状态名
     */
    private final String name;
}
