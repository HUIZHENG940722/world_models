package com.ethan.world.mall.order.domain.bo.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zWX1058539
 * @Description 创建交易订单BO
 * @Date 2022/6/9
 */
@Data
public class CreateTradeOrderBo implements Serializable {

    /**
     * 用户编码
     */
    private Integer userId;

    /**
     * 备注
     */
    private String remark;

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
     * 优惠卷编码
     */
    private Integer couponCardId;
}
