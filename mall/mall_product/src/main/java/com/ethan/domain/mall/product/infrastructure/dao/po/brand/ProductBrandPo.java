package com.ethan.domain.mall.product.infrastructure.dao.po.brand;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author zWX1058539
 * @Description 商品品牌PO
 * @Date 2022/5/30
 */
@Data
@TableName(value = "product_brand")
public class ProductBrandPo {
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
    private Integer status;
}
