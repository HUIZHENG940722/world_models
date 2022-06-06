package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductCategoryService;
import com.ethan.domain.mall.product.domain.bo.category.ContentProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.CreateProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.UpdateProductCategoryBo;
import com.ethan.domain.mall.product.interfaces.api.MallProductCategoryApi;
import com.ethan.domain.mall.product.interfaces.api.dto.ContentProductCategoryResp;
import com.ethan.domain.mall.product.interfaces.api.dto.CreateProductCategoryReq;
import com.ethan.domain.mall.product.interfaces.api.dto.UpdateProductCategoryReq;
import com.ethan.domain.mall.product.interfaces.assembler.ProductCategoryDtoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenghui
 * @Description 商品分类用户接口层
 * @Date 2022/5/29
 */
@RestController
public class ProductCategoryController implements MallProductCategoryApi {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public ResponseEntity<Integer> createProductCategory(CreateProductCategoryReq createProductCategoryReq) {
        // 1 数据转换
        CreateProductCategoryBo createProductCategoryBo = ProductCategoryDtoConvert.INSTANCE.toBo(createProductCategoryReq);
        // 2 业务
        int create = productCategoryService.createProductCategory(createProductCategoryBo);
        // 3 返回结果
        // 创建商品分类成功
        return new ResponseEntity<>(create, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContentProductCategoryResp> getProductCategoryContent(Integer categoryId) {
        // 1 数据转换
        // 2 业务
        ContentProductCategoryBo contentProductCategoryBo = productCategoryService.getProductCategoryContent(categoryId);
        // 3 返回结果
        ContentProductCategoryResp contentProductCategoryResp = ProductCategoryDtoConvert.INSTANCE.toContentResp(contentProductCategoryBo);
        // 获取商品分类内容成功
        return new ResponseEntity<>(contentProductCategoryResp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> updateProductCategory(Integer categoryId, UpdateProductCategoryReq updateProductCategoryReq) {
        // 1 数据转换
        UpdateProductCategoryBo updateProductCategoryBo = ProductCategoryDtoConvert.INSTANCE.toBo(updateProductCategoryReq);
        // 2 业务
        int update = productCategoryService.updateProductCategory(categoryId, updateProductCategoryBo);
        // 3 返回结果
        // 更新商品分类成功
        return new ResponseEntity<>(update, HttpStatus.OK);
    }



    /**
     * 用户接口：分页获取商品分类内容
     *
     * @param pageQueryProductCategoryReq
     * @return
     */
    /*@GetMapping(value = "/page")
    public CommonResult<PageProductCategoryResp> pageProductCategoryContent(@Validated PageQueryProductCategoryReq pageQueryProductCategoryReq) {
        // 1 数据转换
        PageQueryProductCategoryBo pageQueryProductCategoryBo = ProductCategoryDtoConvert.INSTANCE.toBo(pageQueryProductCategoryReq);
        // 2 业务
        PageProductCategoryBo pageProductCategoryBo = productCategoryService.pageProductCategoryContent(pageQueryProductCategoryBo);
        // 3 返回结果
        PageProductCategoryResp pageProductCategoryContent = ProductCategoryDtoConvert.INSTANCE.toContentResp(pageProductCategoryBo);
        return CommonResult.success(200, "分页获取商品分类内容成功", pageProductCategoryContent);
    }*/
}
