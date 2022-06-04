package com.ethan.domain.mall.product.interfaces.assembler;

import com.ethan.domain.mall.product.domain.bo.category.UpdateProductCategoryBo;
import com.ethan.domain.mall.product.interfaces.dto.category.CreateProductCategoryReq;
import com.ethan.domain.mall.product.domain.bo.category.CreateProductCategoryBo;
import com.ethan.domain.mall.product.interfaces.dto.category.UpdateProductCategoryReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author zhenghui
 * @Description 商品分类DTO转换器
 * @Date 2022/5/29
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCategoryDtoConvert {
    ProductCategoryDtoConvert INSTANCE = Mappers.getMapper(ProductCategoryDtoConvert.class);

    CreateProductCategoryBo toBo(CreateProductCategoryReq createProductCategoryReq);

    UpdateProductCategoryBo toBo(UpdateProductCategoryReq updateProductCategoryReq);
}
