package com.ethan.domain.mall.product.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.sku.ProductSkuPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zWX1058539
 * @Description 商品SKU数据访问接口
 * @Date 2022/5/30
 */
@Mapper
public interface ProductSkuMapper extends BaseMapper<ProductSkuPo> {
}
