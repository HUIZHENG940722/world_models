package com.ethan.domain.mall.product.domain.convert;

import cn.hutool.core.util.StrUtil;
import com.ethan.domain.mall.product.domain.bo.spu.ProductSpuBo;
import com.ethan.domain.mall.product.infrastructure.dao.po.spu.ProductSpuPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Annotation;
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
            @Mapping(source = "picUrls", target = "picUrls", qualifiedByName = "translatePicUrlsFromList")
    })
    ProductSpuPo toPo(ProductSpuBo productSpuBo);

    @Mappings({
            @Mapping(source = "picUrls", target = "picUrls", qualifiedByName = "translatePicUrlsFromString")
    })
    ProductSpuBo toBo(ProductSpuPo productSpuPo);

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
