package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductAttrKeyService;
import com.ethan.domain.mall.product.domain.bo.attr.key.ContentProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.CreateProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.PageProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.PageQueryProductAttrKeyBo;
import com.ethan.domain.mall.product.domain.bo.attr.key.UpdateProductAttrKeyBo;
import com.ethan.domain.mall.product.interfaces.api.MallProductAttrKeyApi;
import com.ethan.domain.mall.product.interfaces.api.dto.ContentProductAttrKeyResp;
import com.ethan.domain.mall.product.interfaces.api.dto.CreateProductAttrKeyReq;
import com.ethan.domain.mall.product.interfaces.api.dto.PageProductAttrKeyResp;
import com.ethan.domain.mall.product.interfaces.api.dto.PageQueryProductAttrKeyReq;
import com.ethan.domain.mall.product.interfaces.api.dto.UpdateProductAttrKeyReq;
import com.ethan.domain.mall.product.interfaces.assembler.ProductAttrDtoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zWX1058539
 * @Description 商品规格键用户接口服务
 * @Date 2022/6/2
 */
@RestController
public class ProductAttrKeyController implements MallProductAttrKeyApi {

    @Autowired
    private ProductAttrKeyService productAttrKeyService;

    @Override
    public ResponseEntity<Integer> createProductAttrKey(CreateProductAttrKeyReq createProductAttrKeyReq) {
        // 1 数据转换
        CreateProductAttrKeyBo createProductAttrKeyBo = ProductAttrDtoConvert.INSTANCE.toBo(createProductAttrKeyReq);
        // 2 业务
        Integer id = productAttrKeyService.createProductAttrKey(createProductAttrKeyBo);
        // 3 返回结果
        // 创建商品规格键
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContentProductAttrKeyResp> getProductAttrKey(Integer attyKeyId) {
        // 1 数据转换
        // 2 业务
        ContentProductAttrKeyBo productAttrKey = productAttrKeyService.getProductAttrKey(attyKeyId);
        ContentProductAttrKeyResp contentProductAttrKeyResp = ProductAttrDtoConvert.INSTANCE.toContentResp(productAttrKey);
        // 3 返回结果
        return new ResponseEntity<>(contentProductAttrKeyResp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageProductAttrKeyResp> pageProductAttrKey(PageQueryProductAttrKeyReq pageQueryProductAttrKeyReq) {
        // 1 数据转换
        PageQueryProductAttrKeyBo pageQueryProductAttrKeyBo = ProductAttrDtoConvert.INSTANCE.toBo(pageQueryProductAttrKeyReq);
        // 2 业务
        PageProductAttrKeyBo pageProductAttrKeyBo = productAttrKeyService.pageProductAttrKey(pageQueryProductAttrKeyBo);
        // 3 返回结果
        PageProductAttrKeyResp pageProductAttrKeyResp = ProductAttrDtoConvert.INSTANCE.toPageResp(pageProductAttrKeyBo);
        return new ResponseEntity<>(pageProductAttrKeyResp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> updateProductAttrKey(Integer attrKeyId, UpdateProductAttrKeyReq updateProductAttrKeyReq) {
        // 1 数据转换
        UpdateProductAttrKeyBo updateProductAttrKeyBo = ProductAttrDtoConvert.INSTANCE.toBo(updateProductAttrKeyReq);
        // 2 业务
        Integer update = productAttrKeyService.updateProductAttrKeyById(attrKeyId, updateProductAttrKeyBo);
        // 3 返回结果
        // 更新商品规格键成功
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
