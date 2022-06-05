package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ethan.domain.mall.product.domain.bo.category.*;
import com.ethan.domain.mall.product.domain.convert.ProductCategoryPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductCategoryMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.category.ProductCategoryPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品分类数据仓库
 * @Date 2022/5/29
 */
@Repository
public class ProductCategoryRepository {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public CreateProductCategoryBo getByPid(Integer pid) {
        return ProductCategoryPoConvert.INSTANCE.toCreateBo(productCategoryMapper.selectById(pid));
    }

    public int add(CreateProductCategoryBo createProductCategoryBo) {
        ProductCategoryPo boToPo = ProductCategoryPoConvert.INSTANCE.createBoToPo(createProductCategoryBo);
        productCategoryMapper.insert(boToPo);
        return boToPo.getId();
    }

    public ContentProductCategoryBo getByName(String name) {
        LambdaQueryWrapper<ProductCategoryPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductCategoryPo::getName, name);
        return ProductCategoryPoConvert.INSTANCE.toDetailsBo(productCategoryMapper.selectOne(lambdaQueryWrapper));
    }

    public ContentProductCategoryBo getById(Integer id) {
        return ProductCategoryPoConvert.INSTANCE.toDetailsBo(productCategoryMapper.selectById(id));
    }

    public int updateById(Integer id, UpdateProductCategoryBo updateProductCategoryBo) {
        ProductCategoryPo productCategoryPo = ProductCategoryPoConvert.INSTANCE.updateBotoPo(updateProductCategoryBo);
        productCategoryPo.setId(id);
        return productCategoryMapper.updateById(productCategoryPo);
    }

    public List<ContentProductCategoryBo> getChildListByPid(Integer id) {
        LambdaQueryWrapper<ProductCategoryPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductCategoryPo::getPid, id);
        return ProductCategoryPoConvert.INSTANCE.toContentPo(productCategoryMapper.selectList(lambdaQueryWrapper));
    }

    public PageProductCategoryBo page(PageQueryProductCategoryBo pageQueryProductCategoryBo) {
        LambdaQueryWrapper<ProductCategoryPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        if (pageQueryProductCategoryBo.getId() != null) {
            lambdaQueryWrapper.eq(ProductCategoryPo::getId, pageQueryProductCategoryBo.getId());
        }
        if (pageQueryProductCategoryBo.getPid() != null) {
            lambdaQueryWrapper.eq(ProductCategoryPo::getPid, pageQueryProductCategoryBo.getPid());
        }

        if (pageQueryProductCategoryBo.getName() != null) {
            lambdaQueryWrapper.like(ProductCategoryPo::getName, pageQueryProductCategoryBo.getName());
        }
        if (pageQueryProductCategoryBo.getStatus() != null) {
            lambdaQueryWrapper.eq(ProductCategoryPo::getStatus, pageQueryProductCategoryBo.getStatus());
        }
        Page<ProductCategoryPo> productCategoryPoPage = productCategoryMapper.selectPage(
            new Page<>(pageQueryProductCategoryBo.getPageNo(), pageQueryProductCategoryBo.getPageSize()),
            lambdaQueryWrapper);
        PageProductCategoryBo pageProductCategoryBo = new PageProductCategoryBo();
        pageProductCategoryBo.setTotal((int) productCategoryPoPage.getTotal());
        pageProductCategoryBo.setData(ProductCategoryPoConvert.INSTANCE.toContentPo(productCategoryPoPage.getRecords()));
        return pageProductCategoryBo;
    }

    public int deleteById(Integer id) {
        return productCategoryMapper.deleteById(id);
    }

    private LambdaQueryWrapper<ProductCategoryPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductCategoryPo.class);
    }


}
