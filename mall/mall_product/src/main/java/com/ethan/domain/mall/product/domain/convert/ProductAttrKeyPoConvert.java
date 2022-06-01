package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.attr.key.ContentProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.attr.ProductAttrKeyPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Author zWX1058539
 * @Description 商品规格键PO转换器
 * @Date 2022/6/1
 */
@Mapper
public interface ProductAttrKeyPoConvert {

    ProductAttrKeyPoConvert INSTANCE = Mappers.getMapper(ProductAttrKeyPoConvert.class);

    ContentProductAttrKeyBo toContent(ProductAttrKeyPo selectOne);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductAttrKeyPo createBotoPo(CreateProductAttrKeyBo createProductAttrKeyBo);


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "deleted", expression = "java(1)"),
            @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
            @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductAttrKeyPo updateBoToPo(UpdateProductAttrKeyBo updateProductAttrKeyBo);
}
