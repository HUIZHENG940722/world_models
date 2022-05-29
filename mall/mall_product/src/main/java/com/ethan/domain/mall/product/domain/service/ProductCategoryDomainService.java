package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.category.ProductCategoryBO;
import com.ethan.domain.mall.product.domain.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhenghui
 * @Description 商品分类领域服务
 * @Date 2022/5/29
 */
@Service
public class ProductCategoryDomainService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    /**
     * 领域服务：创建商品分类
     * @param productCategoryBO
     * @return
     */
    @Transactional
    public int createProductCategory(ProductCategoryBO productCategoryBO) {
        // 1 核心校验
        // 1.1 校验父分类的合法性
        checkLegalityParent(productCategoryBO.getPid());
        // 2 核心业务
        return productCategoryRepository.add(productCategoryBO);
        // 3 返回结果
    }

    /**
     * 校验父分类编码的合法性
     * @param pid
     */
    private void checkLegalityParent(Integer pid) {
        if (!pid.equals(0)) {
            ProductCategoryBO productCategoryBO = productCategoryRepository.getByPid(pid);
            if (productCategoryBO==null) {
                throw new RuntimeException("商品父分类编码非法");
            }
        }
    }
}
