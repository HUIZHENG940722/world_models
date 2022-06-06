package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductBrandService;
import com.ethan.domain.mall.product.domain.bo.brand.*;
import com.ethan.domain.mall.product.interfaces.api.MallProductBrandApi;
import com.ethan.domain.mall.product.interfaces.api.dto.*;
import com.ethan.domain.mall.product.interfaces.assembler.ProductBrandDtoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zWX1058539
 * @Description 商品品牌用户接口
 * @Date 2022/5/30
 */
@RestController
public class ProductBrandController implements MallProductBrandApi {

    @Autowired
    private ProductBrandService productBrandService;


    @Override
    public ResponseEntity<ContentProductBrandResp> getProductBrandContent(Integer brandId) {
        // 1 数据转换
        // 2 业务
        ContentProductBrandBo contentProductBrandBo = productBrandService.get(brandId);
        // 3 返回结果
        ContentProductBrandResp contentProductBrandResp = ProductBrandDtoConvert.INSTANCE.toContentVo(contentProductBrandBo);
        // 获取品牌内容
        return new ResponseEntity<>(contentProductBrandResp, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<PageProductBrandResp> pageProductBrandContent(String contentType, PageQueryProductBrandReq pageQueryProductBrandReq) {
        // 1 数据转换
        PageQueryProductBrandBo pageQueryProductBrandBo = ProductBrandDtoConvert.INSTANCE.toBo(pageQueryProductBrandReq);
        // 2 业务
        PageProductBrandBo pageProductBrandBo = productBrandService.pageProductBrandContent(pageQueryProductBrandBo);
        // 3 返回结果
        PageProductBrandResp pageProductBrandResp = ProductBrandDtoConvert.INSTANCE.toContentVo(pageProductBrandBo);
        // 分页查询商品品牌成功
        return new ResponseEntity<>(pageProductBrandResp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> createProductBrand(CreateProductBrandReq createProductBrandReq) {
        // 1 数据转换
        CreateProductBrandBo createProductBrandBo = ProductBrandDtoConvert.INSTANCE.toBo(createProductBrandReq);
        // 2 业务
        int create = productBrandService.createProductBrand(createProductBrandBo);
        // 3 返回结果
        // 创建商品品牌成功
        return new ResponseEntity<>(create, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> updateProductBrand(Integer brandId, UpdateProductBrandReq updateProductBrandReq) {
        // 1 数据转换
        UpdateProductBrandBo updateProductBrandBo = ProductBrandDtoConvert.INSTANCE.toBo(updateProductBrandReq);
        // 2 业务
        int update = productBrandService.updateProductBrand(brandId, updateProductBrandBo);
        // 3 返回结果
        // 更新商品品牌成功
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

}
