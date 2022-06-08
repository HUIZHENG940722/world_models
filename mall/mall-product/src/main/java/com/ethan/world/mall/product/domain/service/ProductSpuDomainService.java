package com.ethan.world.mall.product.domain.service;

import com.ethan.world.mall.product.domain.bo.spu.ContentProductSpuBo;
import com.ethan.world.mall.product.domain.bo.spu.CreateProductSpuBo;
import com.ethan.world.mall.product.domain.bo.spu.DetailsProductSpuBo;
import com.ethan.world.mall.product.domain.bo.spu.PageDetailsProductSpuBo;
import com.ethan.world.mall.product.domain.bo.spu.PageQueryProductSpuBo;
import com.ethan.world.mall.product.domain.bo.spu.UpdateProductSpuBo;
import com.ethan.world.mall.product.domain.repository.ProductSpuRepository;
import com.ethan.world.mall.product.infrastructure.exception.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhenghui
 * @Description 商品SPU领域服务
 * @Date 2022/5/28
 */
@Service
public class ProductSpuDomainService {

    @Autowired
    private ProductSpuRepository productSpuRepository;

    /**
     * 领域服务：创建商品SPU
     *
     * @param createProductSpuBo
     * @return
     */
    @Transactional
    public Integer createProductSpu(CreateProductSpuBo createProductSpuBo) {
        // 1 核心校验
        // 1.1 校验商品SPU名称是否存在
        ContentProductSpuBo contentProductSpuBo = productSpuRepository.getByName(createProductSpuBo.getName());
        if (contentProductSpuBo != null) {
            throw new ProductException(HttpStatus.CONFLICT, "商品SPU名称已存在");
        }
        // 2 核心业务
        return productSpuRepository.add(createProductSpuBo);
        // 3 返回结果
    }

    /**
     * 领域服务：更新商品SPU
     *
     * @param updateProductSpuBo
     * @return
     */
    @Transactional
    public int updateProductSpu(Integer id, UpdateProductSpuBo updateProductSpuBo) {
        // 1 核心校验
        // 1.1 校验商品SPU是否存在
        ContentProductSpuBo contentProductSpuBo = productSpuRepository.getById(id);
        if (contentProductSpuBo == null) {
            throw new ProductException(HttpStatus.NOT_FOUND, "商品SPU非法");
        }
        // 2 核心业务
        return productSpuRepository.updateById(id, updateProductSpuBo);
        // 3 返回结果
    }

    /**
     * 领域服务：获取商品SPU详情
     *
     * @param productSpuId
     * @return
     */
    public DetailsProductSpuBo getProductSpu(Integer productSpuId) {
        // 1 核心校验
        // 2 核心业务
        return productSpuRepository.getDetailsById(productSpuId);
        // 3 返回结果
    }

    /**
     * 领域服务：分页查询商品SPU详情列表
     *
     * @param queryProductSpuBo
     * @return
     */
    public PageDetailsProductSpuBo pageProductSpu(PageQueryProductSpuBo queryProductSpuBo) {
        return productSpuRepository.pageDetails(queryProductSpuBo);
    }
}
