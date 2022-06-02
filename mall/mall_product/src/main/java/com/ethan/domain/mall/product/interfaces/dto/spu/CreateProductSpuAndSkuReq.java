package com.ethan.domain.mall.product.interfaces.dto.spu;

import com.ethan.domain.mall.product.interfaces.dto.sku.SkuDto;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author zWX1058539
 * @Description 创建商品SPU和SKU列表的请求DTO
 * @Date 2022/6/1
 */
@Data
public class CreateProductSpuAndSkuReq {

    /**
     * SPU名称
     */
    @NotEmpty(message = "SPU名字不能为空")
    private String name;

    /**
     * 卖点
     */
    @NotEmpty(message = "卖点不能为空")
    private String sellPoint;

    /**
     * 描述
     */
    @NotEmpty(message = "描述不能为空")
    private String description;

    /**
     * 分类编号
     */
    @NotNull(message = "分类编号不能为空")
    private Integer cid;

    /**
     * 商品主图地址
     */
    @NotEmpty(message = "商品主图地址不能为空")
    private List<String> picUrls;

    /**
     * 是否上架
     */
    @NotNull(message = "是否上架商品不能为空")
    private Boolean visible;

    /**
     * SKU数组
     */
    @NotNull(message = "SKU不能为空")
    @Valid
    private List<SkuDto> skus;

}
