package com.ethan.world.mall.order.domain.repositiry;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.world.mall.order.domain.bo.order.product.CreateTradeOrderProductItemBo;
import com.ethan.world.mall.order.domain.bo.order.product.UpdateTradeOrderProductBo;
import com.ethan.world.mall.order.domain.convert.TradeOrderPoConvert;
import com.ethan.world.mall.order.domain.convert.TradeOrderProductPoConvert;
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

    public Integer updateByOrderId(Integer orderId, UpdateTradeOrderProductBo updateTradeOrderProductBo) {
        TradeOrderProductItemPo tradeOrderProductItemPo = TradeOrderProductPoConvert.INSTANCE.updateToPo(updateTradeOrderProductBo);
        LambdaUpdateWrapper<TradeOrderProductItemPo> lambdaUpdateWrapper = getLambdaUpdateWrapper();
        lambdaUpdateWrapper.eq(TradeOrderProductItemPo::getOrderId, orderId);
        return tradeOrderProductMapper.update(tradeOrderProductItemPo, lambdaUpdateWrapper);
    }

    private LambdaQueryWrapper<TradeOrderProductItemPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(TradeOrderProductItemPo.class);
    }

    private LambdaUpdateWrapper<TradeOrderProductItemPo> getLambdaUpdateWrapper() {
        return Wrappers.lambdaUpdate(TradeOrderProductItemPo.class);
    }
}
