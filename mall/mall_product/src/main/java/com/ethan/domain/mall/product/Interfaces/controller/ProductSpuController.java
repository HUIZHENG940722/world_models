package com.ethan.domain.mall.product.Interfaces.controller;

import com.ethan.domain.mall.product.application.service.ProductSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenghui
 * @name ProductSpuController
 * @Description 商品SPU用户接口层
 * @Date 2022/5/28
 */
@RestController
public class ProductSpuController {

    @Autowired
    private ProductSpuService productSpuService;

}
