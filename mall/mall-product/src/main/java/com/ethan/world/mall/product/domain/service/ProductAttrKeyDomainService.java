package com.ethan.world.mall.product.domain.service;

import com.ethan.world.mall.product.domain.bo.attr.key.ContentProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.key.PageProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.key.PageQueryProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
import com.ethan.world.mall.product.domain.repository.ProductAttrKeyRepository;
import com.ethan.world.mall.product.infrastructure.exception.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @Author zWX1058539
 * @Description 商品规格键领域服务
 * @Date 2022/6/1
 */
@Service
public class ProductAttrKeyDomainService {

    @Autowired
    private ProductAttrKeyRepository productAttrKeyRepository;


    /**
     * 领域服务：创建商品规格键
     *
     * @param createProductAttrKeyBo
     * @return
     */
    public Integer create(CreateProductAttrKeyBo createProductAttrKeyBo) {
        // 1 核心校验
        // 1.1 校验规格键名字是否重复
        ContentProductAttrKeyBo contentProductAttrKeyBo = productAttrKeyRepository.getByName(createProductAttrKeyBo.getName());
        if (contentProductAttrKeyBo != null) {
            throw new ProductException(HttpStatus.CONFLICT, "商品规格键重复");
        }
        // 2 核心业务
        return productAttrKeyRepository.add(createProductAttrKeyBo);
        // 3 返回结果
    }


    /**
     * 领域服务：更新商品规格键
     *
     * @param attrKeyId
     * @param updateProductAttrKeyBo
     * @return
     */
    public int updateById(Integer attrKeyId, UpdateProductAttrKeyBo updateProductAttrKeyBo) {
        // 1 核心校验
        // 1.1 校验规格键是否存在
        ContentProductAttrKeyBo contentProductAttrKeyBo = productAttrKeyRepository.getById(attrKeyId);
        if (contentProductAttrKeyBo == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "无效的商品规格键");
        }
        // 1.2 校验规格键的名字是否重复
        ContentProductAttrKeyBo byName = productAttrKeyRepository.getByName(updateProductAttrKeyBo.getName());
        if (byName != null && !byName.getId().equals(attrKeyId)) {
            throw new ProductException(HttpStatus.CONFLICT, "商品规格键名字重复");
        }
        // 2 核心业务
        return productAttrKeyRepository.updateById(attrKeyId, updateProductAttrKeyBo);
        // 3 返回结果
    }

    /**
     * 领域服务：获取商品规格键内容
     *
     * @param attrKeyId
     * @return
     */
    public ContentProductAttrKeyBo getById(Integer attrKeyId) {
        // 1 核心校验
        // 2 核心业务
        // 3 返回结果
        return productAttrKeyRepository.getById(attrKeyId);
    }

    /**
     * 领域服务：分页获取商品规格键内容
     *
     * @param pageQueryProductAttrKeyBo
     * @return
     */
    public PageProductAttrKeyBo page(PageQueryProductAttrKeyBo pageQueryProductAttrKeyBo) {
        // 1 核心校验
        // 2 核心业务
        return productAttrKeyRepository.page(pageQueryProductAttrKeyBo);
        // 3 返回结果
    }
}
