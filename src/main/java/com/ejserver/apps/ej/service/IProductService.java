package com.ejserver.apps.ej.service;

import java.util.List;

import com.ejserver.apps.ej.bean.Product;


public interface IProductService {

    List<Product> findAll();
    Product findById(Long id);
    int deleteById(Long id) throws Exception;
    int insert(Product product) throws Exception;
    int saveOrUpdate(Product product) throws Exception;
    List<Product> findByCategoryId(Long id);
    void batchDelete(Long[] ids) throws Exception;

}