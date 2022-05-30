package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.domain.bo.category.UpdateProductCategoryBo;
import com.ethan.domain.mall.product.interfaces.assembler.ProductCategoryDtoConvert;
import com.ethan.domain.mall.product.interfaces.dto.category.CreateProductCategoryReq;
import com.ethan.domain.mall.product.application.service.ProductCategoryService;
import com.ethan.domain.mall.product.domain.bo.category.CreateProductCategoryBo;
import com.ethan.domain.mall.product.infrastructure.api.CommonResult;
import com.ethan.domain.mall.product.interfaces.dto.category.UpdateProductCategoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        CreateProductCategoryBo createProductCategoryBo = ProductCategoryDtoConvert.INSTANCE.toBo(createProductCategoryReq);
        // 2 业务
        int create = productCategoryService.createProductCategory(createProductCategoryBo);
        // 3 返回结果
        return CommonResult.success(200, "创建商品分类成功", create);
    }

    /**
     * 用户接口：更新商品分类
     * @param updateProductCategoryReq
     * @return
     */
    @PutMapping(value = "/{category_id}")
    public CommonResult<Integer> updateProductCategory(@PathVariable(value = "category_id") Integer categoryId,
                                                       @Validated @RequestBody UpdateProductCategoryReq updateProductCategoryReq) {
        // 1 数据转换
        UpdateProductCategoryBo updateProductCategoryBo = ProductCategoryDtoConvert.INSTANCE.toBo(updateProductCategoryReq);
        // 2 业务
        int update = productCategoryService.updateProductCategory(categoryId, updateProductCategoryBo);
        // 3 返回结果
        return CommonResult.success(200, "更新商品分类成功", update);
    }
}
