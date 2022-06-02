package com.ethan.domain.mall.product.interfaces.assembler;

import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.interfaces.dto.attr.CreateProductAttrKeyReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author zWX1058539
 * @Description 商品规格DTO转换器
 * @Date 2022/6/2
 */
@Mapper
public interface ProductAttrDtoConvert {

    ProductAttrDtoConvert INSTANCE = Mappers.getMapper(ProductAttrDtoConvert.class);


    CreateProductAttrKeyBo toBo(CreateProductAttrKeyReq createProductAttrKeyReq);
}
