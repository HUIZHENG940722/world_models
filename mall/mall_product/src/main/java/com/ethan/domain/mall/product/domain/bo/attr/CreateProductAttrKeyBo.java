package com.ethan.domain.mall.product.domain.bo.attr;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author zWX1058539
 * @Description 创建商品规格键BO
 * @Date 2022/6/1
 */
@Data
public class CreateProductAttrKeyBo {

    /**
     * 规格键名称
     */
    @NotEmpty(message = "规格键名称不能为空")
    private String name;

    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private Integer status;
}
