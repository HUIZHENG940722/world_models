package com.ethan.domain.mall.product.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;

/**
 * @author zhenghui
 * @Description 异常处理跳转器
 * @Date 2022/6/7
 */
@RestControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> exception(MethodArgumentNotValidException e) {
        String message = null;
        if (e.getBindingResult().hasErrors()) {
            FieldError fieldError = e.getBindingResult().getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity<Object> exception(ProductException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
    }

    @ExceptionHandler(value = SocketTimeoutException.class)
    public ResponseEntity<Object> exception(SocketTimeoutException e) {
        return new ResponseEntity<>("服务器异常", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
