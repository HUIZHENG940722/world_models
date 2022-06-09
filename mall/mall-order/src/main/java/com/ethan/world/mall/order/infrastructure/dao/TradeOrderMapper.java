package com.ethan.world.mall.order.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.world.mall.order.infrastructure.dao.po.order.TradeOrderPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zWX1058539
 * @Description 交易订单数据访问接口
 * @Date 2022/6/9
 */
@Mapper
public interface TradeOrderMapper extends BaseMapper<TradeOrderPo> {

}
