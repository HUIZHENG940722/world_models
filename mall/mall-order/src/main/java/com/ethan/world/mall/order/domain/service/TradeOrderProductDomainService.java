package com.ethan.world.mall.order.domain.service;

import com.ethan.world.mall.order.domain.bo.order.ContentTradeOrderBo;
import com.ethan.world.mall.order.domain.bo.order.product.ContentTradeOrderProductItemBo;
import com.ethan.world.mall.order.domain.bo.order.product.CreateTradeOrderProductItemBo;
import com.ethan.world.mall.order.domain.bo.order.product.UpdateTradeOrderProductBo;
import com.ethan.world.mall.order.domain.repositiry.TradeOrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private TradeOrderDomainService tradeOrderDomainService;

    /**
     * 领域服务：创建订单商品信息列表
     *
     * @param orderId
     * @param createTradeOrderProductItemBoList
     * @return
     */
    @Transactional
    public Integer createTradeOrderProduct(Integer orderId, List<CreateTradeOrderProductItemBo> createTradeOrderProductItemBoList) {
        // 1 核心校验
        // 1.1 校验交易订单是否存在
        ContentTradeOrderBo contentTradeOrderBo = tradeOrderDomainService.get(orderId);
        if (contentTradeOrderBo == null) {
            throw new RuntimeException("交易订单不存在");
        }
        // 2 核心业务
        createTradeOrderProductItemBoList.stream().forEach(item -> {
            item.setOrderId(orderId);
        });
        return tradeOrderProductRepository.addList(createTradeOrderProductItemBoList);
        // 3 返回结果
    }

    /**
     * 领域服务：更新订单商品信息
     *
     * @param orderId
     * @return
     */
    @Transactional
    public Integer updateTradeOrderProduct(Integer orderId, UpdateTradeOrderProductBo updateTradeOrderProductBo) {
        // 1 核心校验
        // 1.1 校验交易订单是否存在
        ContentTradeOrderBo contentTradeOrderBo = tradeOrderDomainService.get(orderId);
        if (contentTradeOrderBo == null) {
            throw new RuntimeException("交易订单不存在");
        }
        // 2 核心业务
        // 3 返回结果
        return tradeOrderProductRepository.updateByOrderId(orderId, updateTradeOrderProductBo);
    }

    /**
     * 领域服务：获取订单商品项列表
     *
     * @param orderId
     * @return
     */
    public List<ContentTradeOrderProductItemBo> getTradeOrderProduct(Integer orderId) {
        // 1 核心校验
        // 1.1 校验交易订单是否存在
        ContentTradeOrderBo contentTradeOrderBo = tradeOrderDomainService.get(orderId);
        if (contentTradeOrderBo == null) {
            throw new RuntimeException("交易订单不存在");
        }
        // 2 核心业务
        return tradeOrderProductRepository.getTradeOrderProduct(orderId);
        // 3 返回结果
    }
}
