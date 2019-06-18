package com.ejserver.apps.ej.bean.extend;

import com.ejserver.apps.ej.bean.Address;
import com.ejserver.apps.ej.bean.Customer;

/**
 * @author 李洋
 * @date 2019-06-17 15:15
 */
public class AddressExtend extends Address {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
