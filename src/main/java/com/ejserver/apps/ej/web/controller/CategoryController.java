package com.ejserver.apps.ej.web.controller;


import com.ejserver.apps.ej.bean.Category;
import com.ejserver.apps.ej.bean.CategoryExample;
import com.ejserver.apps.ej.service.ICategoryService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李洋
 * @date 2019/06/10 afternoon
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private ICategoryService categoryService;
    @PostMapping("/insert")
    public ActionResult insert(Category category){
        int insert = categoryService.insert(category);
        return insert == 1 ? ActionResultUtil.success("插入成功!") : ActionResultUtil.error("插入失败!");
    }
    @PostMapping("/deleteByPrimaryKey")
    public ActionResult deleteByPrimaryKey(Long id){
        int delete = categoryService.deleteByPrimaryKey(id);
        return delete == 1 ? ActionResultUtil.success("删除成功!") : ActionResultUtil.error("删除失败!");
    }
    @PostMapping("/updateByPrimaryKey")
    public ActionResult updateByPrimaryKey(Category category){
        int update = categoryService.updateByPrimaryKey(category);
        return update == 1 ? ActionResultUtil.success("更新成功!") : ActionResultUtil.error("更新失败!");
    }
    @GetMapping("/selectByExample")
    public ActionResult selectByExample(){
        List<Category> categories = categoryService.selectByExample(new CategoryExample());
        return ActionResultUtil.success("查询成功!",categories);
    }
}
