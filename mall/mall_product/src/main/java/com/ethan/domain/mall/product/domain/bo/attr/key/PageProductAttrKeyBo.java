package com.ethan.domain.mall.product.domain.bo.attr.key;

import lombok.Data;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 商品规格键内容分页BO
 * @Date 2022/6/8
 */
@Data
public class PageProductAttrKeyBo {

    private Integer total;

    private List<ContentProductAttrKeyBo> data;
}
