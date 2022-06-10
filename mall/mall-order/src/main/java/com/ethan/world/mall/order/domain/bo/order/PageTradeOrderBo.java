package com.ethan.world.mall.order.domain.bo.order;

import lombok.Data;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 分页交易订单BO
 * @Date 2022/6/10
 */
@Data
public class PageTradeOrderBo {
    private Integer total;

    private List<ContentTradeOrderBo> data;
}
