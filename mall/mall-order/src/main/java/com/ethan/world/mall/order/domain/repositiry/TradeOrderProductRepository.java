package com.ethan.world.mall.order.domain.repositiry;

import com.ethan.world.mall.order.domain.bo.order.product.CreateTradeOrderProductItemBo;
import com.ethan.world.mall.order.domain.convert.TradeOrderPoConvert;
import com.ethan.world.mall.order.infrastructure.dao.TradeOrderProductMapper;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderPo;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderProductItemPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 交易订单商品信息数据仓库
 * @Date 2022/6/10
 */
@Repository
public class TradeOrderProductRepository {

    @Autowired
    private TradeOrderProductMapper tradeOrderProductMapper;

    public Integer addList(List<CreateTradeOrderProductItemBo> createTradeOrderProductItemBoList) {
        List<TradeOrderProductItemPo> tradeOrderProductItemPoList = TradeOrderPoConvert.INSTANCE.createBoToPo(createTradeOrderProductItemBoList);
        for (TradeOrderProductItemPo tradeOrderProductItemPo : tradeOrderProductItemPoList) {
            tradeOrderProductMapper.insert(tradeOrderProductItemPo);
        }
        return createTradeOrderProductItemBoList.size();
    }
}
