package com.ethan.world.mall.order.domain.repositiry;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ethan.world.mall.order.domain.bo.order.ContentTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.CreateTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.PageQueryTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.PageTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.UpdateTradeOrderBo;
import com.ethan.world.mall.order.domain.convert.TradeOrderPoConvert;
import com.ethan.world.mall.order.infrastructure.dao.TradeOrderMapper;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public Integer updateById(Integer tradeOrderId, UpdateTradeOrderBo updateTradeOrderBo) {
        TradeOrderPo tradeOrderPo = TradeOrderPoConvert.INSTANCE.updateBotoPo(updateTradeOrderBo);
        tradeOrderPo.setId(tradeOrderId);
        return tradeOrderMapper.updateById(tradeOrderPo);
    }

    public ContentTradeOrderBo get(Integer tradeOrderId) {
        return TradeOrderPoConvert.INSTANCE.toContentBo(tradeOrderMapper.selectById(tradeOrderId));
    }

    public PageTradeOrderBo page(PageQueryTradeOrderBo pageQueryTradeOrderBo) {
        LambdaQueryWrapper<TradeOrderPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        if (pageQueryTradeOrderBo.getUserId() != null) {
            lambdaQueryWrapper.eq(TradeOrderPo::getUserId, pageQueryTradeOrderBo.getUserId());
        }
        if (pageQueryTradeOrderBo.getOrderStatus() != null) {
            lambdaQueryWrapper.eq(TradeOrderPo::getOrderStatus, pageQueryTradeOrderBo.getOrderStatus());
        }
        Page<TradeOrderPo> objectPage = new Page<>(pageQueryTradeOrderBo.getPageNo(), pageQueryTradeOrderBo.getPageSize());
        objectPage.setOrders(pageQueryTradeOrderBo.getSorts());
        Page<TradeOrderPo> tradeOrderPoPage = tradeOrderMapper.selectPage(objectPage, lambdaQueryWrapper);
        PageTradeOrderBo pageTradeOrderBo = new PageTradeOrderBo();
        pageTradeOrderBo.setTotal((int) tradeOrderPoPage.getTotal());
        pageTradeOrderBo.setData(TradeOrderPoConvert.INSTANCE.toContentBo(tradeOrderPoPage.getRecords()));
        return pageTradeOrderBo;
    }

    public LambdaQueryWrapper<TradeOrderPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(TradeOrderPo.class);
    }
}
