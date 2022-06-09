package com.ethan.world.mall.order.infrastructure.dao.po.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ethan.world.mall.order.infrastructure.dao.enums.LogisticsDeliveryTypeEnum;
import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderAfterSaleStatusEnum;
import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 交易订单PO
 * @Date 2022/6/9
 */
@Data
@TableName(value = "trade_order")
public class TradeOrderPo implements Serializable {

    /**
     * 订单编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编码
     */
    private Integer userId;

    /**
     * 订单编号（业务）
     */
    private Integer orderNo;

    /**
     * 状态值
     */
    private TradeOrderStatusEnum orderStatus;

    /**
     * 备注
     */
    private Integer remark;

    /**
     * 校验关闭或完成的时间
     */
    private Date endTime;

    /**
     * 购买商品的总金额，单位：分
     */
    private Integer buyPrice;

    /**
     * 优惠总金额，单位：分
     */
    private Integer discountPrice;

    /**
     * 物流金额，单位：分
     */
    private Integer logisticsPrice;

    /**
     * 最终金额，单位：分，由支付金额和退款金额组成
     */
    private Integer presentPrice;

    /**
     * 实际已付金额，单位：分
     */
    private Integer payPrice;

    /**
     * 退款金额，单位：分
     */
    private Integer refundPrice;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 支付订单编号：对接支付业务的支付订单编号
     */
    private Integer payTransactionId;

    /**
     * 支付成功的支付渠道
     */
    private Integer payChannel;

    /**
     * 配送类型
     */
    private LogisticsDeliveryTypeEnum deliverType;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 收货时间
     */
    private Date receiveTime;

    /**
     * 收件人名称
     */
    private String receiverName;

    /**
     * 收件人手机
     */
    private String receiverMobile;

    /**
     * 收件人地区编码
     */
    private Integer receiverAreaCode;

    /**
     * 收件人详情地址
     */
    private String receiverDetailAddress;

    /**
     * 售后状态
     */
    private TradeOrderAfterSaleStatusEnum afterSaleStatus;

    /**
     * 优化卷编码
     */
    private Integer couponCardId;

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
