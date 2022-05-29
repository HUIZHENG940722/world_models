package com.ethan.domain.mall.product.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.category.ProductCategoryPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhenghui
 * @Description 商品分类数据访问层
 * @Date 2022/5/29
 */
@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategoryPo> {
}
