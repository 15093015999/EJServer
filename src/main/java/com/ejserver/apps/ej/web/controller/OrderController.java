package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.service.IOrderService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @GetMapping("/findAll")
    @Async
    public ActionResult findAll() {
        return ActionResultUtil.success("success", orderService.findAll());
    }

    @GetMapping("/findById")
    @Async
    public ActionResult findById(Long id) {
        return ActionResultUtil.success("success", orderService.findById(id));
    }

    @PostMapping("/deleteById")
    @Async
    public ActionResult deleteById(Long id) {
        try {
            orderService.deleteById(id);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
        
    }

    @PostMapping("/insert")
    @Async
    public ActionResult insert(Order order) {
        try {
            orderService.insert(order);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    @PostMapping("/saveOrUpdate")
    @Async
    public ActionResult saveOrUpdate(Order order) {

        try {
            orderService.saveOrUpdate(order);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

}