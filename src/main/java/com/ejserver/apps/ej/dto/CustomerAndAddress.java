package com.ejserver.apps.ej.dto;

import com.ejserver.apps.ej.bean.Address;
import com.ejserver.apps.ej.bean.Customer;

import java.util.List;

/**
 * @author 李洋
 * @date 2019-06-11 08:22
 */
public class CustomerAndAddress {
    private List<Address> address;
    private Customer customer;

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
