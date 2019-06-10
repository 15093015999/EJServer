package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Product;
import com.ejserver.apps.ej.service.IProductService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张连硕
 * @date 2019/06/10 afternoon
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Resource
    private IProductService productService;

    @GetMapping("/findAll")
    public ActionResult findAll() {
        return ActionResultUtil.success("success", productService.findAll());
    }

    @GetMapping("/findById")
    public ActionResult findById(Long id) {
        return ActionResultUtil.success("success", productService.findById(id));
    }

    @PostMapping("/deleteById")
    public ActionResult deleteById(Long id) {
        try {
            productService.deleteById(id);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
        
    }

    @PostMapping("/insert")
    public ActionResult insert(Product product) {
        try {
            productService.insert(product);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    @PostMapping("/saveOrUpdate")
    public ActionResult saveOrUpdate(Product product) {

        try {
            productService.saveOrUpdate(product);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }


    
}