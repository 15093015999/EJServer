package com.ejserver.apps.ej.service;

import java.util.List;

import com.ejserver.apps.ej.bean.OrderLine;

/**
 * IOrderLineService
 */
public interface IOrderLineService {

    List<OrderLine> findAll();
    OrderLine findById(Long id);
    int deleteById(Long id) throws Exception;
    int insert(OrderLine orderLine) throws Exception;
    int saveOrUpdate(OrderLine orderLine) throws Exception;
    List<OrderLine> findByProductId(Long id);
    List<OrderLine> findByOrderId(Long id);
    void batchDelete(Long[] ids) throws Exception;
}