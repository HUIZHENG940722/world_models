package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.attr.ProductAttrValuePo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhenghui
 * @Description 商品规格值转换器
 * @Date 2022/6/1
 */
@Mapper
public interface ProductAttrValuePoConvert {

    ProductAttrValuePoConvert INSTANCE = Mappers.getMapper(ProductAttrValuePoConvert.class);

    ContentProductAttrValueBo toContent(ProductAttrValuePo selectOne);
}
