package com.ethan.world.mall.order.infrastructure.dao.po.order;

import lombok.Data;

/**
 * @Author zWX1058539
 * @Description 商品项
 * @Date 2022/6/9
 */
@Data
public class ProductItem {

    /**
     * 商品SKU编码
     */
    private Integer skuId;

    /**
     * 数量
     */
    private Integer quantity;
}
