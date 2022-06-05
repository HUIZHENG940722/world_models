package com.ethan.domain.mall.product.interfaces.dto.category;

import lombok.Data;

/**
 * @author zhenghui
 * @Description 分页查询商品分类内容请求DTO
 * @Date 2022/6/5
 */
@Data
public class PageQueryProductCategoryReq {

    private Integer pageNo;

    private Integer pageSize;

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
     * 状态：0->关闭;1->开启;
     */
    private Integer status;
}
