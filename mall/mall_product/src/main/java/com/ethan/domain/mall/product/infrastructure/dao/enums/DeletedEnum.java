package com.ethan.domain.mall.product.infrastructure.dao.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zhenghui
 * @Description 是否删除枚举
 * @Date 2022/6/7
 */
public enum DeletedEnum {

    @EnumValue
    NUMBER_0(0),

    @EnumValue
    NUMBER_1(1);

    private Integer value;

    DeletedEnum(Integer value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }
}
