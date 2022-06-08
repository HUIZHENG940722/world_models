package com.ethan.world.mall.product.domain.bo.spu;

import lombok.Data;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品SPU分页数据BO
 * @Date 2022/5/29
 */
@Data
public class PageDetailsProductSpuBo {

    private Long total;

    private List<DetailsProductSpuBo> data;
}
