package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.OrderLine;
import com.ejserver.apps.ej.service.IOrderLineService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderLineController
 */
@RestController
@RequestMapping("order-line")
public class OrderLineController {
    @Resource
    private IOrderLineService orderLineService;

    @GetMapping("/findAll")
    @Async
    public ActionResult findAll() {
        return ActionResultUtil.success("success", orderLineService.findAll());
    }

    @GetMapping("/findById")
    @Async
    public ActionResult findById(Long id) {
        return ActionResultUtil.success("success", orderLineService.findById(id));
    }

    @PostMapping("/deleteById")
    @Async
    public ActionResult deleteById(Long id) {
        try {
            orderLineService.deleteById(id);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
        
    }

    @PostMapping("/insert")
    @Async
    public ActionResult insert(OrderLine orderLine) {
        try {
            orderLineService.insert(orderLine);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    @PostMapping("/saveOrUpdate")
    @Async
    public ActionResult saveOrUpdate(OrderLine orderLine) {

        try {
            orderLineService.saveOrUpdate(orderLine);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    
}