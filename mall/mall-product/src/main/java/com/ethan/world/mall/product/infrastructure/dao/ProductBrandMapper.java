package com.ethan.world.mall.product.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.world.mall.product.infrastructure.dao.po.brand.ProductBrandPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zWX1058539
 * @Description 商品品牌数据访问层
 * @Date 2022/5/30
 */
@Mapper
public interface ProductBrandMapper extends BaseMapper<ProductBrandPo> {
}
