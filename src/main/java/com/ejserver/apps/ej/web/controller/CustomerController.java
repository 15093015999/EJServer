package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Address;
import com.ejserver.apps.ej.bean.Customer;
import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.vo.CustomerAndAddress;
import com.ejserver.apps.ej.vo.CustomerAndOrder;
import com.ejserver.apps.ej.service.IAddressService;
import com.ejserver.apps.ej.service.ICustomerService;
import com.ejserver.apps.ej.service.IOrderService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 黄洋洋
 * @date 2019/06/10 afternoon
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    @Resource
    private ICustomerService customerService;
    @Resource
    private IAddressService addressService;
    @Resource
    private IOrderService orderService;

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    @Async
    public ActionResult findAll() {
        return ActionResultUtil.success("success", customerService.findAll());
    }

    @ApiOperation("插入数据")
    @PostMapping("/insert")
    public ActionResult insert(Customer record) {
        try {
            return ActionResultUtil.success("插入成功", customerService.insert(record));
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("插入失败");
        }
    }

    @ApiOperation("通过ID删除数据")
    @PostMapping("/deleteById")
    public ActionResult deleteById(@ApiParam(value = "主键", required = true) @RequestParam("id") Long id) {
        try {
            return ActionResultUtil.success("删除成功", customerService.deleteById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("删除失败");
        }
    }

    @ApiOperation("通过ID修改数据")
    @PostMapping("/updateById")
    public ActionResult updateById(Customer record) {
        try {
            return ActionResultUtil.success("修改成功", customerService.updateById(record));
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("修改失败");
        }
    }
    @ApiOperation("更新或者插入客户信息")
    @PostMapping("/saveOrUpdate")
    public ActionResult saveOrUpdate(Customer customer){
        if (customer.getId()!=null){
            try {
                customerService.updateById(customer);
                return ActionResultUtil.success("更新成功!");
            } catch (Exception e) {
                return ActionResultUtil.error("更新失败!"+e.getMessage());
            }
        }else {
            try {
                customerService.insert(customer);
                return ActionResultUtil.success("添加成功!");
            } catch (Exception e) {
                return ActionResultUtil.error("添加失败!"+e.getMessage());
            }
        }
    }

    @ApiOperation("通过ID查询数据")
    @GetMapping("/findById")
    public ActionResult findById(@ApiParam(value = "主键", required = true) @RequestParam("id") Long id) {
        Customer customer = customerService.findById(id);
        return ActionResultUtil.success("success", customer);
    }

    @ApiOperation("通过CustomerId查找到Customer和Address信息")
    @GetMapping("/findCustomerAndAddressByCustomerId")
    public ActionResult findCustomerAndAddressByCustomerId(Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return ActionResultUtil.error("id不存在");
        }
        List<Address> addresses = addressService.findAddressByCustomerId(id);
        CustomerAndAddress customerAndAddress = new CustomerAndAddress();
        customerAndAddress.setAddress(addresses);
        customerAndAddress.setCustomer(customer);
        return ActionResultUtil.success("成功!", customerAndAddress);
    }

    @ApiOperation("通过客户id查询到客户以及订单信息")
    @GetMapping("/findCustomerAndOrderByCustomerId")
    public ActionResult findCustomerAndOrderByCustomerId(Long customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return ActionResultUtil.error("id不存在");
        }
        List<Order> orders = orderService.findByCustomerId(customerId);
        CustomerAndOrder customerAndOrder = new CustomerAndOrder();
        customerAndOrder.setCustomer(customer);
        customerAndOrder.setOrder(orders);
        return ActionResultUtil.success("成功!", customerAndOrder);
    }

    @ApiOperation("批量删除")
    @PostMapping("/batchDelete")
    public ActionResult batchDelete(Long[] ids) {
        try {
            customerService.batchDelete(ids);
            return ActionResultUtil.success("成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("id不存在");
        }
    }
    @ApiOperation("通过客户名进行模糊查询")
    @GetMapping("/findByLikeRealname")
    public ActionResult findByLikeRealname(String realname){
        return ActionResultUtil.success("成功!",customerService.findByLikeRealname(realname));
    }

}