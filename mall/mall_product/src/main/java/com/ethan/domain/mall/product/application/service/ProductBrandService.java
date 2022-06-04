package com.ethan.domain.mall.product.application.service;

import com.ethan.domain.mall.product.domain.bo.brand.CreateProductBrandBo;
import com.ethan.domain.mall.product.domain.bo.brand.UpdateProductBrandBo;
import com.ethan.domain.mall.product.domain.service.ProductBrandDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zWX1058539
 * @Description 商品品牌应用服务
 * @Date 2022/5/30
 */
@Service
public class ProductBrandService {

    @Autowired
    private ProductBrandDomainService productBrandDomainService;

    /**
     * 应用服务：创建商品品牌
     *
     * @param createProductBrandBo
     * @return
     */
    public int createProductBrand(CreateProductBrandBo createProductBrandBo) {
        // 1 校验
        // 2 业务
        return productBrandDomainService.createProductBrand(createProductBrandBo);
        // 3 返回结果
    }

    /**
     * 应用服务：更新商品品牌
     *
     * @param brandId
     * @param updateProductBrandBo
     * @return
     */
    public int updateProductBrand(Integer brandId, UpdateProductBrandBo updateProductBrandBo) {
        // 1 校验
        // 2 业务
        // 3 返回结果
        return productBrandDomainService.updateProductBrand(brandId, updateProductBrandBo);
    }
}
