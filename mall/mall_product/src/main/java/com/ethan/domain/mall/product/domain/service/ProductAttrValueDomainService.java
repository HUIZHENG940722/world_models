package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.attr.key.ContentProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.CreateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.repository.ProductAttrValueRepository;
import com.ethan.domain.mall.product.infrastructure.api.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhenghui
 * @Description 更新商品规格值领域服务
 * @Date 2022/6/1
 */
@Service
public class ProductAttrValueDomainService {

    @Autowired
    private ProductAttrKeyDomainService productAttrKeyDomainService;

    @Autowired
    private ProductAttrValueRepository productAttrValueRepository;

    /**
     * 领域服务：创建商品规格值
     * @param attrKeyId
     * @param createProductAttrValueBo
     * @return
     */
    public Integer createProductAttrValue(Integer attrKeyId, CreateProductAttrValueBo createProductAttrValueBo) {
        // 1 核心校验
        // 1.1 校验商品规格键是否存在
        ContentProductAttrKeyBo contentProductAttrKeyBo = productAttrKeyDomainService.getById(attrKeyId);
        if (contentProductAttrKeyBo == null) {
            Asserts.fail("商品规格键不存在");
        }
        // 1.2 校验商品规格值的名字是否重复
        ContentProductAttrValueBo byName = productAttrValueRepository.getByName(createProductAttrValueBo.getName());
        if (byName !=null && !byName.getId().equals(attrKeyId)) {
            Asserts.fail("商品规格值名字重复");
        }
        // 2 核心业务
        createProductAttrValueBo.setAttrKeyId(attrKeyId);
        return productAttrValueRepository.add(createProductAttrValueBo);
        // 3 返回结果
    }
}
