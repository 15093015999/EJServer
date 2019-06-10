package com.ejserver.apps.ej.service;

import com.ejserver.apps.ej.bean.Category;
import com.ejserver.apps.ej.bean.CategoryExample;

import java.util.List;

/**
 * @author 李洋
 * @date 2019/06/10
 */
public interface ICategoryService {
    /**
     * insert your want to insert to ej_category
     * @param category insert info
     * @return int success return 1,fail return 0
     */
    int insert(Category category) throws Exception;

    /**
     * delete info from ej_category by primaryKey(id)
     * @param id primary key
     * @return int success return 1,fail return 0
     */
    int deleteByPrimaryKey(Long id) throws Exception;

    /**
     * update ej_category by primary key(id)
     * @param category primary key
     * @return int success return 1,fail return 0
     */
    int updateByPrimaryKey(Category category) throws Exception;

    /**
     * select all info from ej_category
     * @param categoryExample no info
     * @return list
     */
    List<Category> selectByExample(CategoryExample categoryExample);

    /**
     * select one info from ej_category by primary key(id)
     * @param id primary key
     * @return Category : the info you want
     */
    Category selectByPrimaryKey(Long id);
}
