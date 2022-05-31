package com.ethan.domain.mall.product.domain.bo.spu;

import lombok.Data;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 更新商品SPU BO
 * @Date 2022/5/31
 */
@Data
public class UpdateProductSpuBo {

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
}
