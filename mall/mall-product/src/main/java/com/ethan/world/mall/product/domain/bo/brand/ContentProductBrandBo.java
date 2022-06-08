package com.ethan.world.mall.product.domain.bo.brand;

import com.ethan.world.mall.product.infrastructure.dao.enums.DeletedEnum;
import com.ethan.world.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author zhenghui
 * @Description 商品内容BO
 * @Date 2022/5/31
 */
@Data
public class ContentProductBrandBo {

    /**
     * 品牌id
     */
    private String id;

    /**
     * 商品品牌名称
     */
    private String name;

    /**
     * 商品品牌描述
     */
    private String description;

    /**
     * 商品品牌图片
     */
    private String picUrl;

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
