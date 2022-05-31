package com.ethan.domain.mall.product.domain.bo.category;

import lombok.Data;

import java.util.Date;

/**
 * @author zhenghui
 * @Description 更新商品分类BO
 * @Date 2022/5/30
 */
@Data
public class UpdateProductCategoryBo {

    /**
     * 父分类编号
     */
    private Integer pid;

    /**
     * 分类名称
     */
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
    private Integer sort;

    /**
     * 状态：0->关闭;1->开启;
     */
    private Integer status;
}
