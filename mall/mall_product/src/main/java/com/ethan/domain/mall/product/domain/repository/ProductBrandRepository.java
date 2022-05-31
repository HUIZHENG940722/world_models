package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.mall.product.domain.bo.brand.ContentProductBrandBo;
import com.ethan.domain.mall.product.domain.bo.brand.CreateProductBrandBo;
import com.ethan.domain.mall.product.domain.bo.brand.UpdateProductBrandBo;
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

    public ContentProductBrandBo getByName(String name) {
        LambdaQueryWrapper<ProductBrandPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductBrandPo::getName, name);
        return ProductBrandPoConvert.INSTANCE.toContentBo((productBrandMapper.selectOne(lambdaQueryWrapper)));
    }

    public int add(CreateProductBrandBo createProductBrandBo) {
        return productBrandMapper.insert(ProductBrandPoConvert.INSTANCE.createBotoPo(createProductBrandBo));
    }

    public ContentProductBrandBo getById(Integer brandId) {
        return ProductBrandPoConvert.INSTANCE.toContentBo(productBrandMapper.selectById(brandId));
    }

    public int updateById(Integer brandId, UpdateProductBrandBo updateProductBrandBo) {
        ProductBrandPo productBrandPo = ProductBrandPoConvert.INSTANCE.updateBotoPo(updateProductBrandBo);
        productBrandPo.setId(brandId);
        return productBrandMapper.updateById(productBrandPo);
    }

    public int deleteById(Integer brandId) {
        return productBrandMapper.deleteById(brandId);
    }

    private LambdaQueryWrapper<ProductBrandPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductBrandPo.class);
    }


}
