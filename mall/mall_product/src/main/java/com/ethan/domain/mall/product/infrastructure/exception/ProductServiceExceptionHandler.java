package com.ethan.domain.mall.product.infrastructure.exception;

import com.ethan.domain.mall.product.infrastructure.api.CommonResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhenghui
 * @Description 商品服务异常处理
 * @Date 2022/5/30
 */
@RestControllerAdvice
public class ProductServiceExceptionHandler {

    @ExceptionHandler(value = ProductServiceException.class)
    public CommonResult handleException(ProductServiceException e) {
        String message = e.getMessage();
        return CommonResult.validateFailed(message);
    }
}
