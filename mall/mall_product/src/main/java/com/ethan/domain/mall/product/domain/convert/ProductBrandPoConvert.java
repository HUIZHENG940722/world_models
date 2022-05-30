package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.brand.ProductBrandBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.brand.ProductBrandPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author zWX1058539
 * @Description 商品品牌PO转换器
 * @Date 2022/5/30
 */
@Mapper
public interface ProductBrandPoConvert {
    ProductBrandPoConvert INSTANCE = Mappers.getMapper(ProductBrandPoConvert.class);

    ProductBrandBo toBo(ProductBrandPo selectOne);

    ProductBrandPo toPo(ProductBrandBo productBrandBo);
}
