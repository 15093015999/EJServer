package com.ejserver.apps.ej.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Product;
import com.ejserver.apps.ej.bean.ProductExample;
import com.ejserver.apps.ej.dao.ProductMapper;
import com.ejserver.apps.ej.service.IProductService;

import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }

    @Override
    public Product findById(Long id) {

        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) throws Exception {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveOrUpdate(Product product) throws Exception {
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public int insert(Product product) throws Exception {
        return productMapper.insert(product);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        ProductExample example =new ProductExample();
        example.createCriteria().andCategoryIdEqualTo(id);
        return productMapper.selectByExample(example);
    }

}