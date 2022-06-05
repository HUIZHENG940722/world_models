package com.ethan.domain.mall.product.interfaces.dto.category;

import lombok.Data;

import java.util.List;

/**
 * @author zhenghui
 * @Description 分页商品分类响应内容DTO
 * @Date 2022/6/5
 */
@Data
public class PageProductCategoryResp {
    private Integer total;

    private List<ContentProductCategoryResp> data;
}
