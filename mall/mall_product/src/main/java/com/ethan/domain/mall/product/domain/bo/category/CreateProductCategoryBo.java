package com.ethan.domain.mall.product.domain.bo.category;

import lombok.Data;

import java.util.Date;


/**
 * @author zhenghui
 * @Description 创建商品分类BO
 * @Date 2022/5/29
 */
@Data
public class CreateProductCategoryBo {

    /**
     * 商品分类父编码
     */
    private Integer pid;

    /**
     * 商品分类名称
     */
    private String name;

    /**
     * 商品分类描述
     */
    private String description;

    /**
     * 商品分类图片
     */
    private String picUrl;

    /**
     * 商品分类排序
     */
    private Integer sort;
}
