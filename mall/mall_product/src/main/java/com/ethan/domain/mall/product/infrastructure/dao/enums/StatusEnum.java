package com.ethan.domain.mall.product.infrastructure.dao.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhenghui
 * @Description 状态枚举
 * @Date 2022/6/7
 */
@Getter
@AllArgsConstructor
public enum StatusEnum implements IEnum<Integer> {

    NUMBER_0(0, "关闭"),

    NUMBER_1(1, "开启");

    @EnumValue
    private Integer value;

    @JsonValue
    private String message;
}
