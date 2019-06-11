package com.ejserver.apps.ej.dto;

import java.util.List;

import com.ejserver.apps.ej.bean.OrderLine;
import com.ejserver.apps.ej.bean.Product;

/**
 * ProductAndOrderLine
 */
public class ProductAndOrderLine {
    private Product product;
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}