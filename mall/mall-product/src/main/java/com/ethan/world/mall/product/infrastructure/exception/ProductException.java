package com.ethan.world.mall.product.infrastructure.exception;

import com.ethan.world.mall.product.infrastructure.exception.enums.ProductExceptionEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * @author zhenghui
 * @Description 商品模块异常类
 * @Date 2022/6/7
 */
public class ProductException extends HttpStatusCodeException {

    public ProductException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }

    public ProductException(ProductExceptionEnum e) {
        super(e.getHttpStatus(), e.getMessage());
    }
}
