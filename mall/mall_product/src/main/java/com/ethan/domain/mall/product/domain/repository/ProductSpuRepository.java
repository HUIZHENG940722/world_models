package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ethan.domain.mall.product.domain.bo.spu.ContentProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.CreateProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.DetailsProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.PageDetailsProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.PageQueryProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.UpdateProductSpuBo;
import com.ethan.domain.mall.product.domain.convert.ProductSpuPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductSpuMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.spu.ProductSpuPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghui
 * @Description 商品SPU数据仓库层
 * @Date 2022/5/28
 */
@Repository
public class ProductSpuRepository {

    @Autowired
    private ProductSpuMapper productSpuMapper;

    public Integer add(CreateProductSpuBo createProductSpuBo) {
        ProductSpuPo boToPo = ProductSpuPoConvert.INSTANCE.createBoToPo(createProductSpuBo);
        productSpuMapper.insert(boToPo);
        return boToPo.getId();
    }

    public ContentProductSpuBo getById(Integer id) {
        return ProductSpuPoConvert.INSTANCE.toContentBo(productSpuMapper.selectById(id));
    }

    public int updateById(Integer id, UpdateProductSpuBo updateProductSpuBo) {
        ProductSpuPo productSpuPo = ProductSpuPoConvert.INSTANCE.updateBoToPo(updateProductSpuBo);
        productSpuPo.setId(id);
        return productSpuMapper.updateById(productSpuPo);
    }

    public PageDetailsProductSpuBo pageDetails(PageQueryProductSpuBo queryProductSpuBo) {
        LambdaQueryWrapper<ProductSpuPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        if (queryProductSpuBo.getCid()!=null) {
            lambdaQueryWrapper.eq(ProductSpuPo::getCid, queryProductSpuBo.getCid());
        }
        if (queryProductSpuBo.getName()!=null) {
            lambdaQueryWrapper.like(ProductSpuPo::getName, queryProductSpuBo.getName());
        }
        lambdaQueryWrapper.eq(ProductSpuPo::getVisible, queryProductSpuBo.getVisible());
        Page<ProductSpuPo> page = new Page<>(queryProductSpuBo.getPageNo(), queryProductSpuBo.getPageSize());
        Page<ProductSpuPo> pageData = productSpuMapper.selectPage(page, lambdaQueryWrapper);
        PageDetailsProductSpuBo pageDetailsProductSpuBo = new PageDetailsProductSpuBo();
        pageDetailsProductSpuBo.setTotal(pageData.getTotal());
        pageDetailsProductSpuBo.setData(ProductSpuPoConvert.INSTANCE.toDetailsBo(pageData.getRecords()));
        return pageDetailsProductSpuBo;
    }

    public ContentProductSpuBo getByName(String name) {
        LambdaQueryWrapper<ProductSpuPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductSpuPo::getName, name);
        return ProductSpuPoConvert.INSTANCE.toContentBo(productSpuMapper.selectOne(lambdaQueryWrapper));
    }

    public DetailsProductSpuBo getDetailsById(Integer productSpuId) {
        LambdaQueryWrapper<ProductSpuPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductSpuPo::getId, productSpuId);
        return ProductSpuPoConvert.INSTANCE.toDetailsBo(productSpuMapper.selectOne(lambdaQueryWrapper));
    }

    /**
     * 获取lambda条件构造器
     * @return
     */
    public LambdaQueryWrapper<ProductSpuPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery();
    }
}
