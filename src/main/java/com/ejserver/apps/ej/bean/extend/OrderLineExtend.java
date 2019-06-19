package com.ejserver.apps.ej.bean.extend;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.OrderLine;

import java.util.List;

/**
 * @author 李洋
 * @date 2019-06-13 20:41
 */
public class OrderLineExtend {
    private Order order;
    private List<OrderLine> orderLines;
    private String waiterName;
    private String customerName;
    private String address;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
