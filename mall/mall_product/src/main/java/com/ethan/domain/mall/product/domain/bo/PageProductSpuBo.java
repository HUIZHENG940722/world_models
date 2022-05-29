package com.ethan.domain.mall.product.domain.bo;

import lombok.Data;

import java.util.List;

/**
 * @author zhenghui
 * @name PageProductSpuRespBo
 * @Description 商品SPU分页数据BO
 * @Date 2022/5/29
 */
@Data
public class PageProductSpuBo {

    private Long total;

    private List<ProductSpuBo> data;
}
