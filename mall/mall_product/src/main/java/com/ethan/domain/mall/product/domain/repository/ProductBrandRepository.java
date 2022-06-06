package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ethan.domain.mall.product.domain.bo.brand.*;
import com.ethan.domain.mall.product.domain.convert.ProductBrandPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductBrandMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.brand.ProductBrandPo;
import com.ethan.domain.mall.product.interfaces.assembler.ProductBrandDtoConvert;
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
        ProductBrandPo botoPo = ProductBrandPoConvert.INSTANCE.createBotoPo(createProductBrandBo);
        productBrandMapper.insert(botoPo);
        return botoPo.getId();
    }

    public ContentProductBrandBo getById(Integer brandId) {
        return ProductBrandPoConvert.INSTANCE.toContentBo(productBrandMapper.selectById(brandId));
    }

    public int updateById(Integer brandId, UpdateProductBrandBo updateProductBrandBo) {
        ProductBrandPo productBrandPo = ProductBrandPoConvert.INSTANCE.updateBotoPo(updateProductBrandBo);
        productBrandPo.setId(brandId);
        return productBrandMapper.updateById(productBrandPo);
    }

    public PageProductBrandBo page(PageQueryProductBrandBo pageQueryProductBrandBo) {
        LambdaQueryWrapper<ProductBrandPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        if (pageQueryProductBrandBo.getId() != null) {
            lambdaQueryWrapper.eq(ProductBrandPo::getId, pageQueryProductBrandBo.getId());
        }
        if (pageQueryProductBrandBo.getName() != null) {
            lambdaQueryWrapper.like(ProductBrandPo::getName, pageQueryProductBrandBo.getName());
        }
        if (pageQueryProductBrandBo.getStatus()!=null) {
            lambdaQueryWrapper.eq(ProductBrandPo::getStatus, pageQueryProductBrandBo.getStatus());
        }
        Page<ProductBrandPo> productBrandPoPage = productBrandMapper.selectPage(
            new Page<>(pageQueryProductBrandBo.getPageNo(), pageQueryProductBrandBo.getPageSize()), lambdaQueryWrapper);
        PageProductBrandBo pageProductBrandBo = new PageProductBrandBo();
        pageProductBrandBo.setTotal((int) productBrandPoPage.getTotal());
        pageProductBrandBo.setData(ProductBrandPoConvert.INSTANCE.toContentBo(productBrandPoPage.getRecords()));
        return pageProductBrandBo;
    }

    public int deleteById(Integer brandId) {
        return productBrandMapper.deleteById(brandId);
    }

    private LambdaQueryWrapper<ProductBrandPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductBrandPo.class);
    }

}
