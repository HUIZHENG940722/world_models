package com.ethan.world.mall.product.infrastructure.dao.po.sku;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ethan.world.mall.product.infrastructure.dao.enums.DeletedEnum;
import com.ethan.world.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 商品SKU PO
 * @Date 2022/5/30
 */
@Data
@TableName(value = "product_sku")
public class ProductSkuPo {

    /**
     * sku 编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编号
     */
    private Integer spuId;


    /**
     * 图片地址
     */
    private Integer picUrl;

    /**
     * 数组，以逗号分隔
     */
    private String attrs;

    /**
     * 价格，单位：分
     */
    private Integer price;

    /**
     * 库存数量
     */
    private Integer quantity;

    /**
     * 状态：0->关闭;1->开启;
     */
    private StatusEnum status;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private DeletedEnum deleted;

    /**
     * 创建时间
     */
    @TableField(updateStrategy = FieldStrategy.NEVER, insertStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(updateStrategy = FieldStrategy.NOT_NULL, insertStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;
}
