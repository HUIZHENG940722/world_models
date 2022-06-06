package com.ethan.domain.mall.product.interfaces.assembler;

import com.ethan.domain.mall.product.domain.bo.sku.CreateProductSkuBo;
import com.ethan.domain.mall.product.interfaces.api.dto.SkuDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品SKU DTO转换器
 * @Date 2022/5/30
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductSkuDtoConvert {

    ProductSkuDtoConvert INSTANCE = Mappers.getMapper(ProductSkuDtoConvert.class);

    @Mappings({
        @Mapping(target = "spuId", ignore = true),
        @Mapping(target = "status", expression = "java(1)"),
        @Mapping(target = "picUrl", ignore = true)
    })
    List<CreateProductSkuBo> toBo(List<SkuDto> skus);
}
