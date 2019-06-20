package com.ejserver.apps.ej.bean.extend;

import com.ejserver.apps.ej.bean.Category;
import com.ejserver.apps.ej.bean.Product;

/**
 * @author 李洋
 * @date 2019-06-19 08:17
 */
public class ProductExtend extends Product {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
