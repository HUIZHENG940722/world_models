package com.ethan.domain.mall.product.domain.bo.category;

import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

/**
 * @author zhenghui
 * @Description 商品分类分页查询BO
 * @Date 2022/6/5
 */
@Data
public class PageQueryProductCategoryBo {

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
    private StatusEnum status;

}
