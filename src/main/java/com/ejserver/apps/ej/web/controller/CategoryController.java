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

import io.swagger.annotations.ApiOperation;

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

    @ApiOperation("插入数据")
    @PostMapping("/insert")
    public ActionResult insert(Category category){
        try{
            categoryService.insert(category);
            return ActionResultUtil.success("插入成功!");
        }catch (Exception e){
            return ActionResultUtil.error("插入失败!"+e.getMessage());
        }
    }

    @ApiOperation("通过ID删除数据")
    @PostMapping("/deleteByPrimaryKey")
    public ActionResult deleteByPrimaryKey(Long id){
        try{
            categoryService.deleteByPrimaryKey(id);
            return ActionResultUtil.success("删除成功!");
        }catch (Exception e){
            return ActionResultUtil.error("删除失败!");
        }
    }

    @ApiOperation("通过ID修改数据")
    @PostMapping("/updateByPrimaryKey")
    public ActionResult updateByPrimaryKey(Category category){
        try{
            categoryService.updateByPrimaryKey(category);
            return ActionResultUtil.success("更新成功!");
        }catch (Exception e){
            return ActionResultUtil.error("更新失败!");
        }
    }
    @ApiOperation("查询所有")
    @GetMapping("/selectByExample")
    public ActionResult selectByExample(){
        List<Category> categories = categoryService.selectByExample(new CategoryExample());
        return ActionResultUtil.success("查询成功!",categories);
    }

    @ApiOperation("通过ID查询数据")
    @GetMapping("/selectByPrimaryKey")
    public ActionResult selectByPrimaryKey(Long id) {
        Category category = categoryService.selectByPrimaryKey(id);
        if (category == null) {
            return ActionResultUtil.error("查询不存在");
        }
        return ActionResultUtil.success("查询成功", category);
    }



}
