package com.ethan.world.mall.product.domain.bo.spu;

import com.ethan.world.mall.product.infrastructure.dao.enums.DeletedEnum;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品SPU详情
 * @Date 2022/5/31
 */
@Data
public class DetailsProductSpuBo {

    /**
     * 商品 SPU 编号
     */
    private Integer id;

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
     */
    private List<String> picUrls;

    /**
     * 是否上架商品
     */
    private Boolean visible;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 库存数量
     */
    private Integer quantity;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private DeletedEnum deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
