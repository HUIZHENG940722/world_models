package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.sku.CreateProductSkuBo;
import com.ethan.domain.mall.product.domain.bo.spu.DetailsProductSpuBo;
import com.ethan.domain.mall.product.domain.repository.ProductSkuRepository;
import com.ethan.domain.mall.product.infrastructure.exception.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品SKU领域服务
 * @Date 2022/5/30
 */
@Service
public class ProductSkuDomainService {

    @Autowired
    private ProductSkuRepository productSkuRepository;

    @Autowired
    private ProductSpuDomainService productSpuDomainService;

    /**
     * 领域服务：创建商品sku列表
     * @param spuId
     * @param createProductSkuBoList
     * @return
     */
    @Transactional
    public int createProductSkus(Integer spuId, List<CreateProductSkuBo> createProductSkuBoList) {
        // 1 核心校验
        // 1.1 校验商品spu是否存在
        DetailsProductSpuBo productSpu = productSpuDomainService.getProductSpu(spuId);
        if (productSpu == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品SPU不存在");
        }
        // 2 核心业务
        // 2.1 初始化商品spuId
        for (CreateProductSkuBo createProductSkuBo : createProductSkuBoList) {
            createProductSkuBo.setSpuId(spuId);
        }
        // 2.2 插入商品sku列表
        return productSkuRepository.addList(createProductSkuBoList);
        // 3 返回结果
    }
}
