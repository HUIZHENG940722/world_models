package com.ethan.world.common.api;

import com.ethan.world.common.exception.ProductServiceException;

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
