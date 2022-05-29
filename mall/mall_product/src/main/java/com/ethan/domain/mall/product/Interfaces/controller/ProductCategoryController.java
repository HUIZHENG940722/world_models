package com.ethan.domain.mall.product.Interfaces.controller;

import com.ethan.domain.mall.product.Interfaces.assembler.ProductCategoryDtoConvert;
import com.ethan.domain.mall.product.Interfaces.dto.CreateProductCategoryReq;
import com.ethan.domain.mall.product.application.service.ProductCategoryService;
import com.ethan.domain.mall.product.domain.bo.category.ProductCategoryBO;
import com.ethan.domain.mall.product.infrastructure.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenghui
 * @Description 商品分类用户接口层
 * @Date 2022/5/29
 */
@RestController
@RequestMapping(value = "/product/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 用户接口：创建商品分类
     *
     * @param createProductCategoryReq
     * @return
     */
    @PostMapping(value = "")
    public CommonResult<Integer> createProductCategory(@Validated @RequestBody CreateProductCategoryReq createProductCategoryReq) {
        // 1 数据转换
        ProductCategoryBO productCategoryBO = ProductCategoryDtoConvert.INSTANCE.toBo(createProductCategoryReq);
        // 2 业务
        int create = productCategoryService.createProductCategory(productCategoryBO);
        // 3 返回结果
        return CommonResult.success(200, "创建商品分类成功", create);
    }
}
