package com.ethan.domain.mall.product.infrastructure.dao.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhenghui
 * @Description 是否删除枚举
 * @Date 2022/6/7
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum implements IEnum<Integer> {

    NUMBER_0(0, "已删除"),

    NUMBER_1(1, "未删除");

    @EnumValue
    private Integer value;

    @JsonValue
    private String message;
}
