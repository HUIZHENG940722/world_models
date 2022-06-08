package com.ethan.world.mall.product.domain.bo.brand;

import com.ethan.world.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

/**
 * @author zhenghui
 * @Description 更新商品品牌BO
 * @Date 2022/5/31
 */
@Data
public class UpdateProductBrandBo {

    /**
     * 品牌名称
     */
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
    private StatusEnum status;
}
