package com.ethan.domain.mall.product.interfaces.dto.brand;

import lombok.Data;

import java.util.List;

/**
 * @author zhenghui
 * @Description 分页商品品牌响应DTO
 * @Date 2022/6/4
 */
@Data
public class PageProductBrandResp {

    private Integer total;

    private List<ContentProductBrandResp> data;
}
