package com.ethan.domain.mall.product.domain.bo.brand;

import com.ethan.domain.mall.product.infrastructure.dao.enums.DeletedEnum;
import com.ethan.domain.mall.product.infrastructure.dao.enums.StatusEnum;
import lombok.Data;

/**
 * @author zhenghui
 * @Description 分页查询商品品牌BO
 * @Date 2022/6/4
 */
@Data
public class PageQueryProductBrandBo {

    private Integer pageNo;

    private Integer pageSize;

    /**
     * 品牌id
     */
    private String id;

    /**
     * 商品品牌名称
     */
    private String name;

    /**
     * 状态：0->关闭;1->开启;
     */
    private StatusEnum status;
}
