package com.ethan.world.mall.product.domain.service;

import com.ethan.world.mall.product.domain.bo.brand.*;
import com.ethan.world.mall.product.domain.repository.ProductBrandRepository;
import com.ethan.world.mall.product.infrastructure.exception.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @Author zWX1058539
 * @Description 商品品牌领域服务
 * @Date 2022/5/30
 */
@Service
public class ProductBrandDomainService {

    @Autowired
    private ProductBrandRepository productBrandRepository;

    /**
     * 领域服务：创建商品品牌
     *
     * @param createProductBrandBo
     * @return
     */
    public int createProductBrand(CreateProductBrandBo createProductBrandBo) {
        // 1 核心校验
        // 1.1 校验商品品牌名称是否重复
        ContentProductBrandBo byName = productBrandRepository.getByName(createProductBrandBo.getName());
        if (byName != null) {
            throw new ProductException(HttpStatus.CONFLICT, "该商品品牌已添加");
        }
        // 2 核心业务
        return productBrandRepository.add(createProductBrandBo);
        // 3 返回结果
    }

    /**
     * 领域服务：更新商品品牌
     *
     * @param brandId
     * @param updateProductBrandBo
     * @return
     */
    public int updateProductBrand(Integer brandId, UpdateProductBrandBo updateProductBrandBo) {
        // 1 核心校验
        // 1.1 校验商品品牌是否存在
        ContentProductBrandBo byId = productBrandRepository.getById(brandId);
        if (byId == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品品牌不存在");
        }
        // 1.2 校验商品品牌名称是否存在
        ContentProductBrandBo byName = productBrandRepository.getByName(updateProductBrandBo.getName());
        if (byName != null && !byName.getName().equalsIgnoreCase(byId.getName())) {
            throw new ProductException(HttpStatus.CONFLICT, "商品品牌名称已存在");
        }
        // 2 核心业务
        return productBrandRepository.updateById(brandId, updateProductBrandBo);
        // 3 返回结果
    }

    /**
     * 领域服务：获取商品品牌内容
     *
     * @param brandId
     * @return
     */
    public ContentProductBrandBo get(Integer brandId) {
        // 1 核心校验
        // 1.1 校验商品品牌是否存在
        ContentProductBrandBo byId = productBrandRepository.getById(brandId);
        if (byId == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品品牌不存在");
        }
        // 2 核心业务
        return productBrandRepository.getById(brandId);
        // 3 返回结果
    }

    /**
     * 分页查询商品品牌
     *
     * @param pageQueryProductBrandBo
     * @return
     */
    public PageProductBrandBo page(PageQueryProductBrandBo pageQueryProductBrandBo) {
        // 1 核心校验
        // 2 核心业务
        return productBrandRepository.page(pageQueryProductBrandBo);
        // 3 返回结果
    }

    /**
     * 领域服务：删除商品品牌
     *
     * @param brandId
     */
    public int deleteProductBrand(Integer brandId) {
        // 1 核心校验
        // 1.1 校验商品品牌是否存在
        ContentProductBrandBo byId = productBrandRepository.getById(brandId);
        if (byId == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品品牌不存在");
        }
        // 2 核心业务
        return productBrandRepository.deleteById(brandId);
        // 3 返回结果
    }
}
