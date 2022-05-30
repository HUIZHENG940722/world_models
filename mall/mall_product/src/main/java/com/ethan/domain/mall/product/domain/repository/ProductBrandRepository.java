package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.mall.product.domain.convert.ProductBrandPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductBrandMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.brand.ProductBrandPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author zWX1058539
 * @Description 商品品牌仓库类
 * @Date 2022/5/30
 */
@Repository
public class ProductBrandRepository {

    @Autowired
    private ProductBrandMapper productBrandMapper;

    public ProductBrandBo getByName(String name) {
        LambdaQueryWrapper<ProductBrandPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductBrandPo::getName, name);
        return ProductBrandPoConvert.INSTANCE.toBo(productBrandMapper.selectOne(lambdaQueryWrapper));
    }

    public int add(ProductBrandBo productBrandBo) {
        return productBrandMapper.insert(ProductBrandPoConvert.INSTANCE.toPo(productBrandBo));
    }

    private LambdaQueryWrapper<ProductBrandPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductBrandPo.class);
    }
}
