package com.ethan.world.mall.product.application.service;

import com.ethan.world.mall.product.domain.service.ProductCategoryDomainService;
import com.ethan.world.mall.product.domain.bo.category.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhenghui
 * @Description 商品分类应用服务
 * @Date 2022/5/29
 */
@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryDomainService productCategoryDomainService;

    /**
     * 应用服务：创建商品分类
     *
     * @param createProductCategoryBo
     * @return
     */
    public int createProductCategory(CreateProductCategoryBo createProductCategoryBo) {
        // 1 校验
        // 2 业务
        // 3 返回结果
        return productCategoryDomainService.createProductCategory(createProductCategoryBo);
    }

    /**
     * 应用服务：更新商品分类
     *
     * @param categoryId
     * @param updateProductCategoryBo
     * @return
     */
    public int updateProductCategory(Integer categoryId, UpdateProductCategoryBo updateProductCategoryBo) {
        // 1 校验
        // 2 业务
        // 3 返回结果
        return productCategoryDomainService.updateProductCategory(categoryId, updateProductCategoryBo);
    }

    /**
     * 应用服务：获取商品分类内容
     *
     * @param categoryId
     * @return
     */
    public ContentProductCategoryBo getProductCategoryContent(Integer categoryId) {
        // 1 校验
        // 2 业务
        // 3 返回结果
        return productCategoryDomainService.get(categoryId);
    }

    /**
     * 应用服务：分页获取商品分类内容
     *
     * @param pageQueryProductCategoryBo
     * @return
     */
    public PageProductCategoryBo pageProductCategoryContent(PageQueryProductCategoryBo pageQueryProductCategoryBo) {
        // 1 校验
        // 2 业务
        return productCategoryDomainService.page(pageQueryProductCategoryBo);
        // 3 返回结果
    }
}
