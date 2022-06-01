package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductSpuService;
import com.ethan.domain.mall.product.infrastructure.api.CommonResult;
import com.ethan.domain.mall.product.interfaces.dto.spu.CreateProductSpuAndSkuReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenghui
 * @Description 商品SPU用户接口层
 * @Date 2022/5/28
 */
@RestController
@RequestMapping(value = "/product/spu")
public class ProductSpuController {

    @Autowired
    private ProductSpuService productSpuService;

    /**
     * 用户接口：创建商品spu
     * @param createProductSpuAndSkuReq
     * @return
     */
    @PostMapping(value = "")
    public CommonResult<Boolean> createProductSpu(CreateProductSpuAndSkuReq createProductSpuAndSkuReq) {
        // 1 数据转换
        // 2 业务逻辑
        int create = productSpuService.createProductSpu(createProductSpuAndSkuReq);
        // 3 返回结果
        return CommonResult.success(200, "创建商品SPU集SKU列表成功", create);
    }
}
