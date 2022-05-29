package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.category.ProductCategoryBO;
import com.ethan.domain.mall.product.infrastructure.dao.po.category.ProductCategoryPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhenghui
 * @Description 商品分类PO转换器
 * @Date 2022/5/29
 */
@Mapper
public interface ProductCategoryPoConvert {
    ProductCategoryPoConvert INSTANCE = Mappers.getMapper(ProductCategoryPoConvert.class);

    ProductCategoryBO toBo(ProductCategoryPo selectById);

    ProductCategoryPo toPo(ProductCategoryBO productCategoryBO);
}
