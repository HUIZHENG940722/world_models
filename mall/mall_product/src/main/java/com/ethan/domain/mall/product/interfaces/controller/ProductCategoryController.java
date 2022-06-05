package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.common.api.CommonResult;
import com.ethan.domain.mall.product.domain.bo.category.*;
import com.ethan.domain.mall.product.interfaces.assembler.ProductCategoryDtoConvert;
import com.ethan.domain.mall.product.interfaces.dto.category.*;
import com.ethan.domain.mall.product.application.service.ProductCategoryService;
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
     *
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


    /**
     * 用户接口：获取商品分类内容
     *
     * @param categoryId
     * @return
     */
    @GetMapping(value = "/{category_id}")
    public CommonResult<ContentProductCategoryResp> getProductCategoryContent(@PathVariable(value = "category_id") Integer categoryId) {
        // 1 数据转换
        // 2 业务
        ContentProductCategoryBo contentProductCategoryBo = productCategoryService.getProductCategoryContent(categoryId);
        // 3 返回结果
        ContentProductCategoryResp contentProductCategoryResp = ProductCategoryDtoConvert.INSTANCE.toContentResp(contentProductCategoryBo);
        return CommonResult.success(200, "获取商品分类内容成功", contentProductCategoryResp);
    }

    /**
     * 用户接口：分页获取商品分类内容
     *
     * @param pageQueryProductCategoryReq
     * @return
     */
    @GetMapping(value = "/page")
    public CommonResult<PageProductCategoryResp> pageProductCategoryContent(@Validated PageQueryProductCategoryReq pageQueryProductCategoryReq) {
        // 1 数据转换
        PageQueryProductCategoryBo pageQueryProductCategoryBo = ProductCategoryDtoConvert.INSTANCE.toBo(pageQueryProductCategoryReq);
        // 2 业务
        PageProductCategoryBo pageProductCategoryBo = productCategoryService.pageProductCategoryContent(pageQueryProductCategoryBo);
        // 3 返回结果
        PageProductCategoryResp pageProductCategoryContent = ProductCategoryDtoConvert.INSTANCE.toContentResp(pageProductCategoryBo);
        return CommonResult.success(200, "分页获取商品分类内容成功", pageProductCategoryContent);
    }
}
