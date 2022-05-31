package com.ethan.domain.mall.product.domain.repository;

import com.ethan.domain.mall.product.domain.bo.sku.CreateProductSkuBo;
import com.ethan.domain.mall.product.domain.convert.ProductSkuPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductSkuMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.sku.ProductSkuPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品SKU数据访问仓库
 * @Date 2022/5/30
 */
@Repository
public class ProductSkuRepository {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    public int addList(List<CreateProductSkuBo> createProductSkuBoList) {
        List<ProductSkuPo> productSkuPoList =  ProductSkuPoConvert.INSTANCE.CreateListBoToPo(createProductSkuBoList);
        for (ProductSkuPo productSkuPo : productSkuPoList) {
            productSkuMapper.insert(productSkuPo);
        }
        return createProductSkuBoList.size();
    }
}
