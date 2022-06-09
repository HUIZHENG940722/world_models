package com.ethan.world.mall.order.infrastructure.dao.po.cart;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 购物车的商品信息
 * @Date 2022/6/9
 */
@Data
@TableName(value = "cart_product")
public class CartProductPo {

    /**
     * 编码
     */
    private Integer id;

    /**
     * 是否选中
     */
    private Boolean selected;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 商品SPU编码
     */
    private Integer spuId;

    /**
     * 商品SKU编码
     */
    private Integer skuId;

    /**
     * 商品购买数量
     */
    private Integer quantity;

    /**
     * 是否删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date updateTime;

}
