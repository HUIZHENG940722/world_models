package com.ethan.world.mall.order.domain.service;

import com.ethan.world.mall.order.domain.bo.order.CreateTradeOrderBo;
import com.ethan.world.mall.order.domain.repositiry.TradeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
