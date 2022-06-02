package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductSpuService;
import com.ethan.domain.mall.product.domain.bo.sku.CreateProductSkuBo;
import com.ethan.domain.mall.product.domain.bo.sku.CreateProductSpuAndSkuBo;
import com.ethan.domain.mall.product.domain.bo.spu.CreateProductSpuBo;
import com.ethan.domain.mall.product.infrastructure.api.CommonResult;
import com.ethan.domain.mall.product.interfaces.assembler.ProductSkuDtoConvert;
import com.ethan.domain.mall.product.interfaces.assembler.ProductSpuDtoConvert;
import com.ethan.domain.mall.product.interfaces.dto.spu.CreateProductSpuAndSkuReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public CommonResult<Integer> createProductSpu(@Validated @RequestBody CreateProductSpuAndSkuReq createProductSpuAndSkuReq) {
        // 1 数据转换
        // 2.1.1 初始化创建SKU列表数据
        List<CreateProductSkuBo> createProductSkuBoList = ProductSkuDtoConvert.INSTANCE.toBo(createProductSpuAndSkuReq.getSkus());
        // 2.1.2 初始化创建商品SPU列表数据
        CreateProductSpuBo createProductSpuBo = ProductSpuDtoConvert.INSTANCE.toBo(createProductSpuAndSkuReq);
        CreateProductSpuAndSkuBo createProductSpuAndSkuBo = new CreateProductSpuAndSkuBo();
        createProductSpuAndSkuBo.setCreateProductSpuBo(createProductSpuBo);
        createProductSpuAndSkuBo.setCreateProductSkuBoList(createProductSkuBoList);
        // 2 业务逻辑
        int create = productSpuService.createProductSpu(createProductSpuAndSkuBo);
        // 3 返回结果
        return CommonResult.success(200, "创建商品SPU集SKU列表成功", create);
    }
}
