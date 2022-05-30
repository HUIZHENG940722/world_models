package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.category.CreateProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.ContentProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.UpdateProductCategoryBo;
import com.ethan.domain.mall.product.domain.repository.ProductCategoryRepository;
import com.ethan.domain.mall.product.infrastructure.api.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        ContentProductCategoryBo contentProductCategoryBo = productCategoryRepository.getByName(createProductCategoryBo.getName());
        if (contentProductCategoryBo !=null) {
            Asserts.fail("商品分类名称重复");
        }
        // 2 核心业务
        return productCategoryRepository.add(createProductCategoryBo);
        // 3 返回结果
    }

    /**
     * 领域服务：更新商品分类
     * @param updateProductCategoryBo
     * @return
     */
    @Transactional
    public int updateProductCategory(UpdateProductCategoryBo updateProductCategoryBo) {
        // 1 核心校验
        // 1.1 校验分类编码是否存在
        ContentProductCategoryBo contentProductCategoryBo = productCategoryRepository.getById(updateProductCategoryBo.getId());
        if (contentProductCategoryBo == null) {
            Asserts.fail("商品分类不存在");
        }
        // 1.2 校验父分类编码
        checkLegalityParent(updateProductCategoryBo.getPid());
        // 2 核心业务
        return productCategoryRepository.update(updateProductCategoryBo);
        // 3 返回结果
    }

    /**
     * 领域服务：删除商品分类
     * @param id
     * @return
     */
    @Transactional
    public int deleteProductCategory(Integer id) {
        // 1 核心校验
        // 1.1 校验商品分类是否存在
        ContentProductCategoryBo byId = productCategoryRepository.getById(id);
        if (byId == null) {
            Asserts.fail("商品分类不存在");
        }
        // 1.2 校验是否存在子分类
        List<ContentProductCategoryBo> contentProductCategoryBoList = productCategoryRepository.getChildListByPid(id);
        if (!contentProductCategoryBoList.isEmpty()) {
            Asserts.fail("存在子商品分类");
        }
        // 2 核心业务
        return productCategoryRepository.deleteById(id);
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
