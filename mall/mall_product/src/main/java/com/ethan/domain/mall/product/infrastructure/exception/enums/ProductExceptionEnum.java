package com.ethan.domain.mall.product.infrastructure.exception.enums;


import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author zhenghui
 * @Description 商品模块异常枚举
 * @Date 2022/6/7
 */
@Getter
public enum ProductExceptionEnum {
    SUCCESS(HttpStatus.OK, "操作成功"),
    ;

    HttpStatus httpStatus;
    String message;
    ProductExceptionEnum(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
