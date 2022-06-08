package com.ethan.world.mall.product.interfaces.controller;

import com.ethan.world.mall.product.application.service.ProductSpuService;
import com.ethan.world.mall.product.domain.bo.sku.CreateProductSkuBo;
import com.ethan.world.mall.product.domain.bo.sku.CreateProductSpuAndSkuBo;
import com.ethan.world.mall.product.domain.bo.spu.CreateProductSpuBo;
import com.ethan.world.mall.product.interfaces.api.MallProductSpuApi;
import com.ethan.world.mall.product.interfaces.api.dto.CreateProductSpuAndSkuReq;
import com.ethan.world.mall.product.interfaces.assembler.ProductSkuDtoConvert;
import com.ethan.world.mall.product.interfaces.assembler.ProductSpuDtoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品SPU用户接口层
 * @Date 2022/5/28
 */
@RestController
public class ProductSpuController implements MallProductSpuApi {

    @Autowired
    private ProductSpuService productSpuService;

    @Override
    public ResponseEntity<Integer> createProductSpu(CreateProductSpuAndSkuReq createProductSpuAndSkuReq) {
        // 1 数据转换
        // 2.1.1 初始化创建SKU列表数据
        List<CreateProductSkuBo> createProductSkuBoList = ProductSkuDtoConvert.INSTANCE.toBo(createProductSpuAndSkuReq.getSkus());
        // 2.1.2 初始化创建商品SPU列表数据
        CreateProductSpuBo createProductSpuBo = ProductSpuDtoConvert.INSTANCE.toBo(createProductSpuAndSkuReq);
        CreateProductSpuAndSkuBo createProductSpuAndSkuBo = new CreateProductSpuAndSkuBo();
        createProductSpuAndSkuBo.setCreateProductSpuBo(createProductSpuBo);
        createProductSpuAndSkuBo.setCreateProductSkuBoList(createProductSkuBoList);
        // 2 业务逻辑
        int create = productSpuService.createProductSpu(createProductSpuAndSkuBo);
        // 3 返回结果
        // 创建商品SPU集SKU列表成功
        return new ResponseEntity<>(create, HttpStatus.OK);
    }
}
