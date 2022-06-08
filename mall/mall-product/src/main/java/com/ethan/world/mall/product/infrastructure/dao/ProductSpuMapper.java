package com.ethan.world.mall.product.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.world.mall.product.infrastructure.dao.po.spu.ProductSpuPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhenghui
 * @Description 商品SPU数据访问层
 * @Date 2022/5/28
 */
@Mapper
public interface ProductSpuMapper extends BaseMapper<ProductSpuPo> {
}
