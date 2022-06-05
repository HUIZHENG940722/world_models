package com.ethan.domain.mall.product.interfaces.dto.attr;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zhenghui
 * @Description 更新商品规格键请求DTO
 * @Date 2022/6/5
 */
@Data
public class UpdateProductAttrKeyReq {

    /**
     * 规格键名称
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;
}
