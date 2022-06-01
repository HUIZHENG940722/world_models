package com.ethan.domain.mall.product.domain.bo.attr.value;

import lombok.Data;

/**
 * @author zhenghui
 * @Description 创建商品规格值BO
 * @Date 2022/6/1
 */
@Data
public class CreateProductAttrValueBo {

    /**
     * 规格键编码
     */
    private Integer attrKeyId;

    /**
     * 规格值名字
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;
}
