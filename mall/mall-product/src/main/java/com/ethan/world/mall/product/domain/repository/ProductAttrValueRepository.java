package com.ethan.world.mall.product.domain.repository;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ethan.world.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.world.mall.product.domain.bo.attr.value.CreateProductAttrValueBo;
import com.ethan.world.mall.product.domain.bo.attr.value.PageProductAttrValueBo;
import com.ethan.world.mall.product.domain.bo.attr.value.PageQueryProductAttrValueBo;
import com.ethan.world.mall.product.domain.bo.attr.value.UpdateProductAttrValueBo;
import com.ethan.world.mall.product.domain.convert.ProductAttrValuePoConvert;
import com.ethan.world.mall.product.infrastructure.dao.ProductAttrValueMapper;
import com.ethan.world.mall.product.infrastructure.dao.po.attr.ProductAttrValuePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author zWX1058539
 * @Description 商品规格值数据仓库
 * @Date 2022/6/1
 */
@Repository
public class ProductAttrValueRepository {

    @Autowired
    private ProductAttrValueMapper productAttrValueMapper;

    public ContentProductAttrValueBo getByName(String name) {
        LambdaQueryWrapper<ProductAttrValuePo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductAttrValuePo::getName, name);
        return ProductAttrValuePoConvert.INSTANCE.toContent(productAttrValueMapper.selectOne(lambdaQueryWrapper));
    }

    public Integer add(CreateProductAttrValueBo createProductAttrValueBo) {
        return null;
    }

    public ContentProductAttrValueBo getById(Integer attrValueId) {
        return ProductAttrValuePoConvert.INSTANCE.toContent(productAttrValueMapper.selectById(attrValueId));
    }

    public Integer updateById(Integer attrValueId, UpdateProductAttrValueBo updateProductAttrValueBo) {
        ProductAttrValuePo productAttrValuePo = ProductAttrValuePoConvert.INSTANCE.updateBoToPo(updateProductAttrValueBo);
        productAttrValuePo.setId(attrValueId);
        return productAttrValueMapper.updateById(productAttrValuePo);
    }

    public PageProductAttrValueBo page(PageQueryProductAttrValueBo pageQueryProductAttrValueBo) {
        LambdaQueryWrapper<ProductAttrValuePo> lambdaQueryWrapper = getLambdaQueryWrapper();
        if (pageQueryProductAttrValueBo.getAttrKeyId() != null) {
            lambdaQueryWrapper.eq(ProductAttrValuePo::getAttrKeyId, pageQueryProductAttrValueBo.getAttrKeyId());
        }
        if (StrUtil.isNotBlank(pageQueryProductAttrValueBo.getName())) {
            lambdaQueryWrapper.like(ProductAttrValuePo::getName, pageQueryProductAttrValueBo.getName().trim());
        }
        if (pageQueryProductAttrValueBo.getStatus() != null) {
            lambdaQueryWrapper.eq(ProductAttrValuePo::getStatus, pageQueryProductAttrValueBo.getStatus());
        }
        Page<ProductAttrValuePo> productAttrValuePoPage = productAttrValueMapper.selectPage(
            new Page<>(pageQueryProductAttrValueBo.getPageNo(), pageQueryProductAttrValueBo.getPageSize()),
            lambdaQueryWrapper);
        PageProductAttrValueBo pageProductAttrValueBo = new PageProductAttrValueBo();
        pageProductAttrValueBo.setTotal((int) productAttrValuePoPage.getTotal());
        pageProductAttrValueBo.setData(ProductAttrValuePoConvert.INSTANCE.toContent(productAttrValuePoPage.getRecords()));
        return pageProductAttrValueBo;
    }

    private LambdaQueryWrapper<ProductAttrValuePo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductAttrValuePo.class);
    }
}
