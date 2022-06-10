package com.ethan.world.mall.order.domain.service;

import com.ethan.world.mall.order.domain.bo.order.ContentTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.CreateTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.UpdateTradeOrderBo;
import com.ethan.world.mall.order.domain.repositiry.TradeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 交易订单领域服务
 * @Date 2022/6/9
 */
@Service
public class TradeOrderDomainService {

    @Autowired
    private TradeOrderRepository tradeOrderRepository;

    /**
     * 领域服务：创建交易订单
     *
     * @param createTradeOrderBo
     * @return
     */
    @Transactional
    public Integer createTradeOrder(CreateTradeOrderBo createTradeOrderBo) {
        // 1 核心校验
        // 2 核心业务
        // 2.1 创建交易订单信息
        return tradeOrderRepository.add(createTradeOrderBo);
        // 3 返回结果
    }


    /**
     * 领域服务：更新交易订单
     *
     * @param tradeOrderId
     * @param updateTradeOrderBo
     * @return
     */
    public Integer updateTradeOrder(Integer tradeOrderId, UpdateTradeOrderBo updateTradeOrderBo) {
        // 1 核心校验
        // 1.1 校验订单是否存在
        ContentTradeOrderBo contentTradeOrderBo = tradeOrderRepository.get(tradeOrderId);
        if (contentTradeOrderBo == null) {
            throw new RuntimeException("订单非法");
        }
        // 2 核心业务
        // 2.1 初始化结束时间
        if (updateTradeOrderBo.getOrderStatus().getValue() == 40 || updateTradeOrderBo.getOrderStatus().getValue() == 50) {
            updateTradeOrderBo.setEndTime(new Date(System.currentTimeMillis()));
        }
        return tradeOrderRepository.updateById(tradeOrderId, updateTradeOrderBo);
        // 3 返回结果
    }

    /**
     * 领域服务：获取交易订单内容
     *
     * @param tradeOrderId
     * @return
     */
    public ContentTradeOrderBo get(Integer tradeOrderId) {
        // 1 核心校验
        // 2 核心业务
        // 2.1 获取交易订单内容
        return tradeOrderRepository.get(tradeOrderId);
        // 3 返回结果
    }
}
