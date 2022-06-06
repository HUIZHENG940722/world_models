package com.ethan.domain.mall.product.infrastructure.dao.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zhenghui
 * @Description 状态枚举
 * @Date 2022/6/7
 */
public enum StatusEnum {
    NUMBER_0(0),

    NUMBER_1(1);

    private Integer value;

    StatusEnum(Integer value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }
}
