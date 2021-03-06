package com.ethan.world.mall.product.interfaces.assembler;

import com.ethan.world.mall.product.domain.bo.brand.*;
import com.ethan.world.mall.product.interfaces.api.dto.*;
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

    UpdateProductBrandBo toBo(UpdateProductBrandReq updateProductBrandReq);

    PageQueryProductBrandBo toBo(PageQueryProductBrandReq pageQueryProductBrandReq);

    ContentProductBrandResp toContentVo(ContentProductBrandBo contentProductBrandBo);

    PageProductBrandResp toContentVo(PageProductBrandBo pageProductBrandBo);
}
