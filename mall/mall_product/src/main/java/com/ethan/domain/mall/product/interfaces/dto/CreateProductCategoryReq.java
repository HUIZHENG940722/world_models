package com.ethan.domain.mall.product.interfaces.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhenghui
 * @Description 创建商品分类请求DTO
 * @Date 2022/5/29
 */
@Data
public class CreateProductCategoryReq {

    /**
     * 父分类编码
     */
    @NotNull(message = "父分类编码不能为空")
    private Integer pid;

    /**
     * 分类名称
     */
    @NotBlank(message = "分类名称不能为空")
    private String name;

    /**
     * 分类描述
     */
    private String description;

    /**
     * 分类图片
     */
    private String picUrl;

    /**
     * 分类排序
     */
    @NotNull(message = "分类排序不能为空")
    private Integer sort;

    /**
     * 分类状态
     */
    @NotNull(message = "状态不能为空")
    private Integer status;
}
