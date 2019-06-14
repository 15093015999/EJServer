package com.ejserver.apps.ej.web.controller;

import com.ejserver.apps.ej.bean.Waiter;
import com.ejserver.apps.ej.dto.WaiterAndOrder;
import com.ejserver.apps.ej.service.IOrderService;
import com.ejserver.apps.ej.service.IWaiterService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 黄洋洋
 * @date 2019/06/10 afternoon
 */
@RestController
@RequestMapping("waiter")
public class WaiterController {
    @Resource
    private IWaiterService waiterService;
    @Resource
    private IOrderService orderService;

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public ActionResult findAll() {
        return ActionResultUtil.success("success", waiterService.findAll());
    }

    @ApiOperation("插入数据")
    @PostMapping("/insert")
    public ActionResult insert(Waiter record) {
        try {
            return ActionResultUtil.success("插入成功", waiterService.insert(record));
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("插入失败");
        }
    }

    @ApiOperation("通过ID删除数据")
    @PostMapping("/deleteById")
    public ActionResult deleteById(@ApiParam(value = "主键", required = true) @RequestParam("id") long id) {
        try {
            return ActionResultUtil.success("删除成功", waiterService.deleteById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("删除失败");
        }
    }

    @ApiOperation("通过ID修改数据")
    @PostMapping("/updateById")
    public ActionResult updateById(Waiter record) {
        try {
            return ActionResultUtil.success("修改成功", waiterService.updateById(record));
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("修改失败");
        }
    }

    @ApiOperation("通过ID查询数据")
    @GetMapping("/findById")
    public ActionResult findById(@ApiParam(value = "主键", required = true) @RequestParam("id") long id) {
        Waiter customer = waiterService.findById(id);
        return ActionResultUtil.success("success", customer);
    }

    
    @ApiOperation("通过工人Id查找工人和订单")
    @GetMapping("/findWaiterAndOrderByWaiterId")
    public ActionResult findWaiterAndOrderByWaiterId(Long id) {
        Waiter waiter = waiterService.findById(id);
        if (waiter == null) {
            return ActionResultUtil.error("id不存在");
        }
        WaiterAndOrder waiterAndOrder = new WaiterAndOrder();
        waiterAndOrder.setWaiter(waiter);
        waiterAndOrder.setOrders(orderService.findByWaiterId(id));
        return ActionResultUtil.success("成功", waiterAndOrder);
    }


    @ApiOperation("批量删除")
    @PostMapping("/batchDelete")
    public ActionResult batchDelete(Long[] ids) {
        try {
            waiterService.batchDelete(ids);
            return ActionResultUtil.success("成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("id不存在");
        }
    }

    @ApiOperation("更新或增加工人信息")
    @PostMapping("/saveOrUpdate")
    public ActionResult saveOrUpdate(Waiter waiter){
        if (waiter.getId()!=null){
            return updateById(waiter);
        }else {
            return insert(waiter);
        }
    }
    @ApiOperation("通过服务员名进行模糊查询")
    @GetMapping("/findByLikeRealname")
    public ActionResult findByLikeRealname(String realname){
        return ActionResultUtil.success("成功!",waiterService.findByLikeRealname(realname));
    }
}
