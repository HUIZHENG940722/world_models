package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.common.api.CommonResult;
import com.ethan.domain.mall.product.application.service.ProductAttrService;
import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.interfaces.assembler.ProductAttrDtoConvert;
import com.ethan.domain.mall.product.interfaces.dto.attr.CreateProductAttrKeyReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 添加商品规格键
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
}
