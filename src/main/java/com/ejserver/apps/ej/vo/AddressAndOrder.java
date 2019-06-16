package com.ejserver.apps.ej.vo;

import java.util.List;

import com.ejserver.apps.ej.bean.Address;
import com.ejserver.apps.ej.bean.Order;

/**
 * AddressAndOrder
 */
public class AddressAndOrder{
    private Address address;
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}