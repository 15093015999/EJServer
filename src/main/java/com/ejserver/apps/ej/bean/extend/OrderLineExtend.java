package com.ejserver.apps.ej.bean.extend;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.OrderLine;
import org.apache.logging.log4j.message.StringFormattedMessage;

/**
 * @author 李洋
 * @date 2019-06-13 20:41
 */
public class OrderLineExtend extends OrderLine {
    private Order order;
    private String productName;
    private String customerName;
    private String address;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    @Override
    public String toString() {
        return "OrderLineExtend{" +
                "order=" + order +
                ", productName='" + productName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
