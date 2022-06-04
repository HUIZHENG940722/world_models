package com.ethan.domain.mall.product.interfaces.assembler;

import com.ethan.domain.mall.product.domain.bo.brand.CreateProductBrandBo;
import com.ethan.domain.mall.product.interfaces.dto.brand.CreateProductBrandReq;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @Author zWX1058539
 * @Description 商品品牌DTO转换器
 * @Date 2022/5/30
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductBrandDtoConvert {
    ProductBrandDtoConvert INSTANCE = Mappers.getMapper(ProductBrandDtoConvert.class);


    CreateProductBrandBo toBo(CreateProductBrandReq createProductBrandReq);
}
