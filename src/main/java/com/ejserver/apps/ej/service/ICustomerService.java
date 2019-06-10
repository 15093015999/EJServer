package com.ejserver.apps.ej.service;

import java.util.List;

import com.ejserver.apps.ej.bean.Customer;

/**
 * author:黄洋洋
 * ICustomerService
 */
public interface ICustomerService {

    List<Customer> findAll();
    int insert(Customer record) ;
    int deleteById(Long id) throws Exception;
    int updateById(Customer record);
    Customer findById(Long id);
}