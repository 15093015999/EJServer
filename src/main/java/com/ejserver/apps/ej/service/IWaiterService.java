package com.ejserver.apps.ej.service;

import com.ejserver.apps.ej.bean.Waiter;

import java.util.List;

/**
 * author:黄洋洋
 * IWaiterService
 */
public interface IWaiterService {
    List<Waiter> findAll();
    int insert(Waiter record) throws Exception;
    int deleteById(Long id) throws Exception;
    int updateById(Waiter record) throws Exception;
    Waiter findById(Long id) ;
}
