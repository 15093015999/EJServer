package com.ejserver.apps.ej.dto;
/**
 * WaiterAndOrder
 */

import java.util.List;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.Waiter;

public class WaiterAndOrder {
    private Waiter waiter;
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}