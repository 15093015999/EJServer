package com.ejserver.apps.ej.web.controller;

import com.ejserver.apps.ej.bean.Address;
import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.vo.AddressAndOrder;
import com.ejserver.apps.ej.service.IAddressService;
import com.ejserver.apps.ej.service.IOrderService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * @author 李洋
 * @date 2019/6/10
 */
@Validated
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private IAddressService addressService;
    @Resource
    private IOrderService orderService;

    @ApiOperation("查询所有")
    @GetMapping("/selectByExample")
    public ActionResult selectByExample() {
        List<Address> addresses = addressService.selectByExample();
        return ActionResultUtil.success("查询成功！", addresses);
    }

    @ApiOperation("通过ID查询数据")
    @GetMapping("/selectByPrimaryKey")
    public ActionResult selectByPrimaryKey(@NotNull @RequestParam Long id) {
        Address address = addressService.selectByPrimaryKey(id);
        if (address == null) {
            return ActionResultUtil.error("查询不存在");
        }
        return ActionResultUtil.success("查询成功", address);
    }

    @ApiOperation("插入数据")
    @PostMapping("/insert")
    public ActionResult insert(Address address) {
        try {
            addressService.insert(address);
            return ActionResultUtil.success("插入成功！");
        }catch (Exception e){
            return  ActionResultUtil.error("插入失败!"+e.getMessage());
        }


    }

    @ApiOperation("通过ID删除数据")
    @PostMapping("/deleteByPrimaryKey")
    public ActionResult deleteByPrimaryKey(Long id) {
        try{
            addressService.deleteByPrimaryKey(id);
            return ActionResultUtil.success("删除成功！");
        }catch (Exception e){
            return ActionResultUtil.error("删除失败!"+e.getMessage());
        }
    }

    @ApiOperation("通过ID修改数据")
    @PostMapping("/updateByPrimaryKey")
    public ActionResult updateByPrimaryKey(Address address) {
        try{
            addressService.updateByPrimaryKey(address);
            return ActionResultUtil.success("更新成功！");
        }catch (Exception e){
            return ActionResultUtil.error("更新失败!");
        }
    }
    @ApiOperation("通过地址id查询地址以及订单信息")
    @GetMapping("/findAddressAndOrderByAddressId")
    public ActionResult findAddressAndOrderByAddressId(Long addressId){
        Address address = addressService.selectByPrimaryKey(addressId);
        if (address==null){
            return ActionResultUtil.error("id不存在");
        }
        List<Order> orders = orderService.findByAddressId(addressId);
        AddressAndOrder addressAndOrder = new AddressAndOrder();
        addressAndOrder.setAddress(address);
        addressAndOrder.setOrders(orders);
        return ActionResultUtil.success("成功",addressAndOrder);
    }
    @ApiOperation("批量删除Address")
    @PostMapping("/batchDelete")
    public ActionResult batchDelete(Long[] ids){
        if (ids==null){
            return ActionResultUtil.error("失败!");
        }
        try {
            addressService.batchDelete(ids);
            return ActionResultUtil.success("成功!");
        } catch (Exception e) {
            return ActionResultUtil.error("失败!");
        }
    }
    @ApiOperation("更新或增加地址信息")
    @PostMapping("/saveOrUpdate")
    public ActionResult saveOrUpdate(Address address){
        if (address.getId()!=null){
            try {
                addressService.updateByPrimaryKey(address);
                return ActionResultUtil.success("更新成功!");
            } catch (Exception e) {
                return ActionResultUtil.error("更新失败!"+e.getMessage());
            }
        }else {
            try {
                addressService.insert(address);
                return ActionResultUtil.success("添加成功!");
            } catch (Exception e) {
                return ActionResultUtil.error("添加失败!"+e.getMessage());
            }
        }
    }
}
