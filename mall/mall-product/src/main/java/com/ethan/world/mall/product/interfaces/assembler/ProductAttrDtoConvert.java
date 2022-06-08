package com.ethan.world.mall.product.interfaces.assembler;

import com.ethan.world.mall.product.domain.bo.attr.key.ContentProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.key.PageProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.key.PageQueryProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
import com.ethan.world.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.world.mall.product.domain.bo.attr.value.CreateProductAttrValueBo;
import com.ethan.world.mall.product.domain.bo.attr.value.PageProductAttrValueBo;
import com.ethan.world.mall.product.domain.bo.attr.value.PageQueryProductAttrValueBo;
import com.ethan.world.mall.product.domain.bo.attr.value.UpdateProductAttrValueBo;
import com.ethan.world.mall.product.interfaces.api.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @Author zWX1058539
 * @Description 商品规格DTO转换器
 * @Date 2022/6/2
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductAttrDtoConvert {

    ProductAttrDtoConvert INSTANCE = Mappers.getMapper(ProductAttrDtoConvert.class);


    CreateProductAttrKeyBo toBo(CreateProductAttrKeyReq createProductAttrKeyReq);


    UpdateProductAttrKeyBo toBo(UpdateProductAttrKeyReq updateProductAttrKeyReq);

    ContentProductAttrKeyResp toContentResp(ContentProductAttrKeyBo productAttrKey);

    PageQueryProductAttrKeyBo toBo(PageQueryProductAttrKeyReq pageQueryProductAttrKeyReq);

    PageProductAttrKeyResp toPageResp(PageProductAttrKeyBo pageProductAttrKeyBo);

    CreateProductAttrValueBo toBo(CreateProductAttrValueReq createProductAttrValueReq);

    ContentProductAttrValueResp toContentResp(ContentProductAttrValueBo productAttrValue);

    PageQueryProductAttrValueBo toBo(PageQueryProductAttrValueReq pageQueryProductAttrValueReq);

    PageProductAttrValueResp toPageResp(PageProductAttrValueBo pageProductAttrValueBo);

    UpdateProductAttrValueBo toBo(UpdateProductAttrValueReq updateProductAttrValueReq);
}
