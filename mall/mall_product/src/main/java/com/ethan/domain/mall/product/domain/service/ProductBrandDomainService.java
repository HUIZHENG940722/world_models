package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.mall.product.domain.repository.ProductBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zWX1058539
 * @Description 商品品牌领域服务
 * @Date 2022/5/30
 */
@Service
public class ProductBrandDomainService {

    @Autowired
    private ProductBrandRepository productBrandRepository;

    /**
     * 领域服务：创建商品品牌
     * @param productBrandBo
     * @return
     */
    public int createProductBrand(ProductBrandBo productBrandBo) {
        // 1 核心校验
        // 1.1 校验商品品牌名称是否重复
        ProductBrandBo productBrandBo1 = productBrandRepository.getByName(productBrandBo.getName());
        if (productBrandBo1 != null) {
            throw new RuntimeException("该商品品牌已添加");
        }
        // 2 核心业务
        return productBrandRepository.add(productBrandBo);
        // 3 返回结果
    }
}
