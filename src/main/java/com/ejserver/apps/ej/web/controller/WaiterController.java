package com.ejserver.apps.ej.web.controller;

import com.ejserver.apps.ej.bean.Waiter;
import com.ejserver.apps.ej.service.IWaiterService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.scheduling.annotation.Async;
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

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    @Async
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
    public ActionResult findById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        Waiter customer = waiterService.findById(id);
        return ActionResultUtil.success("success",customer);
    }
}
