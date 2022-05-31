package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductBrandService;
import com.ethan.domain.mall.product.domain.bo.brand.CreateProductBrandBo;
import com.ethan.domain.mall.product.infrastructure.api.CommonResult;
import com.ethan.domain.mall.product.interfaces.assembler.ProductBrandDtoConvert;
import com.ethan.domain.mall.product.interfaces.dto.brand.CreateProductBrandReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zWX1058539
 * @Description 商品品牌用户接口
 * @Date 2022/5/30
 */
@RequestMapping(value = "/product/brand")
@RestController
public class ProductBrandController {

    @Autowired
    private ProductBrandService productBrandService;

    /**
     * 用户接口：创建商品品牌
     * @param createProductBrandReq
     * @return
     */
    @PostMapping(value = "")
    public CommonResult<Integer> createProductBrand(@Validated @RequestBody CreateProductBrandReq createProductBrandReq) {
        // 1 数据转换
        CreateProductBrandBo createProductBrandBo = ProductBrandDtoConvert.INSTANCE.toBo(createProductBrandReq);
        // 2 业务
        int create = productBrandService.createProductBrand(createProductBrandBo);
        // 3 返回结果
        return CommonResult.success(200, "创建商品品牌成功", create);
    }
}
