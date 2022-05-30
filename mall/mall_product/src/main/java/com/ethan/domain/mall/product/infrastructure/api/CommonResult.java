package com.ethan.domain.mall.product.infrastructure.api;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhenghui
 * @Description 通过返回
 * @Date 2022/5/29
 */
@Data
public final class CommonResult<T> implements Serializable {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回错误提示
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 构造方法
     * @param code
     * @param message
     * @param data
     */
    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回数据
     * @param code
     * @param message
     * @param data
     * @return
     * @param <T>
     */
    public static <T> CommonResult success(Integer code, String message, T data) {
        return new CommonResult(code, message, data);
    }

    /**
     * 校验失败返回数据
     * @param message
     * @return
     */
    public static CommonResult validateFailed(String message) {
        return new CommonResult(400, message, null);
    }
}