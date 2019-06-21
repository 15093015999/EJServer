package com.ejserver.apps.ej.service;

import java.util.List;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.VM.OrderVM;
import com.ejserver.apps.ej.bean.extend.OrderLineExtend;

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
    void batchDelete(Long[] ids) throws Exception;
    List<OrderLineExtend> findOrderLineInfo();
    List<OrderVM> queryBasic(Long customerId, Long waiterId);
}