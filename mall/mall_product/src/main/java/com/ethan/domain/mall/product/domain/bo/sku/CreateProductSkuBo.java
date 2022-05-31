package com.ethan.domain.mall.product.domain.bo.sku;

import lombok.Data;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 创建商品SKU BO
 * @Date 2022/5/30
 */
@Data
public class CreateProductSkuBo {

    /**
     * 商品编号
     */
    private Integer spuId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 规格值数组
     */
    private List<Integer> attrValueIds;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 库存数量
     */
    private Integer quantity;
}
