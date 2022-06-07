package com.ethan.domain.mall.product.domain.bo.attr.key;

import com.ethan.domain.mall.product.infrastructure.dao.enums.DeletedEnum;
import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author zWX1058539
 * @Description 规格键内容BO
 * @Date 2022/6/1
 */
@Data
public class ContentProductAttrKeyBo {

    /**
     * 规格键编号
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态：0->禁用;1->启用;
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
