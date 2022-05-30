package com.ethan.domain.mall.product.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.mall.product.domain.bo.category.CreateProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.DetailsProductCategoryBo;
import com.ethan.domain.mall.product.domain.bo.category.UpdateProductCategoryBo;
import com.ethan.domain.mall.product.domain.convert.ProductCategoryPoConvert;
import com.ethan.domain.mall.product.infrastructure.dao.ProductCategoryMapper;
import com.ethan.domain.mall.product.infrastructure.dao.po.category.ProductCategoryPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhenghui
 * @Description 商品分类数据仓库
 * @Date 2022/5/29
 */
@Repository
public class ProductCategoryRepository {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public CreateProductCategoryBo getByPid(Integer pid) {
        return ProductCategoryPoConvert.INSTANCE.toCreateBo(productCategoryMapper.selectById(pid));
    }

    public int add(CreateProductCategoryBo createProductCategoryBo) {
        return productCategoryMapper.insert(ProductCategoryPoConvert.INSTANCE.createBoToPo(createProductCategoryBo));
    }

    public DetailsProductCategoryBo getByName(String name) {
        LambdaQueryWrapper<ProductCategoryPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductCategoryPo::getName, name);
        return ProductCategoryPoConvert.INSTANCE.toDetailsBo(productCategoryMapper.selectOne(lambdaQueryWrapper));
    }

    public DetailsProductCategoryBo getById(Integer id) {
        return ProductCategoryPoConvert.INSTANCE.toDetailsBo(productCategoryMapper.selectById(id));
    }

    public int update(UpdateProductCategoryBo updateProductCategoryBo) {
        return productCategoryMapper.updateById(ProductCategoryPoConvert.INSTANCE.updateBotoPo(updateProductCategoryBo));
    }

    public List<DetailsProductCategoryBo> getChildListByPid(Integer id) {
        LambdaQueryWrapper<ProductCategoryPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(ProductCategoryPo::getPid, id);
        return ProductCategoryPoConvert.INSTANCE.toDetailsListBo(productCategoryMapper.selectList(lambdaQueryWrapper));
    }

    private LambdaQueryWrapper<ProductCategoryPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(ProductCategoryPo.class);
    }

    public int deleteById(Integer id) {
        return productCategoryMapper.deleteById(id);
    }
}
