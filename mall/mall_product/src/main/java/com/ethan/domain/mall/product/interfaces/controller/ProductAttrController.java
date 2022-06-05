package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.common.api.CommonResult;
import com.ethan.domain.mall.product.application.service.ProductAttrService;
import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
import com.ethan.domain.mall.product.interfaces.assembler.ProductAttrDtoConvert;
import com.ethan.domain.mall.product.interfaces.dto.attr.CreateProductAttrKeyReq;
import com.ethan.domain.mall.product.interfaces.dto.attr.UpdateProductAttrKeyReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zWX1058539
 * @Description 商品规格用户接口服务
 * @Date 2022/6/2
 */
@RestController
@RequestMapping(value = "/product/attr")
public class ProductAttrController {

    @Autowired
    private ProductAttrService productAttrService;

    /**
     * 用户接口：添加商品规格键
     *
     * @param createProductAttrKeyReq
     * @return
     */
    @PostMapping(value = "/key")
    public CommonResult<Integer> createProductAttrKey(@Validated @RequestBody CreateProductAttrKeyReq createProductAttrKeyReq) {
        // 1 数据转换
        CreateProductAttrKeyBo createProductAttrKeyBo = ProductAttrDtoConvert.INSTANCE.toBo(createProductAttrKeyReq);
        // 2 业务
        Integer id = productAttrService.createProductAttrKey(createProductAttrKeyBo);
        // 3 返回结果
        return CommonResult.success(200, "创建商品规格键", id);
    }


    /**
     * 用户接口：更新商品规格键
     *
     * @param attrKeyId
     * @param updateProductAttrKeyReq
     * @return
     */
    @PutMapping(value = "/key/{attr_key_id}")
    public CommonResult<Integer> updateProductAttrKey(
        @PathVariable("attr_key_id") Integer attrKeyId,
        @Validated @RequestBody UpdateProductAttrKeyReq updateProductAttrKeyReq) {
        // 1 数据转换
        UpdateProductAttrKeyBo updateProductAttrKeyBo = ProductAttrDtoConvert.INSTANCE.toBo(updateProductAttrKeyReq);
        // 2 业务
        Integer update = productAttrService.updateProductAttrKeyById(attrKeyId, updateProductAttrKeyBo);
        // 3 返回结果
        return CommonResult.success(200, "更新商品规格键成功", update);
    }
}
