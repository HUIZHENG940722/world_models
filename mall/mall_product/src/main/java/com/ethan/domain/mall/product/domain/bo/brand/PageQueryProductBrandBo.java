package com.ethan.domain.mall.product.domain.bo.brand;

import lombok.Data;

/**
 * @author zhenghui
 * @Description 分页查询商品品牌BO
 * @Date 2022/6/4
 */
@Data
public class PageQueryProductBrandBo {

    private Integer pageNo;

    private Integer pageSize;

    /**
     * 品牌id
     */
    private String id;

    /**
     * 商品品牌名称
     */
    private String name;

    /**
     * 状态：0->关闭;1->开启;
     */
    private Integer status;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private Integer deleted;


}
