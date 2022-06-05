package com.ethan.domain.mall.product.interfaces.dto.attr;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author zWX1058539
 * @Description 创建商品规格请求DTO
 * @Date 2022/6/2
 */
@Data
public class CreateProductAttrKeyReq {

    /**
     * 规格键名称
     */
    @NotEmpty(message = "规格键名称不能为空")
    private String name;
}
