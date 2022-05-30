package com.ethan.domain.mall.product.infrastructure.api;

import com.ethan.domain.mall.product.infrastructure.exception.ProductServiceException;

/**
 * @author zhenghui
 * @Description 断言处理类
 * @Date 2022/5/30
 */
public class Asserts {
    public static void fail(String message) {
        throw new ProductServiceException(message);
    }
}
