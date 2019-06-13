package com.ejserver.apps.ej.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.OrderExample;
import com.ejserver.apps.ej.bean.extend.OrderLineExtend;
import com.ejserver.apps.ej.dao.OrderMapper;
import com.ejserver.apps.ej.dao.extend.OrderLineExtendMapper;
import com.ejserver.apps.ej.service.IOrderService;

import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderLineExtendMapper orderLineExtendMapper;

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

    @Override
    public List<Order> findByCustomerId(Long id){
        OrderExample example =new OrderExample();
        example.createCriteria().andCustomerIdEqualTo(id);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> findByWaiterId(Long id) {
        OrderExample example =new OrderExample();
        example.createCriteria().andWaiterIdEqualTo(id);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> findByAddressId(Long id) {
        OrderExample example =new OrderExample();
        example.createCriteria().andAddressIdEqualTo(id);
        return orderMapper.selectByExample(example);
    }

    @Override
    public void batchDelete(Long[] ids) throws Exception {
        for(Long id:ids){
            orderMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<OrderLineExtend> findOrderRightJoinOrderLine() {

        return orderLineExtendMapper.findOrderRightJoinOrderLine();
    }


}