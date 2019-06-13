package com.ejserver.apps.ej.bean.extend;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.OrderLine;

/**
 * @author 李洋
 * @date 2019-06-13 20:41
 */
public class OrderLineExtend extends Order {
    private OrderLine orderLine;

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }
}
