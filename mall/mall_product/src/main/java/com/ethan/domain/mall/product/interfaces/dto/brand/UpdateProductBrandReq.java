package com.ethan.domain.mall.product.interfaces.dto.brand;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author zhenghui
 * @Description 更新商品品牌DTO
 * @Date 2022/6/4
 */
@Data
public class UpdateProductBrandReq {

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

    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private Integer status;
}
