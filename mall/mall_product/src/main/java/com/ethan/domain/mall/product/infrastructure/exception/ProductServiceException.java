package com.ethan.domain.mall.product.infrastructure.exception;

/**
 * @author zhenghui
 * @Description 商品服务异常
 * @Date 2022/5/30
 */
public class ProductServiceException extends RuntimeException {

    public ProductServiceException(String message) {
        super(message);
    }
}
