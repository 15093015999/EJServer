package com.ejserver.apps.ej.dto;
/**
 * CustomerAndProduct
 */

import java.util.List;

import com.ejserver.apps.ej.bean.Category;
import com.ejserver.apps.ej.bean.Product;

public class CategoryAndProduct {
    private Category category;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}