package com.ethan.world.mall.order.infrastructure.dao.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Author zWX1058539
 * @Description 物流配送类型
 * @Date 2022/6/9
 */
@Getter
public enum LogisticsDeliveryTypeEnum {

    /**
     * 无需快递
     */
    NULL(0),

    /**
     * 传统快递
     */
    EXPRESS(1);

    @EnumValue
    private final Integer deliveryType;

    LogisticsDeliveryTypeEnum(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }
}
