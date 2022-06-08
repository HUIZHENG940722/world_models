package com.ethan.world.mall.product.interfaces.assembler;

import com.ethan.world.mall.product.domain.bo.spu.CreateProductSpuBo;
import com.ethan.world.mall.product.interfaces.api.dto.CreateProductSpuAndSkuReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @Author zWX1058539
 * @Description 商品SPU DTO转换器
 * @Date 2022/5/30
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductSpuDtoConvert {

    ProductSpuDtoConvert INSTANCE = Mappers.getMapper(ProductSpuDtoConvert.class);


    @Mappings({
        @Mapping(target = "price", ignore = true),
        @Mapping(target = "sort", ignore = true),
        @Mapping(target = "quantity", ignore = true)
    })
    CreateProductSpuBo toBo(CreateProductSpuAndSkuReq createProductSpuAndSkuReq);
}
