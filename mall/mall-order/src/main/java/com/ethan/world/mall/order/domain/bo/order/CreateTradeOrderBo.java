package com.ethan.world.mall.order.domain.bo.order;

import lombok.Data;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 创建交易订单BO
 * @Date 2022/6/9
 */
@Data
public class CreateTradeOrderBo {

    /**
     * 用户编码
     */
    private Integer userId;

    /**
     * 收件地址编号
     */
    private Integer userAddressId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单商品项列表
     */
    private List<ProductSkuItemBo> orderItems;
}
