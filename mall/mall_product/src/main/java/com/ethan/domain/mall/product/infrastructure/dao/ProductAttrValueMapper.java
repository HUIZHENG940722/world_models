package com.ethan.domain.mall.product.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.attr.ProductAttrValuePo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zWX1058539
 * @Description 商品规格值数据访问接口
 * @Date 2022/6/1
 */
@Mapper
public interface ProductAttrValueMapper extends BaseMapper<ProductAttrValuePo> {
}
