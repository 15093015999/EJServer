package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Order;
import com.ejserver.apps.ej.bean.extend.OrderLineExtend;
import com.ejserver.apps.ej.vo.OrderAndComment;
import com.ejserver.apps.ej.vo.OrderAndOrderLine;
import com.ejserver.apps.ej.service.ICommentService;
import com.ejserver.apps.ej.service.IOrderLineService;
import com.ejserver.apps.ej.service.IOrderService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张连硕
 * @date 2019/06/10 afternoon
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private IOrderService orderService;
    @Resource
    private ICommentService commentService;
    @Resource
    private IOrderLineService orderLineService;

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public ActionResult findAll() {
        return ActionResultUtil.success("success", orderService.findAll());
    }

    @ApiOperation("通过ID查询数据")
    @GetMapping("/findById")
    public ActionResult findById(Long id) {
        return ActionResultUtil.success("success", orderService.findById(id));
    }

    @ApiOperation("通过ID删除数据")
    @PostMapping("/deleteById")
    public ActionResult deleteById(Long id) {
        try {
            orderService.deleteById(id);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }

    }

    @ApiOperation("插入数据")
    @PostMapping("/insert")
    public ActionResult insert(Order order) {
        try {
            orderService.insert(order);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation("增加或更新订单信息")
    @PostMapping("/saveOrUpdate")
    public ActionResult saveOrUpdate(Order order) {
        if (order.getId() != null) {
            try {
                orderService.saveOrUpdate(order);
                return ActionResultUtil.success("success");
            } catch (Exception e) {
                e.printStackTrace();
                return ActionResultUtil.error(e.getMessage());
            }
        } else {
            return insert(order);
        }

    }

    @ApiOperation("通过订单Id查找订单和评论")
    @GetMapping("/findOrderAndCommentByOrderId")
    public ActionResult findOrderAndCommentByOrderId(Long id) {
        Order order = orderService.findById(id);
        if (order == null) {
            return ActionResultUtil.error("id不存在");
        }
        OrderAndComment orderAndComment = new OrderAndComment();
        orderAndComment.setOrder(order);
        orderAndComment.setComments(commentService.findByOrderId(id));
        return ActionResultUtil.success("成功", orderAndComment);
    }

    @ApiOperation("通过订单Id查找订单和订单项")
    @GetMapping("/findOrderAndOrderLineByOrderId")
    public ActionResult findOrderAndOrderLineByOrderId(Long id) {
        Order order = orderService.findById(id);
        if (order == null) {
            return ActionResultUtil.error("id不存在");
        }
        OrderAndOrderLine orderAndOrderLine = new OrderAndOrderLine();
        orderAndOrderLine.setOrder(order);
        orderAndOrderLine.setOrderLines(orderLineService.findByOrderId(id));
        return ActionResultUtil.success("成功", orderAndOrderLine);
    }


    @ApiOperation("批量删除")
    @PostMapping("/batchDelete")
    public ActionResult batchDelete(Long[] ids) {
        try {
            orderService.batchDelete(ids);
            return ActionResultUtil.success("成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error("id不存在");
        }
    }
    @ApiOperation("通过订单项查询所有订单项和订单")
    @GetMapping("/findOrderLineInfo")
    public ActionResult findOrderLineInfo(){
        List<OrderLineExtend> orderLineInfo = orderService.findOrderLineInfo();
        return ActionResultUtil.success("成功!",orderLineInfo);
    }

    @ApiOperation("通过订单项查询所有订单项和订单(临时)")
    @GetMapping("/findAllOrderWithOrderLines")
    public ActionResult findAllOrderWithOrderLines() {
        List<OrderAndOrderLine> orderAndOrderLines = new ArrayList<OrderAndOrderLine>();
        for(Order order : orderService.findAll()){
            OrderAndOrderLine temp = new OrderAndOrderLine();
            temp.setOrder(order);
            temp.setOrderLines(orderLineService.findByOrderId(order.getId()));
            orderAndOrderLines.add(temp) ;
        }
        return ActionResultUtil.success("成功!",orderAndOrderLines);
    }
}