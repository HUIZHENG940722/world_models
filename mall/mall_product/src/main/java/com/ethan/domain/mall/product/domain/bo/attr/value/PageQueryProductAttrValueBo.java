package com.ethan.domain.mall.product.domain.bo.attr.value;

import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

/**
 * @Author zWX1058539
 * @Description 分页查询商品规格值BO
 * @Date 2022/6/8
 */
@Data
public class PageQueryProductAttrValueBo {

    private Integer pageNo;

    private Integer pageSize;

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
