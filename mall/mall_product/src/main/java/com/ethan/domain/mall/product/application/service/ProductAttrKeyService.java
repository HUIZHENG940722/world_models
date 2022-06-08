package com.ethan.domain.mall.product.application.service;

import com.ethan.domain.mall.product.domain.bo.attr.key.ContentProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.PageProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.PageQueryProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.CreateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.PageProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.PageQueryProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.UpdateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.service.ProductAttrKeyDomainService;
import com.ethan.domain.mall.product.domain.service.ProductAttrValueDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zWX1058539
 * @Description 商品规格应用服务
 * @Date 2022/6/2
 */
@Service
public class ProductAttrKeyService {

    @Autowired
    private ProductAttrKeyDomainService productAttrKeyDomainService;

    /**
     * 应用服务：创建商品规格键
     *
     * @param createProductAttrKeyBo
     * @return
     */
    public Integer createProductAttrKey(CreateProductAttrKeyBo createProductAttrKeyBo) {
        // 1 校验
        // 2 业务
        return productAttrKeyDomainService.create(createProductAttrKeyBo);
        // 3 返回结果
    }


    /**
     * 应用服务：更新商品规格键
     *
     * @param updateProductAttrKeyBo
     * @return
     */
    public Integer updateProductAttrKeyById(Integer attrKeyId, UpdateProductAttrKeyBo updateProductAttrKeyBo) {
        // 1 校验
        // 2 业务
        return productAttrKeyDomainService.updateById(attrKeyId, updateProductAttrKeyBo);
        // 3 返回结果
    }

    /**
     * 应用服务：获得商品规格键
     *
     * @param productAttrKeyId
     */
    public ContentProductAttrKeyBo getProductAttrKey(Integer productAttrKeyId) {
        // 1 校验
        // 2 业务
        return productAttrKeyDomainService.getById(productAttrKeyId);
        // 3 返回结果
    }

    /**
     * 应用服务：分页查询商品规格键
     *
     * @param pageQueryProductAttrKeyBo
     * @return
     */
    public PageProductAttrKeyBo pageProductAttrKey(PageQueryProductAttrKeyBo pageQueryProductAttrKeyBo) {
        // 1 校验
        // 2 业务
        return productAttrKeyDomainService.page(pageQueryProductAttrKeyBo);
        // 3 返回结果
    }
}
