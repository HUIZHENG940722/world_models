package com.ethan.world.pay.app.infrastructure.dao.enums;

/**
 * @author zhenghui
 * @Description 支付通知状态枚举
 * @Date 2022/6/3
 */
public enum PayNotifyStatusEnum {

    WAITING(1, "等待通知"),
    SUCCESS(2, "通知成功"),
    FAILURE(3, "通知失败"), // 多次尝试，彻底失败
    REQUEST_SUCCESS(4, "请求成功，但是结果失败"),
    REQUEST_FAILURE(5, "请求失败"),
    ;

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 名字
     */
    private final String name;

    PayNotifyStatusEnum(Integer status, String name) {
        this.status = status;
        this.name = name;
    }
}
