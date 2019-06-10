package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.service.ICustomerService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    @Resource
    private ICustomerService customerService;

    // @ApiOperation("更新用户")
    @PostMapping("/findAll")
    @Async
    public ActionResult findAll() {
        return ActionResultUtil.success("success",customerService.findAll());
    }
    
}