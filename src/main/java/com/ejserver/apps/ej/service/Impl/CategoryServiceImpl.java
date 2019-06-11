package com.ejserver.apps.ej.service.Impl;

import com.ejserver.apps.ej.bean.Category;
import com.ejserver.apps.ej.bean.CategoryExample;
import com.ejserver.apps.ej.dao.CategoryMapper;
import com.ejserver.apps.ej.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李洋
 * @date 2019/06/10
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public int insert(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Category category) {
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public List<Category> selectByExample(CategoryExample categoryExample) {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public Category selectByPrimaryKey(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void batchDelete(Long[] ids) {
        for (Long id:
                ids ) {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }
}
