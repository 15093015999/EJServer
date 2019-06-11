package com.ejserver.apps.ej.service.Impl;

import com.ejserver.apps.ej.bean.Address;
import com.ejserver.apps.ej.bean.AddressExample;
import com.ejserver.apps.ej.bean.Customer;
import com.ejserver.apps.ej.dto.CustomerAndAddress;
import com.ejserver.apps.ej.dao.AddressMapper;
import com.ejserver.apps.ej.dao.CustomerMapper;
import com.ejserver.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李洋
 * @date 2019/06/10
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Override
    public List<Address> selectByExample() {
        AddressExample addressExample = new AddressExample();
        return addressMapper.selectByExample(addressExample);
    }

    @Override
    public Address selectByPrimaryKey(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Address address) {
        return addressMapper.insert(address);
    }

    @Override
    public int updateByPrimaryKey(Address address) {
        return addressMapper.updateByPrimaryKey(address);
    }

    @Override
    public CustomerAndAddress findCustomerAndAddressByCustomerId(Long id) {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        List<Address> addresses = addressMapper.selectAddressByCustomerId(id);
        CustomerAndAddress customerAndAddress=new CustomerAndAddress();
        customerAndAddress.setAddress(addresses);
        customerAndAddress.setCustomer(customer);

        return customerAndAddress;
    }
}
