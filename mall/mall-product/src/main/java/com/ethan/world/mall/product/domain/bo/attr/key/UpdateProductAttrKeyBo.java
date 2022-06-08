package com.ethan.world.mall.product.domain.bo.attr.key;

import com.ethan.world.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

/**
 * @author zhenghui
 * @Description 更新商品规格键
 * @Date 2022/6/1
 */
@Data
public class UpdateProductAttrKeyBo {

    /**
     * 规格键名称
     */
    private String name;

    /**
     * 状态
     */
    private StatusEnum status;
}
