package com.ethan.world.mall.product.domain.bo.spu;

import lombok.Data;

/**
 * @author zhenghui
 * @Description 分页查询商品SPU BO
 * @Date 2022/5/29
 */
@Data
public class PageQueryProductSpuBo {

    /**
     * SPU名字
     */
    private String name;

    /**
     * 商品分类编号
     */
    private Integer cid;

    /**
     * 是否可见
     */
    private Boolean visible;

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 页面尺寸
     */
    private Integer pageSize;
}
