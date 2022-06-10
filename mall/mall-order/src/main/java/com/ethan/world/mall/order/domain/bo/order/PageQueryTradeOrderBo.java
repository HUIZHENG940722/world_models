package com.ethan.world.mall.order.domain.bo.order;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderStatusEnum;
import lombok.Data;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 分页查询交易订单BO
 * @Date 2022/6/10
 */
@Data
public class PageQueryTradeOrderBo {

    public static final OrderItem ID_ASC = new OrderItem("id", true);

    private Integer pageNo;

    private Integer pageSize;

    /**
     * 用户编码
     */
    private Integer userId;

    /**
     * 订单状态
     */
    private TradeOrderStatusEnum orderStatus;

    /**
     * 排序的字段数组
     */
    private List<OrderItem> sorts;
}
