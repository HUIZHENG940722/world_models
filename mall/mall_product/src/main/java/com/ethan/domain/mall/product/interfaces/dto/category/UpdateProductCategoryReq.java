package com.ethan.domain.mall.product.interfaces.dto.category;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author zhenghui
 * @Description 更新商品分类DTO
 * @Date 2022/5/30
 */
@Data
public class UpdateProductCategoryReq {

    /**
     * 父分类编号
     */
    @NotNull(message = "父分类编号不能为空")
    private Integer pid;
    /**
     * 分类名称
     */
    @NotEmpty(message = "分类名称不能为空")
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
