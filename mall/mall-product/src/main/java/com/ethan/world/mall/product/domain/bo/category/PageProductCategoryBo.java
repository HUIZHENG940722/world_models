package com.ethan.world.mall.product.domain.bo.category;

import lombok.Data;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品分类内容BO
 * @Date 2022/6/5
 */
@Data
public class PageProductCategoryBo {

    private Integer total;

    private List<ContentProductCategoryBo> data;
}
