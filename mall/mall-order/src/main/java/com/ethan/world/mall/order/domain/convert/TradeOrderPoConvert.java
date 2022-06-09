package com.ethan.world.mall.order.domain.convert;

import com.ethan.world.mall.order.domain.bo.order.CreateTradeOrderBo;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Author zWX1058539
 * @Description 交易订单PO转换器
 * @Date 2022/6/9
 */
@Mapper
public interface TradeOrderPoConvert {
    TradeOrderPoConvert INSTANCE = Mappers.getMapper(TradeOrderPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "orderNo", expression = ""),
        @Mapping(target = "orderStatus", expression = ""),
        @Mapping(target = "endTime", ignore = true),
        @Mapping(target = "payPrice", expression = ""),
        @Mapping(target = "refundPrice", expression = ""),
        @Mapping(target = "payTime", expression = ""),
        @Mapping(target = "payTransactionId", expression = ""),
        @Mapping(target = "payChannel", expression = ""),
        @Mapping(target = "deliverType", expression = ""),
        @Mapping(target = "deliveryTime", expression = ""),
        @Mapping(target = "receiveTime", expression = ""),
        @Mapping(target = "afterSaleStatus", expression = ""),
        @Mapping(target = "deleted", expression = ""),
        @Mapping(target = "createTime", expression = ""),
        @Mapping(target = "updateTime", expression = "")
    })
    TradeOrderPo createBoToPo(CreateTradeOrderBo createTradeOrderBo);
}
