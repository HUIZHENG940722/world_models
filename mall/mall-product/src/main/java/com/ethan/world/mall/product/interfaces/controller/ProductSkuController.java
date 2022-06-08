package com.ethan.world.mall.product.interfaces.controller;

import com.ethan.world.mall.product.application.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zWX1058539
 * @Description 商品SKU用户接口
 * @Date 2022/5/30
 */
@RestController
public class ProductSkuController {

    @Autowired
    private ProductSkuService productSkuService;


}
