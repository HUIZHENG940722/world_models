package com.ethan.domain.pay.app.infrastructure.dao.enums;

/**
 * @author zhenghui
 * @Description 支付通知类型枚举
 * @Date 2022/6/3
 */
public enum PayNotifyTypeEnum {
    TRANSACTION(1, "支付"),
    REFUND(2, "退款"),
    ;

    /**
     * 类型
     */
    private final Integer type;

    /**
     * 名字
     */
    private final String name;

    PayNotifyTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
