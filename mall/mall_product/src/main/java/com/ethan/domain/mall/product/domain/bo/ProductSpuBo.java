package com.ethan.domain.mall.product.domain.bo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author zhenghui
 * @name ProductSpuBo
 * @Description 商品SPU BO
 * @Date 2022/5/28
 */
@Data
public class ProductSpuBo {

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
     * 创建时间
     */
    private Date createTime;
}
