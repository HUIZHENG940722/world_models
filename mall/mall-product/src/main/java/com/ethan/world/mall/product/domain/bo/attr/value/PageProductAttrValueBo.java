package com.ethan.world.mall.product.domain.bo.attr.value;

import lombok.Data;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品规格值分页BO
 * @Date 2022/6/8
 */
@Data
public class PageProductAttrValueBo {

    private Integer total;

    private List<ContentProductAttrValueBo> data;
}
