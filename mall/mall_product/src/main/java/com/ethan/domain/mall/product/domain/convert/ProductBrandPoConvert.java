package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.brand.ContentProductBrandBo;
import com.ethan.domain.mall.product.domain.bo.brand.CreateProductBrandBo;
import com.ethan.domain.mall.product.domain.bo.brand.UpdateProductBrandBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.brand.ProductBrandPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品品牌PO转换器
 * @Date 2022/5/30
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductBrandPoConvert {
    ProductBrandPoConvert INSTANCE = Mappers.getMapper(ProductBrandPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "status", expression = "java(1)"),
        @Mapping(target = "deleted", expression = "java(1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductBrandPo createBotoPo(CreateProductBrandBo createProductBrandBo);

    ContentProductBrandBo toContentBo(ProductBrandPo selectById);

    List<ContentProductBrandBo> toContentBo(List<ProductBrandPo> productBrandPoList);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "deleted", ignore = true),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductBrandPo updateBotoPo(UpdateProductBrandBo updateProductBrandBo);
}
