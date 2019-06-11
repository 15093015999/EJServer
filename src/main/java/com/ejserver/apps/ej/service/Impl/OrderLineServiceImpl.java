package com.ejserver.apps.ej.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.OrderLine;
import com.ejserver.apps.ej.bean.OrderLineExample;
import com.ejserver.apps.ej.dao.OrderLineMapper;
import com.ejserver.apps.ej.service.IOrderLineService;

import org.springframework.stereotype.Service;

/**
 * OrderLineServiceImpl
 */
@Service
public class OrderLineServiceImpl implements IOrderLineService {
    @Resource
    private OrderLineMapper orderLineMapper;

    @Override
    public List<OrderLine> findAll() {
        OrderLineExample example = new OrderLineExample();
        return orderLineMapper.selectByExample(example);
    }

    @Override
    public OrderLine findById(Long id) {
        return orderLineMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) throws Exception {
        return orderLineMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderLine orderLine) throws Exception {
        return orderLineMapper.insert(orderLine);
    }

    @Override
    public int saveOrUpdate(OrderLine orderLine) throws Exception {
        return orderLineMapper.updateByPrimaryKey(orderLine);
    }

    @Override
    public List<OrderLine> findByProductId(Long id) {
        OrderLineExample example =new OrderLineExample();
        example.createCriteria().andProductIdEqualTo(id);
        return orderLineMapper.selectByExample(example);
    }

    @Override
    public List<OrderLine> findByOrderId(Long id) {
        OrderLineExample example =new OrderLineExample();
        example.createCriteria().andOrderIdEqualTo(id);
        return orderLineMapper.selectByExample(example);
    }

    
}