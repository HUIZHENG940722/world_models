package com.ethan.domain.mall.product.interfaces.assembler;

import com.ethan.domain.mall.product.interfaces.dto.category.CreateProductCategoryReq;
import com.ethan.domain.mall.product.domain.bo.category.ProductCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author zhenghui
 * @Description 商品分类DTO转换器
 * @Date 2022/5/29
 */
@Mapper
public interface ProductCategoryDtoConvert {
    ProductCategoryDtoConvert INSTANCE = Mappers.getMapper(ProductCategoryDtoConvert.class);

    @Mappings({
            @Mapping(target = "deleted", expression = "java(1)"),
            @Mapping(target = "createTime", ignore = true),
            @Mapping(target = "updateTime", ignore = true),
    })
    ProductCategoryBO toBo(CreateProductCategoryReq createProductCategoryReq);
}
