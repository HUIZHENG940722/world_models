package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.ProductSpuBo;
import com.ethan.domain.mall.product.domain.repository.ProductSpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhenghui
 * @name ProductSpuDomainService
 * @Description 商品SPU领域服务
 * @Date 2022/5/28
 */
@Service
public class ProductSpuDomainService {

    @Autowired
    private ProductSpuRepository productSpuRepository;

    /**
     * 领域服务：创建商品SPU
     * @param productSpuBo
     * @return
     */
    @Transactional
    public int createProductSpu(ProductSpuBo productSpuBo) {
        // 1 核心校验
        // 1.1 校验商品SPU编号是否存在
        // 1.2 校验商品SPU名称是否存在
        // 2 核心业务
        return productSpuRepository.add(productSpuBo);
        // 3 返回结果
    }

    /**
     * 领域服务：更新商品SPU
     * @param productSpuBo
     * @return
     */
    public int updateProductSpu(ProductSpuBo productSpuBo) {
        // 1 核心校验
        // 1.1 校验商品SPU是否存在
        ProductSpuBo productSpuBo1 = productSpuRepository.getById(productSpuBo.getId());
        if (productSpuBo1 == null) {
            throw new RuntimeException("商品SPU非法");
        }
        // 2 核心业务
        return productSpuRepository.update(productSpuBo);
        // 3 返回结果
    }

    /**
     * 领域服务：获取商品SPU
     * @param productSpuId
     * @return
     */
    public ProductSpuBo getProductSpu(Integer productSpuId) {
        // 1 核心校验
        // 2 核心业务
        return productSpuRepository.getById(productSpuId);
        // 3 返回结果
    }
}
