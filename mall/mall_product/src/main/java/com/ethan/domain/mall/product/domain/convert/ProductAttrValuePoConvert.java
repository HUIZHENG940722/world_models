package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.UpdateProductAttrValueBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.attr.ProductAttrValuePo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品规格值转换器
 * @Date 2022/6/1
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductAttrValuePoConvert {

    ProductAttrValuePoConvert INSTANCE = Mappers.getMapper(ProductAttrValuePoConvert.class);

    ContentProductAttrValueBo toContent(ProductAttrValuePo selectOne);

    List<ContentProductAttrValueBo> toContent(List<ProductAttrValuePo> records);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "deleted", ignore = true),
            @Mapping(target = "createTime", ignore = true),
            @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductAttrValuePo updateBoToPo(UpdateProductAttrValueBo updateProductAttrValueBo);


}
