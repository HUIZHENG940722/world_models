package com.ethan.domain.mall.product.domain.bo.attr;

import lombok.Data;

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
    private String name;

    /**
     * 状态
     */
    private Integer status;
}
