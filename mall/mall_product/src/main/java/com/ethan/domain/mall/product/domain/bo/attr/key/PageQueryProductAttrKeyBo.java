package com.ethan.domain.mall.product.domain.bo.attr.key;

import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

/**
 * @Author zWX1058539
 * @Description 分页查询商品规格键BO
 * @Date 2022/6/8
 */
@Data
public class PageQueryProductAttrKeyBo {

    private Integer pageNo;

    private Integer pageSize;

    /**
     * 规格键名称
     */
    private String name;

    /**
     * 状态
     */
    private StatusEnum status;
}
