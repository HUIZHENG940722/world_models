package com.ethan.domain.mall.product.domain.convert;

import cn.hutool.core.util.StrUtil;
import com.ethan.domain.mall.product.domain.bo.sku.CreateProductSkuBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.sku.ProductSkuPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品SKU PO转换器
 * @Date 2022/5/30
 */
@Mapper
public interface ProductSkuPoConvert {
    ProductSkuPoConvert INSTANCE = Mappers.getMapper(ProductSkuPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "attrs", source = "attrValueIds", qualifiedByName = "translateAttrValueIdsFromList"),
        @Mapping(target = "deleted", expression = "java(1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")

    })
    ProductSkuPo createBoToPo(CreateProductSkuBo createProductSkuBo);

    List<ProductSkuPo> CreateListBoToPo(List<CreateProductSkuBo> createProductSkuBoList);

    @Named("translateAttrValueIdsFromList")
    default String translateAttrValueIdsFromList(List<Integer> attrValueIds) {
        return StrUtil.join(",", attrValueIds);
    }
}
