package com.ethan.world.mall.product.domain.bo.category;

import com.ethan.world.mall.product.infrastructure.dao.enums.DeletedEnum;
import com.ethan.world.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 商品分类详情BO
 * @Date 2022/5/30
 */
@Data
public class ContentProductCategoryBo {

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
    private StatusEnum status;

    /**
     * 是否被删除：0->已删除;1->未删除;
     */
    private DeletedEnum deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
