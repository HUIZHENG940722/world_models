package com.ethan.domain.mall.product.domain.repository;

import com.ethan.domain.mall.product.domain.bo.ProductSpuBo;
import com.ethan.domain.mall.product.domain.convert.ProductSpuPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductSpuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghui
 * @name ProductSpuRepository
 * @Description 商品SPU数据仓库层
 * @Date 2022/5/28
 */
@Repository
public class ProductSpuRepository {

    @Autowired
    private ProductSpuMapper productSpuMapper;

    public int add(ProductSpuBo productSpuBo) {
        return productSpuMapper.insert(ProductSpuPoConvert.INSTANCE.toPo(productSpuBo));
    }

    public ProductSpuBo getById(Integer id) {
        return ProductSpuPoConvert.INSTANCE.toBo(productSpuMapper.selectById(id));
    }

    public int update(ProductSpuBo productSpuBo) {
        return productSpuMapper.updateById(ProductSpuPoConvert.INSTANCE.toPo(productSpuBo));
    }
}
