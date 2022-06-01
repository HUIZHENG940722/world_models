package com.ethan.domain.mall.product.application.service;

import com.ethan.domain.mall.product.domain.bo.sku.CreateProductSkuBo;
import com.ethan.domain.mall.product.domain.bo.spu.CreateProductSpuBo;
import com.ethan.domain.mall.product.domain.service.ProductSkuDomainService;
import com.ethan.domain.mall.product.domain.service.ProductSpuDomainService;
import com.ethan.domain.mall.product.interfaces.assembler.ProductSkuDtoConvert;
import com.ethan.domain.mall.product.interfaces.assembler.ProductSpuDtoConvert;
import com.ethan.domain.mall.product.interfaces.dto.spu.CreateProductSpuAndSkuReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * @author zhenghui
 * @Description 商品SPU应用服务层
 * @Date 2022/5/28
 */
@Service
public class ProductSpuService {

    @Autowired
    private ProductSkuDomainService productSkuDomainService;

    @Autowired
    private ProductSpuDomainService productSpuDomainService;

    /**
     * 应用服务：创建商品SPU及对应的商品SKU列表
     * @param createProductSpuAndSkuReq
     * @return
     */
    public int createProductSpu(CreateProductSpuAndSkuReq createProductSpuAndSkuReq) {
        // 1 校验
        // 2 业务
        // 2.1 初始化数据
        // 2.1.1 初始化创建SKU列表数据
        List<CreateProductSkuBo> createProductSkuBoList = ProductSkuDtoConvert.INSTANCE.toBo(createProductSpuAndSkuReq.getSkus());
        // 2.1.2 初始化创建商品SPU列表数据
        CreateProductSpuBo createProductSpuBo = ProductSpuDtoConvert.INSTANCE.toBo(createProductSpuAndSkuReq);
        // 2.2 创建商品SPU
        createProductSpuBo.setSort(0);
        // 找出最小价格
        Integer price = createProductSkuBoList.stream().min(Comparator.comparing(CreateProductSkuBo::getPrice)).get().getPrice();
        createProductSpuBo.setPrice(price);
        Integer reduce = createProductSkuBoList.stream().map(CreateProductSkuBo::getQuantity).reduce(0, Integer::sum);
        createProductSpuBo.setQuantity(reduce);
        Integer spuId = productSpuDomainService.createProductSpu(createProductSpuBo);
        // 2.3 创建商品SKU列表
        productSkuDomainService.createProductSkus(spuId, createProductSkuBoList);
        // 3 返回结果
        return spuId;
    }
}
