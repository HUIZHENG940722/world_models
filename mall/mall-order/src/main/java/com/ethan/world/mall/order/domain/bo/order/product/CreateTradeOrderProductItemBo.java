package com.ethan.world.mall.order.domain.bo.order.product;

import lombok.Data;

/**
 * @Author zWX1058539
 * @Description 创建订单商品信息BO
 * @Date 2022/6/10
 */
@Data
public class CreateTradeOrderProductItemBo {

    /**
     * 订单编码
     */
    private Integer orderId;

    /**
     * 商品SPU编码
     */
    private Integer spuId;

    /**
     * 商品SKU编码
     */
    private Integer skuId;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 商品图片
     */
    private String skuImage;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 原始单价，单位：分
     */
    private Integer originPrice;

    /**
     * 购买单价，单位：分
     */
    private Integer buyPrice;

    /**
     * 最终单价，单位：分
     */
    private Integer presentPrice;

    /**
     * 购买总金额，单位：分
     */
    private Integer buyTotal;

    /**
     * 优惠总金额，单位：分
     */
    private Integer discountTotal;

    /**
     * 最终总金额，单位：分
     */
    private Integer presentTotal;

    /**
     * 物流编号
     */
    private Integer logisticsId;
}
