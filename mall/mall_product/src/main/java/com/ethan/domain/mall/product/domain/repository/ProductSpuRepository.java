package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ethan.domain.mall.product.domain.bo.spu.PageProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.PageQueryProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.ProductSpuBo;
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

    public int add(ProductSpuBo productSpuBo) {
        return productSpuMapper.insert(ProductSpuPoConvert.INSTANCE.toPo(productSpuBo));
    }

    public ProductSpuBo getById(Integer id) {
        return ProductSpuPoConvert.INSTANCE.toBo(productSpuMapper.selectById(id));
    }

    public int update(ProductSpuBo productSpuBo) {
        return productSpuMapper.updateById(ProductSpuPoConvert.INSTANCE.toPo(productSpuBo));
    }

    public PageProductSpuBo page(PageQueryProductSpuBo queryProductSpuBo) {
        LambdaQueryWrapper<ProductSpuPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        if (queryProductSpuBo.getCid()!=null) {
            lambdaQueryWrapper.eq(ProductSpuPo::getCid, queryProductSpuBo.getCid());
        }
        if (queryProductSpuBo.getName()!=null) {
            lambdaQueryWrapper.like(ProductSpuPo::getName, queryProductSpuBo.getName());
        }
        lambdaQueryWrapper.eq(ProductSpuPo::getVisible, queryProductSpuBo.getVisible());
        Page<ProductSpuPo> page = new Page<>(queryProductSpuBo.getPageNo(), queryProductSpuBo.getPageSize());
        Page pageData = productSpuMapper.selectPage(page, lambdaQueryWrapper);
        PageProductSpuBo pageProductSpuBo = new PageProductSpuBo();
        pageProductSpuBo.setTotal(pageData.getTotal());
        pageProductSpuBo.setData(pageData.getRecords());
        return pageProductSpuBo;
    }

    /**
     * 获取lambda条件构造器
     * @return
     */
    public LambdaQueryWrapper<ProductSpuPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery();
    }
}
