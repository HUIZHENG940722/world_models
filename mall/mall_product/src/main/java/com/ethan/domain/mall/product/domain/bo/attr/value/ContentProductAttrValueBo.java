package com.ethan.domain.mall.product.domain.bo.attr.value;

import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

/**
 * @author zhenghui
 * @Description 商品规格值内容BO
 * @Date 2022/6/1
 */
@Data
public class ContentProductAttrValueBo {

    /**
     * 规格值编号
     */
    private Integer id;

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
