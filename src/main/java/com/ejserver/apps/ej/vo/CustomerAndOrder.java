package com.ejserver.apps.ej.vo;

import java.util.List;

import com.ejserver.apps.ej.bean.Customer;
import com.ejserver.apps.ej.bean.Order;

/**
 * CustomerAndOrder
 */
public class CustomerAndOrder {
    private Customer customer;
    private List<Order> order;

    public List<Order> getOrder() {
        return order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}