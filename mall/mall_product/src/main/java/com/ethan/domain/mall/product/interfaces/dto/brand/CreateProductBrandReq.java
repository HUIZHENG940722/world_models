package com.ethan.domain.mall.product.interfaces.dto.brand;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author zWX1058539
 * @Description 创建商品品牌请求DTO
 * @Date 2022/5/30
 */
@Data
public class CreateProductBrandReq {

    /**
     * 品牌名称
     */
    @NotEmpty(message = "品牌名称不能为空")
    private String name;

    /**
     * 品牌描述
     */
    private String description;

    /**
     * 品牌名图片
     */
    private String picUrl;
}
