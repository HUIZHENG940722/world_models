package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.category.CreateProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.DetailsProductCategoryBo;
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
     * @param createProductCategoryBo
     * @return
     */
    @Transactional
    public int createProductCategory(CreateProductCategoryBo createProductCategoryBo) {
        // 1 核心校验
        // 1.1 校验父分类的合法性
        checkLegalityParent(createProductCategoryBo.getPid());
        // 1.2 校验分类名称是否重复
        DetailsProductCategoryBo detailsProductCategoryBo = productCategoryRepository.getByName(createProductCategoryBo.getName());
        if (detailsProductCategoryBo!=null) {
            throw new RuntimeException("商品分类名称重复");
        }
        // 2 核心业务
        return productCategoryRepository.add(createProductCategoryBo);
        // 3 返回结果
    }

    /**
     * 校验父分类编码的合法性
     * @param pid
     */
    private void checkLegalityParent(Integer pid) {
        if (!pid.equals(0)) {
            CreateProductCategoryBo createProductCategoryBo = productCategoryRepository.getByPid(pid);
            if (createProductCategoryBo ==null) {
                throw new RuntimeException("商品父分类编码非法");
            }
        }
    }
}
