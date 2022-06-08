package com.ethan.world.mall.product.domain.bo.sku;

import com.ethan.world.mall.product.domain.bo.spu.CreateProductSpuBo;
import lombok.Data;

import java.util.List;

/**
 * @Author zWX1058539
 * @Description 创建商品SPU及SKU列表BO
 * @Date 2022/6/2
 */
@Data
public class CreateProductSpuAndSkuBo {

    private CreateProductSpuBo createProductSpuBo;

    private List<CreateProductSkuBo> createProductSkuBoList;
}
