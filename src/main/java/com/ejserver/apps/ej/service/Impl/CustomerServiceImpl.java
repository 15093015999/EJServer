package com.ejserver.apps.ej.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Customer;
import com.ejserver.apps.ej.bean.CustomerExample;
import com.ejserver.apps.ej.dao.CustomerMapper;
import com.ejserver.apps.ej.service.ICustomerService;

import org.springframework.stereotype.Service;

/**
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

    
}