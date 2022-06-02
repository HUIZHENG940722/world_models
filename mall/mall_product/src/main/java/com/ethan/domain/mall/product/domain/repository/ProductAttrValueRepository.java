package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.CreateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.UpdateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.convert.ProductAttrValuePoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductAttrValueMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.attr.ProductAttrValuePo;
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

    private LambdaQueryWrapper<ProductAttrValuePo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductAttrValuePo.class);
    }

    public Integer updateById(Integer attrValueId, UpdateProductAttrValueBo updateProductAttrValueBo) {
        ProductAttrValuePo productAttrValuePo = ProductAttrValuePoConvert.INSTANCE.updateBoToPo(updateProductAttrValueBo);
        productAttrValuePo.setId(attrValueId);
        return productAttrValueMapper.updateById(productAttrValuePo);
    }
}
