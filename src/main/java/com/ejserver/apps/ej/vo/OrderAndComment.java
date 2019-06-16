package com.ejserver.apps.ej.vo;
/**
 * OrderAndComment
 */

import java.util.List;

import com.ejserver.apps.ej.bean.Comment;
import com.ejserver.apps.ej.bean.Order;

public class OrderAndComment {
    private Order order;
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}