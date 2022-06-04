package com.ethan.domain.mall.product.domain.bo.brand;

import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 商品品牌BO
 * @Date 2022/5/30
 */
@Data
public class CreateProductBrandBo {

    /**
     * 商品品牌名称
     */
    private String name;

    /**
     * 商品品牌描述
     */
    private String description;

    /**
     * 商品品牌图片
     */
    private String picUrl;
}
