package com.ejserver.apps.ej.service;

import java.util.List;

import com.ejserver.apps.ej.bean.Customer;

/**
 * @author 黄洋洋
 * ICustomerService
 */
public interface ICustomerService {
    /**
     * find all information from ej_customer
     * @return Customer
     */
    List<Customer> findAll();

    /**
     * insert the information
     * @param record Customer
     * @return int success return 1,error return 0
     * @throws Exception throws the exception
     */
    int insert(Customer record) throws Exception;

    /**
     * delete from ej_customer by primary key
     * @param id primary key
     * @return int success return 1,error return 0
     * @throws Exception throws the exception
     */
    int deleteById(Long id) throws Exception;

    /**
     * update the ej_customer by primary key
     * @param record update information
     * @return int success return 1,error return 0
     * @throws Exception throws the exception
     */
    int updateById(Customer record) throws Exception;

    /**
     * find by primary key
     * @param id primary key
     * @return Customer
     */
    Customer findById(Long id);

    void batchDelete(Long[] ids) throws Exception;

    List<Customer> findByLikeRealname(String realname);

}