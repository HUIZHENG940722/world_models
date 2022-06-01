package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.mall.product.domain.bo.attr.ContentProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.UpdateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.convert.ProductAttrKeyPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductAttrKeyMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.attr.ProductAttrKeyPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author zWX1058539
 * @Description 商品规格键数据仓库
 * @Date 2022/6/1
 */
@Repository
public class ProductAttrKeyRepository {

    @Autowired
    private ProductAttrKeyMapper productAttrKeyMapper;

    public ContentProductAttrKeyBo getByName(String name) {
        LambdaQueryWrapper<ProductAttrKeyPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductAttrKeyPo::getName, name);
        return ProductAttrKeyPoConvert.INSTANCE.toContent(productAttrKeyMapper.selectOne(lambdaQueryWrapper));
    }

    public Integer add(CreateProductAttrKeyBo createProductAttrKeyBo) {
        ProductAttrKeyPo productAttrKeyPo = ProductAttrKeyPoConvert.INSTANCE.createBotoPo(createProductAttrKeyBo);
        productAttrKeyMapper.insert(productAttrKeyPo);
        return productAttrKeyPo.getId();
    }

    public ContentProductAttrKeyBo getById(Integer attrKeyId) {
        return ProductAttrKeyPoConvert.INSTANCE.toContent(productAttrKeyMapper.selectById(attrKeyId));
    }

    public int updateById(Integer attrKeyId, UpdateProductAttrKeyBo updateProductAttrKeyBo) {
        ProductAttrKeyPo productAttrKeyPo = ProductAttrKeyPoConvert.INSTANCE.updateBoToPo(updateProductAttrKeyBo);
        productAttrKeyPo.setId(attrKeyId);
        return productAttrKeyMapper.updateById(productAttrKeyPo);
    }

    private LambdaQueryWrapper<ProductAttrKeyPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductAttrKeyPo.class);
    }
}
