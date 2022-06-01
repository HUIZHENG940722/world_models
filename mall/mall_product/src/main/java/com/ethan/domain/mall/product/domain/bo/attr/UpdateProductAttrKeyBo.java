package com.ethan.domain.mall.product.domain.bo.attr;

import lombok.Data;

/**
 * @author zhenghui
 * @Description 更新商品规格键
 * @Date 2022/6/1
 */
@Data
public class UpdateProductAttrKeyBo {

    /**
     * 规格键名称
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;
}
