package com.ethan.domain.mall.product.interfaces.dto.sku;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author zWX1058539
 * @Description SKU DTO请求参数
 * @Date 2022/6/2
 */
@Data
public class SkuDto {

    /**
     * 规格值数组
     */
    @NotNull(message = "规格值数组不能为空")
    private List<Integer> attrValueIds;

    /**
     * 价格，单位：分
     */
    @NotNull(message = "价格不能为空")
    private Integer price;

    /**
     * 库存数量
     */
    @NotNull(message = "库存数量不能为空")
    private Integer quantity;
}
