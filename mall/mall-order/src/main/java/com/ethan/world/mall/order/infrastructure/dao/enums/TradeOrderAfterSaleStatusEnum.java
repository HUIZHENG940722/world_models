package com.ethan.world.mall.order.infrastructure.dao.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Author zWX1058539
 * @Description 交易订单的售后状态的枚举
 * @Date 2022/6/9
 */
@Getter
public enum TradeOrderAfterSaleStatusEnum {

    NULL(0, "无"),
    IN_PROCESS(10, "售后中"),
    END(10, "售后结束");

    /**
     * 状态
     */
    @EnumValue
    private final Integer status;

    /**
     * 描述
     */
    private final String desc;

    TradeOrderAfterSaleStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
