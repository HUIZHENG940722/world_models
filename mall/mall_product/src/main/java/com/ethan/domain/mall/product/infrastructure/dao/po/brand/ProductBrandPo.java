package com.ethan.domain.mall.product.infrastructure.dao.po.brand;

import com.baomidou.mybatisplus.annotation.*;
import com.ethan.domain.mall.product.infrastructure.dao.enums.DeletedEnum;
import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 商品品牌PO
 * @Date 2022/5/30
 */
@Data
@TableName(value = "product_brand")
public class ProductBrandPo implements Serializable {
    /**
     * 品牌编号（主键）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌描述
     */
    private String description;

    /**
     * 品牌名图片
     */
    private String picUrl;

    /**
     * 状态
     */
    @EnumValue
    private StatusEnum status;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    @EnumValue
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
