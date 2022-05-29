package com.ethan.domain.mall.product.domain.repository;

import com.ethan.domain.mall.product.domain.bo.category.ProductCategoryBO;
import com.ethan.domain.mall.product.domain.convert.ProductCategoryPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghui
 * @Description 商品分类数据仓库
 * @Date 2022/5/29
 */
@Repository
public class ProductCategoryRepository {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public ProductCategoryBO getByPid(Integer pid) {
        return ProductCategoryPoConvert.INSTANCE.toBo(productCategoryMapper.selectById(pid));
    }

    public int add(ProductCategoryBO productCategoryBO) {
        return productCategoryMapper.insert(ProductCategoryPoConvert.INSTANCE.toPo(productCategoryBO));
    }
}
