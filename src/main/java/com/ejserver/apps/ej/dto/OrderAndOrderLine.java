package com.ejserver.apps.ej.dto;

import java.util.List;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.OrderLine;

/**
 * OrderAndOrderLine
 */
public class OrderAndOrderLine {
    private Order order;
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}