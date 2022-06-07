package com.ethan.domain.mall.product.domain.bo.attr.value;

import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

/**
 * @author zhenghui
 * @Description 更新商品规格值Bo
 * @Date 2022/6/2
 */
@Data
public class UpdateProductAttrValueBo {

    /**
     * 规格键编号
     */
    private Integer attrKeyId;

    /**
     * 规格值名字
     */
    private String name;

    /**
     * 状态
     */
    private StatusEnum status;
}
