package com.ethan.world.mall.order.domain.convert;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.ethan.world.mall.order.domain.bo.order.ContentTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.CreateTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.UpdateTradeOrderBo;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;


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
        @Mapping(target = "orderNo", expression = "java(cn.hutool.core.date.DateUtil.format(new java.util.Date(), \"yyyyMMddHHmmss\") + cn.hutool.core.util.RandomUtil.randomInt(100000, 999999))"),
        @Mapping(target = "orderStatus", expression = "java(com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderStatusEnum.WAITING_PAYMENT)"),
        @Mapping(target = "endTime", ignore = true),
        @Mapping(target = "payPrice", ignore = true),
        @Mapping(target = "refundPrice", ignore = true),
        @Mapping(target = "payTime", ignore = true),
        @Mapping(target = "payTransactionId", ignore = true),
        @Mapping(target = "payChannel", ignore = true),
        @Mapping(target = "deliverType", expression = "java(com.ethan.world.mall.order.infrastructure.dao.enums.LogisticsDeliveryTypeEnum.EXPRESS)"),
        @Mapping(target = "deliveryTime", ignore = true),
        @Mapping(target = "receiveTime", ignore = true),
        @Mapping(target = "afterSaleStatus", expression = "java(com.ethan.world.mall.order.infrastructure.dao.enums.TradeOrderAfterSaleStatusEnum.NULL)"),
        @Mapping(target = "deleted", expression = "java(1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", ignore = true)
    })
    TradeOrderPo createBoToPo(CreateTradeOrderBo createTradeOrderBo);

    ContentTradeOrderBo toContentBo(TradeOrderPo selectById);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "userId", ignore = true),
        @Mapping(target = "orderNo", ignore = true),
        @Mapping(target = "remark", ignore = true),
        @Mapping(target = "buyPrice", ignore = true),
        @Mapping(target = "discountPrice", ignore = true),
        @Mapping(target = "logisticsPrice", ignore = true),
        @Mapping(target = "deliverType", ignore = true),
        @Mapping(target = "receiverName", ignore = true),
        @Mapping(target = "receiverMobile", ignore = true),
        @Mapping(target = "receiverAreaCode", ignore = true),
        @Mapping(target = "receiverDetailAddress", ignore = true),
        @Mapping(target = "afterSaleStatus", ignore = true),
        @Mapping(target = "couponCardId", ignore = true),
        @Mapping(target = "deleted", ignore = true),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    TradeOrderPo updateBotoPo(UpdateTradeOrderBo updateTradeOrderBo);

    List<ContentTradeOrderBo> toContentBo(List<TradeOrderPo> tradeOrderPoList);
}
