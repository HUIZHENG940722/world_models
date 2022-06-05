package com.ethan.domain.mall.product.interfaces.dto.category;

import lombok.Data;

import java.util.Date;

/**
 * @author zhenghui
 * @Description 商品分类内容响应DTO
 * @Date 2022/6/5
 */
@Data
public class ContentProductCategoryResp {

    /**
     * 商品分类编码
     */
    private Integer id;

    /**
     * 商品分类父编码
     */
    private Integer pid;

    /**
     * 商品分类名称
     */
    private String name;

    /**
     * 商品分类描述
     */
    private String description;

    /**
     * 商品分类图片
     */
    private String picUrl;

    /**
     * 商品分类排序
     */
    private Integer sort;

    /**
     * 状态：0->关闭;1->开启;
     */
    private Integer status;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
