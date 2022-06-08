package com.ethan.domain.mall.product.application.service;

import com.ethan.domain.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.CreateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.PageProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.PageQueryProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.UpdateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.service.ProductAttrValueDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zWX1058539
 * @Description 商品规格值应用服务
 * @Date 2022/6/8
 */
@Service
public class ProductAttrValueService {

    @Autowired
    private ProductAttrValueDomainService productAttrValueDomainService;

    /**
     * 应用服务：创建商品规格值
     *
     * @param attrKeyId
     * @param createProductAttrValueBo
     * @return
     */
    public Integer createProductAttrValue(Integer attrKeyId, CreateProductAttrValueBo createProductAttrValueBo) {
        // 1 校验
        // 2 业务
        createProductAttrValueBo.setAttrKeyId(attrKeyId);
        return productAttrValueDomainService.createProductAttrValue(createProductAttrValueBo);
        // 3 返回结果
    }

    /**
     * 应用服务：更新商品规格值
     *
     * @param attrKeyId
     * @param attrValueId
     * @param updateProductAttrValueBO
     * @return
     */
    public Integer updateProductAttrValue(Integer attrKeyId, Integer attrValueId, UpdateProductAttrValueBo updateProductAttrValueBO) {
        // 1 校验
        // 2 业务
        updateProductAttrValueBO.setAttrKeyId(attrKeyId);
        return productAttrValueDomainService.updateProductAttrValue(attrValueId, updateProductAttrValueBO);
        // 3 返回结果
    }

    /**
     * 应用服务：获取商品规格值内容
     *
     * @param attrValueId
     * @return
     */
    public ContentProductAttrValueBo getProductAttrValue(Integer attrValueId) {
        // 1 校验
        // 2 业务
        return productAttrValueDomainService.getById(attrValueId);
        // 3 返回结果
    }

    /**
     * 应用服务：分页查询商品规格值
     *
     * @param pageQueryProductAttrValueBo
     * @return
     */
    public PageProductAttrValueBo pageProductAttrValue(PageQueryProductAttrValueBo pageQueryProductAttrValueBo) {
        // 1 校验
        // 2 业务
        return productAttrValueDomainService.page(pageQueryProductAttrValueBo);
        // 3 返回结果
    }
}
