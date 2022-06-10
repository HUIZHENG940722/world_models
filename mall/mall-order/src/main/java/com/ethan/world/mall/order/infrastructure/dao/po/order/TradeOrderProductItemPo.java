package com.ethan.world.mall.order.infrastructure.dao.po.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderAfterSaleStatusEnum;
import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderStatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 交易订单商品信息PO
 * @Date 2022/6/9
 */
@Data
@TableName(value = "trade_order_product")
public class TradeOrderProductItemPo {

    /**
     * 编码
     */
    @TableId
    private Integer id;

    /**
     * 订单编码
     */
    private Integer orderId;

    /**
     * 订单项状态
     */
    private TradeOrderStatusEnum status;

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
     * 退款总金额，单位：分
     */
    private Integer refundTotal;

    /**
     * 物流编号
     */
    private Integer logisticsId;

    /**
     * 售后状态
     */
    private TradeOrderAfterSaleStatusEnum afterSaleStatus;

    /**
     * 售后订单编号
     */
    private Integer afterSaleOrderId;

    /**
     * 是否删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date updateTime;

}
