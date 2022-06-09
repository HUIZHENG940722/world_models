package com.ethan.world.mall.order.domain.repositiry;

import com.ethan.world.mall.order.domain.bo.order.CreateTradeOrderBo;
import com.ethan.world.mall.order.domain.convert.TradeOrderPoConvert;
import com.ethan.world.mall.order.infrastructure.dao.TradeOrderMapper;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author zWX1058539
 * @Description 交易订单数据仓库
 * @Date 2022/6/9
 */
@Repository
public class TradeOrderRepository {

    @Autowired
    private TradeOrderMapper tradeOrderMapper;

    public Integer add(CreateTradeOrderBo createTradeOrderBo) {
        TradeOrderPo tradeOrderPo = TradeOrderPoConvert.INSTANCE.createBoToPo(createTradeOrderBo);
        return tradeOrderMapper.insert(tradeOrderPo);
    }
}
