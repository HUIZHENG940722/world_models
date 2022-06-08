package com.ethan.world.mall.product.application.service;

import com.ethan.world.mall.product.domain.bo.sku.CreateProductSkuBo;
import com.ethan.world.mall.product.domain.bo.sku.CreateProductSpuAndSkuBo;
import com.ethan.world.mall.product.domain.bo.spu.CreateProductSpuBo;
import com.ethan.world.mall.product.domain.service.ProductSkuDomainService;
import com.ethan.world.mall.product.domain.service.ProductSpuDomainService;
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
     * @param createProductSpuAndSkuBo
     * @return
     */
    public int createProductSpu(CreateProductSpuAndSkuBo createProductSpuAndSkuBo) {
        // 1 校验
        // 2 业务
        // 2.1 创建商品SPU
        CreateProductSpuBo createProductSpuBo = createProductSpuAndSkuBo.getCreateProductSpuBo();
        List<CreateProductSkuBo> createProductSkuBoList = createProductSpuAndSkuBo.getCreateProductSkuBoList();
        createProductSpuBo.setSort(0);
        // 找出最小价格
        Integer price = createProductSkuBoList.stream().min(Comparator.comparing(CreateProductSkuBo::getPrice)).get().getPrice();
        createProductSpuBo.setPrice(price);
        Integer reduce = createProductSkuBoList.stream().map(CreateProductSkuBo::getQuantity).reduce(0, Integer::sum);
        createProductSpuBo.setQuantity(reduce);
        Integer spuId = productSpuDomainService.createProductSpu(createProductSpuBo);
        // 2.2 创建商品SKU列表
        productSkuDomainService.createProductSkus(spuId, createProductSkuBoList);
        // 3 返回结果
        return spuId;
    }
}
