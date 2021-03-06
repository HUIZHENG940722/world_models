package com.ethan.world.mall.product.domain.bo.brand;

import lombok.Data;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品品牌分页数据BO
 * @Date 2022/6/4
 */
@Data
public class PageProductBrandBo {

    private Integer total;

    private List<ContentProductBrandBo> data;
}
