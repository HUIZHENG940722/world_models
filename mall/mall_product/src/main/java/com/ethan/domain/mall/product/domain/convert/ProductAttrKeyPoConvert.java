package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.attr.key.ContentProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
import com.ethan.domain.mall.product.infrastructure.dao.enums.DeletedEnum;
import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import com.ethan.domain.mall.product.infrastructure.dao.po.attr.ProductAttrKeyPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品规格键PO转换器
 * @Date 2022/6/1
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductAttrKeyPoConvert {

    ProductAttrKeyPoConvert INSTANCE = Mappers.getMapper(ProductAttrKeyPoConvert.class);

    ContentProductAttrKeyBo toContent(ProductAttrKeyPo selectOne);

    List<ContentProductAttrKeyBo> toContent(List<ProductAttrKeyPo> records);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "status", expression = "java(com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum.NUMBER_1)"),
        @Mapping(target = "deleted", expression = "java(com.ethan.domain.mall.product.infrastructure.dao.enums.DeletedEnum.NUMBER_1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductAttrKeyPo createBotoPo(CreateProductAttrKeyBo createProductAttrKeyBo);


    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "deleted", expression = "java(com.ethan.domain.mall.product.infrastructure.dao.enums.DeletedEnum.NUMBER_1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductAttrKeyPo updateBoToPo(UpdateProductAttrKeyBo updateProductAttrKeyBo);
}
