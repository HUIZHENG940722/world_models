package com.ethan.world.mall.product.infrastructure.dao.po.attr;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ethan.world.mall.product.infrastructure.dao.enums.DeletedEnum;
import com.ethan.world.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 商品规格键PO
 * @Date 2022/6/1
 */
@Data
@TableName(value = "product_attr_key")
public class ProductAttrKeyPo implements Serializable {

    /**
     * 规格键编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态：0->禁用;1->启用;
     */
    private StatusEnum status;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private DeletedEnum deleted;

    /**
     * 创建时间
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;
}
