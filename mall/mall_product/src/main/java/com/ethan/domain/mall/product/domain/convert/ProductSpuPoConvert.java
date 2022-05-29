package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.spu.ProductSpuBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.spu.ProductSpuPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhenghui
 * @Description 商品SPU PO转换器
 * @Date 2022/5/29
 */
@Mapper
public interface ProductSpuPoConvert {

    ProductSpuPoConvert INSTANCE = Mappers.getMapper(ProductSpuPoConvert.class);

    ProductSpuPo toPo(ProductSpuBo productSpuBo);

    ProductSpuBo toBo(ProductSpuPo productSpuPo);
}
