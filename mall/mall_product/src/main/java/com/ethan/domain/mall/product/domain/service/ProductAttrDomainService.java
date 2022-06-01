package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.attr.ContentProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.repository.ProductAttrKeyRepository;
import com.ethan.domain.mall.product.domain.repository.ProductAttrValueRepository;
import com.ethan.domain.mall.product.infrastructure.api.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zWX1058539
 * @Description 商品规格领域服务
 * @Date 2022/6/1
 */
@Service
public class ProductAttrDomainService {

    @Autowired
    private ProductAttrKeyRepository productAttrKeyRepository;

    @Autowired
    private ProductAttrValueRepository productAttrValueRepository;

    /**
     * 领域服务：创建商品规格键
     * @param createProductAttrKeyBo
     * @return
     */
    public Integer createProductAttrKey(CreateProductAttrKeyBo createProductAttrKeyBo) {
        // 1 核心校验
        // 1.1 校验规格键名字是否重复
        ContentProductAttrKeyBo contentProductAttrKeyBo = productAttrKeyRepository.getByName(createProductAttrKeyBo.getName());
        if (contentProductAttrKeyBo == null) {
            Asserts.fail("商品规格键重复");
        }
        // 2 核心业务
        return productAttrKeyRepository.add(contentProductAttrKeyBo);
        // 3 返回结果
    }
}
