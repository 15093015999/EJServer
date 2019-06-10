package com.ejserver.apps.ej.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Customer;
import com.ejserver.apps.ej.bean.CustomerExample;
import com.ejserver.apps.ej.dao.CustomerMapper;
import com.ejserver.apps.ej.service.ICustomerService;

import org.springframework.stereotype.Service;

/**
 * 黄洋洋
 * CustomerServiceImpl
 */
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        return customerMapper.selectByExample(new CustomerExample());
    }

    //插入数据
    @Override
    public int insert(Customer record){
          return  customerMapper.insert(record);

    }

    //删除数据


    @Override
    public int deleteById(Long id) throws Exception{
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if (customer == null){
            throw new Exception("要删除的客户不存在");
        }
        else {
            return customerMapper.deleteByPrimaryKey(id);
        }
    }

    //修改数据

    @Override
    public int updateById(Customer record){

        return customerMapper.updateByPrimaryKey(record);
    }

    //通过ID查询数据

    @Override
    public Customer findById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }
}