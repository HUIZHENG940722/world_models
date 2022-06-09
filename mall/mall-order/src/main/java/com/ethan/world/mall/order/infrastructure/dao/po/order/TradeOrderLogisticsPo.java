package com.ethan.world.mall.order.infrastructure.dao.po.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.ethan.world.mall.order.infrastructure.dao.enums.LogisticsDeliveryTypeEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author zWX1058539
 * @Description 交易的订单物流信息
 * @Date 2022/6/9
 */
@Data
@TableName(value = "logistics_order")
public class TradeOrderLogisticsPo {

    /**
     * 物流订单编码
     */
    private Integer id;

    /**
     * 配送类型
     */
    private LogisticsDeliveryTypeEnum deliveryType;

    /**
     * 物流公司的编码
     */
    private Integer expressId;

    /**
     * 物流公司的单号
     */
    private String expressNo;

    /**
     * 交易订编码
     */
    private Integer tradeOrderId;


    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<ProductSkuItemPo> items;

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
