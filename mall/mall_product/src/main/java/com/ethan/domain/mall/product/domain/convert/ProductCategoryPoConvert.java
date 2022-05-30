package com.ethan.domain.mall.product.domain.convert;

import com.ethan.domain.mall.product.domain.bo.category.ContentProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.CreateProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.UpdateProductCategoryBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.category.ProductCategoryPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品分类PO转换器
 * @Date 2022/5/29
 */
@Mapper
public interface ProductCategoryPoConvert {
    ProductCategoryPoConvert INSTANCE = Mappers.getMapper(ProductCategoryPoConvert.class);

    CreateProductCategoryBo toCreateBo(ProductCategoryPo selectById);

    @Mappings({
            @Mapping(target = "createTime", defaultExpression = "java(new java.util.Date(System.currentTimeMillis()))"),
            @Mapping(target = "updateTime", defaultExpression = "java(new java.util.Date(System.currentTimeMillis()))"),
            @Mapping(target = "id", ignore = true)
    })
    ProductCategoryPo createBoToPo(CreateProductCategoryBo createProductCategoryBo);

    ContentProductCategoryBo toDetailsBo(ProductCategoryPo selectOne);

    ProductCategoryPo updateBotoPo(UpdateProductCategoryBo updateProductCategoryBo);

    List<ContentProductCategoryBo> toDetailsListBo(List<ProductCategoryPo> selectList);
}
