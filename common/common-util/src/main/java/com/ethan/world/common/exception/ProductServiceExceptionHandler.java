package com.ethan.world.common.exception;

import com.ethan.world.common.api.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public CommonResult<Void> handleException(ProductServiceException e) {
        String message = e.getMessage();
        return CommonResult.validateFailed(message);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
