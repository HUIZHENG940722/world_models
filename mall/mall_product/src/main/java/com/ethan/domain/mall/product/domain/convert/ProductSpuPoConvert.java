package com.ethan.domain.mall.product.domain.convert;

import cn.hutool.core.util.StrUtil;
import com.ethan.domain.mall.product.domain.bo.spu.ContentProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.CreateProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.DetailsProductSpuBo;
import com.ethan.domain.mall.product.domain.bo.spu.UpdateProductSpuBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.spu.ProductSpuPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品SPU PO转换器
 * @Date 2022/5/29
 */
@Mapper
public interface ProductSpuPoConvert {

    ProductSpuPoConvert INSTANCE = Mappers.getMapper(ProductSpuPoConvert.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "picUrls", target = "picUrls", qualifiedByName = "translatePicUrlsFromList"),
        @Mapping(target = "deleted", expression = "java(1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductSpuPo createBoToPo(CreateProductSpuBo createProductSpuBo);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "picUrls", target = "picUrls", qualifiedByName = "translatePicUrlsFromList"),
        @Mapping(target = "deleted", ignore = true),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    ProductSpuPo updateBoToPo(UpdateProductSpuBo updateProductSpuBo);

    @Mappings({
        @Mapping(source = "picUrls", target = "picUrls", qualifiedByName = "translatePicUrlsFromString")
    })
    ContentProductSpuBo toContentBo(ProductSpuPo selectOne);

    @Mappings({
        @Mapping(source = "picUrls", target = "picUrls", qualifiedByName = "translatePicUrlsFromString")
    })
    DetailsProductSpuBo toDetailsBo(ProductSpuPo selectOne);

    List<DetailsProductSpuBo> toDetailsBo(List<ProductSpuPo> productSpuPoList);

    @Named("translatePicUrlsFromList")
    default String translatePicUrlsFromList(List<String> picUrls) {
        return StrUtil.join(",", picUrls);
    }

    @Named("translatePicUrlsFromString")
    default List<String> translatePicUrlsFromString(String picUrls) {
        char separator = ',';
        return List.of(StrUtil.splitToArray(picUrls, separator));
    }
}
