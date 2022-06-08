package com.ethan.domain.mall.product.domain.service;

import com.ethan.domain.mall.product.domain.bo.attr.key.ContentProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.CreateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.PageProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.PageQueryProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.UpdateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.repository.ProductAttrValueRepository;
import com.ethan.domain.mall.product.infrastructure.exception.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
     *
     * @param attrKeyId
     * @param createProductAttrValueBo
     * @return
     */
    public Integer createProductAttrValue(Integer attrKeyId, CreateProductAttrValueBo createProductAttrValueBo) {
        // 1 核心校验
        // 1.1 校验商品规格键是否存在
        ContentProductAttrKeyBo contentProductAttrKeyBo = productAttrKeyDomainService.getById(attrKeyId);
        if (contentProductAttrKeyBo == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品规格键不存在");
        }
        // 1.2 校验商品规格值的名字是否重复
        ContentProductAttrValueBo byName = productAttrValueRepository.getByName(createProductAttrValueBo.getName());
        if (byName != null && !byName.getId().equals(attrKeyId)) {
            throw new ProductException(HttpStatus.CONFLICT, "商品规格值名字重复");
        }
        // 2 核心业务
        createProductAttrValueBo.setAttrKeyId(attrKeyId);
        return productAttrValueRepository.add(createProductAttrValueBo);
        // 3 返回结果
    }

    /**
     * 领域服务：更新商品规格值
     *
     * @param attrValueId
     * @param updateProductAttrValueBo
     * @return
     */
    public Integer updateProductAttrValue(Integer attrValueId, UpdateProductAttrValueBo updateProductAttrValueBo) {
        // 1 核心校验
        // 1.1 校验商品规格值是否存在
        ContentProductAttrValueBo contentProductAttrValueBo = productAttrValueRepository.getById(attrValueId);
        if (contentProductAttrValueBo == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品规格值不存在");
        }
        // 1.2 校验商品规格值名称是否重复
        ContentProductAttrValueBo byName = productAttrValueRepository.getByName(updateProductAttrValueBo.getName());
        if (byName != null && !byName.getId().equals(contentProductAttrValueBo.getId())) {
            throw new ProductException(HttpStatus.CONFLICT, "商品规格值名字重复");
        }
        // 1.3 校验商品规格键是否存在
        ContentProductAttrKeyBo byId = productAttrKeyDomainService.getById(updateProductAttrValueBo.getAttrKeyId());
        if (byId == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品规格键不存在");
        }
        // 2 核心业务
        return productAttrValueRepository.updateById(attrValueId, updateProductAttrValueBo);
        // 3 返回结果
    }

    /**
     * 领域服务：获取商品规格值内容
     *
     * @param attrValueId
     * @return
     */
    public ContentProductAttrValueBo getById(Integer attrValueId) {
        // 1 核心校验
        // 1.1 判断商品规格值编码是否有效
        ContentProductAttrValueBo byId = productAttrValueRepository.getById(attrValueId);
        if (byId == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品规格值编码无效");
        }
        // 2 核心业务
        // 3 返回结果
        return byId;
    }

    /**
     * 领域服务：分页查询商品规格值
     *
     * @param pageQueryProductAttrValueBo
     * @return
     */
    public PageProductAttrValueBo page(PageQueryProductAttrValueBo pageQueryProductAttrValueBo) {
        // 1 核心校验
        // 1.1 校验规格键编码是否正确
        if (pageQueryProductAttrValueBo.getAttrKeyId() != null) {
            ContentProductAttrKeyBo byId = productAttrKeyDomainService.getById(pageQueryProductAttrValueBo.getAttrKeyId());
            if (byId == null) {
                throw new ProductException(HttpStatus.CONFLICT, "商品规格键编码非法");
            }
        }
        // 2 核心业务
        return productAttrValueRepository.page(pageQueryProductAttrValueBo);
        // 3 返回结果
    }
}
