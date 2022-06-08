package com.ethan.domain.mall.product.interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductAttrValueService;
import com.ethan.domain.mall.product.domain.bo.attr.value.ContentProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.CreateProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.PageProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.PageQueryProductAttrValueBo;
import com.ethan.domain.mall.product.domain.bo.attr.value.UpdateProductAttrValueBo;
import com.ethan.domain.mall.product.interfaces.api.MallProductAttrValueApi;
import com.ethan.domain.mall.product.interfaces.api.dto.ContentProductAttrValueResp;
import com.ethan.domain.mall.product.interfaces.api.dto.CreateProductAttrValueReq;
import com.ethan.domain.mall.product.interfaces.api.dto.PageProductAttrValueResp;
import com.ethan.domain.mall.product.interfaces.api.dto.PageQueryProductAttrValueReq;
import com.ethan.domain.mall.product.interfaces.api.dto.UpdateProductAttrValueReq;
import com.ethan.domain.mall.product.interfaces.assembler.ProductAttrDtoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zWX1058539
 * @Description 商品规格值用户接口实现
 * @Date 2022/6/8
 */
@RestController
public class ProductAttrValueController implements MallProductAttrValueApi {

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @Override
    public ResponseEntity<Integer> createProductAttrValue(Integer attrKeyId,CreateProductAttrValueReq createProductAttrValueReq) {
        // 1 数据转换
        CreateProductAttrValueBo createProductAttrValueBo = ProductAttrDtoConvert.INSTANCE.toBo(createProductAttrValueReq);
        // 2 业务
        Integer create = productAttrValueService.createProductAttrValue(attrKeyId, createProductAttrValueBo);
        // 3 返回结果
        return new ResponseEntity<>(create, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContentProductAttrValueResp> getProductAttrValue(Integer attrValueId) {
        // 1 数据转换
        // 2 业务
        ContentProductAttrValueBo productAttrValue = productAttrValueService.getProductAttrValue(attrValueId);
        // 3 返回结果
        ContentProductAttrValueResp contentProductAttrValueResp = ProductAttrDtoConvert.INSTANCE.toContentResp(productAttrValue);
        return new ResponseEntity<>(contentProductAttrValueResp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageProductAttrValueResp> pageProductAttrValue(PageQueryProductAttrValueReq pageQueryProductAttrValueReq) {
        // 1 数据转换
        PageQueryProductAttrValueBo pageQueryProductAttrValueBo = ProductAttrDtoConvert.INSTANCE.toBo(pageQueryProductAttrValueReq);
        // 2 业务
        PageProductAttrValueBo pageProductAttrValueBo = productAttrValueService.pageProductAttrValue(pageQueryProductAttrValueBo);
        // 3 返回结果
        PageProductAttrValueResp pageProductAttrValueResp = ProductAttrDtoConvert.INSTANCE.toPageResp(pageProductAttrValueBo);
        return new ResponseEntity<>(pageProductAttrValueResp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> updateProductAttrValue(Integer attrKeyId, Integer attrValueId, UpdateProductAttrValueReq updateProductAttrValueReq) {
        // 1 数据转换
        UpdateProductAttrValueBo updateProductAttrValueBo = ProductAttrDtoConvert.INSTANCE.toBo(updateProductAttrValueReq);
        // 2 业务
        Integer update = productAttrValueService.updateProductAttrValue(attrKeyId, attrValueId, updateProductAttrValueBo);
        // 3 返回结果
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
