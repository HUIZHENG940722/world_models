package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductAttrService;
import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
import com.ethan.domain.mall.product.interfaces.api.MallProductAttrApi;
import com.ethan.domain.mall.product.interfaces.api.dto.CreateProductAttrKeyReq;
import com.ethan.domain.mall.product.interfaces.api.dto.UpdateProductAttrKeyReq;
import com.ethan.domain.mall.product.interfaces.assembler.ProductAttrDtoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zWX1058539
 * @Description 商品规格用户接口服务
 * @Date 2022/6/2
 */
@RestController
public class ProductAttrController implements MallProductAttrApi {

    @Autowired
    private ProductAttrService productAttrService;

    @Override
    public ResponseEntity<Object> createProductAttrKey(CreateProductAttrKeyReq createProductAttrKeyReq) {
        // 1 数据转换
        CreateProductAttrKeyBo createProductAttrKeyBo = ProductAttrDtoConvert.INSTANCE.toBo(createProductAttrKeyReq);
        // 2 业务
        Integer id = productAttrService.createProductAttrKey(createProductAttrKeyBo);
        // 3 返回结果
        // 创建商品规格键
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateProductAttrKey(Integer attrKeyId, UpdateProductAttrKeyReq updateProductAttrKeyReq) {
        // 1 数据转换
        UpdateProductAttrKeyBo updateProductAttrKeyBo = ProductAttrDtoConvert.INSTANCE.toBo(updateProductAttrKeyReq);
        // 2 业务
        Integer update = productAttrService.updateProductAttrKeyById(attrKeyId, updateProductAttrKeyBo);
        // 3 返回结果
        // 更新商品规格键成功
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
