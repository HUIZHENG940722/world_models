package com.ethan.world.mall.order.domain.convert;

import com.ethan.world.mall.order.domain.bo.order.product.CreateTradeOrderProductItemBo;
import com.ethan.world.mall.order.domain.bo.order.product.UpdateTradeOrderProductBo;
import com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderAfterSaleStatusEnum;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderProductItemPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Author zWX1058539
 * @Description 交易订单商品PO转换器
 * @Date 2022/6/10
 */
@Mapper
public interface TradeOrderProductPoConvert {

    TradeOrderProductPoConvert INSTANCE = Mappers.getMapper(TradeOrderProductPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "status", expression = "java(com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderStatusEnum.WAITING_PAYMENT)"),
        @Mapping(target = "refundTotal", ignore = true),
        @Mapping(target = "afterSaleStatus", expression = "java(com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderAfterSaleStatusEnum.NULL)"),
        @Mapping(target = "afterSaleOrderId", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", ignore = true),
    })
    TradeOrderProductItemPo createBoToPo(CreateTradeOrderProductItemBo createTradeOrderProductItemBo);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "orderId", ignore = true),
        @Mapping(target = "spuId", ignore = true),
        @Mapping(target = "skuId", ignore = true),
        @Mapping(target = "skuName", ignore = true),
        @Mapping(target = "skuImage", ignore = true),
        @Mapping(target = "quantity", ignore = true),
        @Mapping(target = "originPrice", ignore = true),
        @Mapping(target = "buyPrice", ignore = true),
        @Mapping(target = "presentPrice", ignore = true),
        @Mapping(target = "buyTotal", ignore = true),
        @Mapping(target = "discountTotal", ignore = true),
        @Mapping(target = "logisticsId", ignore = true),
        @Mapping(target = "deleted", ignore = true),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
    })
    TradeOrderProductItemPo updateToPo(UpdateTradeOrderProductBo updateTradeOrderProductBo);
}
