package com.ejserver.apps.ej.service;

import java.util.List;

import com.ejserver.apps.ej.bean.Order;

/**
 * IOrderService
 */
public interface IOrderService {

    List<Order> findAll();
    Order findById(Long id);
    int deleteById(Long id) throws Exception;
    int insert(Order order) throws Exception;
    int saveOrUpdate(Order order) throws Exception;
    List<Order> findByCustomerId(Long id);
    List<Order> findByWaiterId(Long id);
    List<Order> findByAddressId(Long id);
}