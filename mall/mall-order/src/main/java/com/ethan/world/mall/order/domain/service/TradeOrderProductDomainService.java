package com.ethan.world.mall.order.domain.service;

import com.ethan.world.mall.order.domain.bo.order.product.CreateTradeOrderProductItemBo;
import com.ethan.world.mall.order.domain.repositiry.TradeOrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 交易订单商品信息领域服务
 * @Date 2022/6/10
 */
@Service
public class TradeOrderProductDomainService {

    @Autowired
    private TradeOrderProductRepository tradeOrderProductRepository;

    /**
     * 领域服务：创建订单商品信息列表
     *
     * @param orderId
     * @param createTradeOrderProductItemBoList
     * @return
     */
    public Integer createTradeOrderProduct(Integer orderId, List<CreateTradeOrderProductItemBo> createTradeOrderProductItemBoList) {
        // 1 核心校验
        // 2 核心业务
        createTradeOrderProductItemBoList.stream().forEach(item -> {
            item.setOrderId(orderId);
        });
        return tradeOrderProductRepository.addList(createTradeOrderProductItemBoList);
        // 3 返回结果
    }
}
