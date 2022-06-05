package com.ethan.domain.mall.product.application.service;

import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
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
public class ProductAttrService {

    @Autowired
    private ProductAttrKeyDomainService productAttrKeyDomainService;

    @Autowired
    private ProductAttrValueDomainService productAttrValueDomainService;

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
}
