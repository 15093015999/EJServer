package com.ejserver.apps.ej.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.OrderExample;
import com.ejserver.apps.ej.dao.OrderMapper;
import com.ejserver.apps.ej.service.IOrderService;

import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        OrderExample example =new OrderExample();
        return orderMapper.selectByExample(example);
    }

    @Override
    public Order findById(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) throws Exception {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Order order) throws Exception {
        return orderMapper.insert(order);
    }

    @Override
    public int saveOrUpdate(Order order) throws Exception {
        return orderMapper.updateByPrimaryKey(order);
    }

    
}