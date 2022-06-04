package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.category.ContentProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.CreateProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.UpdateProductCategoryBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.category.ProductCategoryPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品分类PO转换器
 * @Date 2022/5/29
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductCategoryPoConvert {
    ProductCategoryPoConvert INSTANCE = Mappers.getMapper(ProductCategoryPoConvert.class);

    CreateProductCategoryBo toCreateBo(ProductCategoryPo selectById);

    @Mappings({
        @Mapping(target = "deleted", expression = "java(1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "id", ignore = true)
    })
    ProductCategoryPo createBoToPo(CreateProductCategoryBo createProductCategoryBo);

    ContentProductCategoryBo toDetailsBo(ProductCategoryPo selectOne);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "deleted", ignore = true),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
    })
    ProductCategoryPo updateBotoPo(UpdateProductCategoryBo updateProductCategoryBo);

    List<ContentProductCategoryBo> toDetailsListBo(List<ProductCategoryPo> selectList);
}
