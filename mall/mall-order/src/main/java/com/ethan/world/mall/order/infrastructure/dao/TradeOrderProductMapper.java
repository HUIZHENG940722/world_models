package com.ethan.world.mall.order.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderProductItemPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zWX1058539
 * @Description 交易订单商品数据访问层
 * @Date 2022/6/10
 */
@Mapper
public interface TradeOrderProductMapper extends BaseMapper<TradeOrderProductItemPo> {
}
