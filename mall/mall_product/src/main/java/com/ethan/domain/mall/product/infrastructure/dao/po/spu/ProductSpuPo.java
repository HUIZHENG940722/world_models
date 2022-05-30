package com.ethan.domain.mall.product.infrastructure.dao.po.spu;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.sql.Date;

/**
 * @author zhenghui
 * @Description 商品SKU PO实体
 * @Date 2022/5/28
 */
@Data
public class ProductSpuPo {

    /**
     * SPU 编号
     */
    private Integer id;

    // ========== 基本信息 =========
    /**
     * SPU 名字
     */
    private String name;

    /**
     * 卖点
     */
    private String sellPoint;

    /**
     * 描述
     */
    private String description;

    /**
     * 分类编号
     */
    private Integer cid;

    /**
     * 商品主图地址
     *
     * 数组，以逗号分隔
     *
     * 建议尺寸：800*800像素，你可以拖拽图片调整顺序，最多上传15张
     */
    private String picUrls;

    // ========== 其他信息 =========
    /**
     * 是否上架商品（是否可见）。
     *
     * true 为已上架
     * false 为已下架
     */
    private Boolean visible;

    /**
     * 排序字段
     */
    private Integer sort;

    // ========== Sku 相关字段 =========
    /**
     * 价格
     *
     * 目前的计算方式是，以 Sku 最小价格为准
     */
    private Integer price;

    /**
     * 库存数量
     *
     * 目前的计算方式是，以 Sku 库存累加为准
     */
    private Integer quantity;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private Integer deleted;


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
