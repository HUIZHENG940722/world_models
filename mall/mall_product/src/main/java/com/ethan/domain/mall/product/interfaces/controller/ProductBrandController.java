package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductBrandService;
import com.ethan.domain.mall.product.domain.bo.brand.ContentProductBrandBo;
import com.ethan.domain.mall.product.domain.bo.brand.CreateProductBrandBo;
import com.ethan.domain.mall.product.domain.bo.brand.UpdateProductBrandBo;
import com.ethan.domain.mall.product.infrastructure.api.CommonResult;
import com.ethan.domain.mall.product.interfaces.assembler.ProductBrandDtoConvert;
import com.ethan.domain.mall.product.interfaces.dto.brand.ContentProductBrandResp;
import com.ethan.domain.mall.product.interfaces.dto.brand.CreateProductBrandReq;
import com.ethan.domain.mall.product.interfaces.dto.brand.UpdateProductBrandReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     *
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

    /**
     * 用户接口：更新商品品牌
     *
     * @param brandId
     * @param updateProductBrandReq
     * @return
     */
    @PutMapping(value = "/{brand_id}")
    public CommonResult<Integer> updateProductBrand(
        @PathVariable(value = "brand_id") Integer brandId,
        @Validated @RequestBody UpdateProductBrandReq updateProductBrandReq) {
        // 1 数据转换
        UpdateProductBrandBo updateProductBrandBo = ProductBrandDtoConvert.INSTANCE.toBo(updateProductBrandReq);
        // 2 业务
        int update = productBrandService.updateProductBrand(brandId, updateProductBrandBo);
        // 3 返回结果
        return CommonResult.success(200, "更新商品品牌成功", update);
    }

    /**
     * 用户接口：获取品牌内容
     *
     * @param brandId
     * @return
     */
    @GetMapping(value = "/{brand_id}")
    public CommonResult<ContentProductBrandResp> getProductBrandContent(
        @PathVariable(value = "brand_id") Integer brandId) {
        // 1 数据转换
        // 2 业务
        ContentProductBrandBo contentProductBrandBo = productBrandService.get(brandId);
        // 3 返回结果
        ContentProductBrandResp contentProductBrandResp = ProductBrandDtoConvert.INSTANCE.toContentVo(contentProductBrandBo);
        return CommonResult.success(200, "获取品牌内容", contentProductBrandResp);
    }
}
