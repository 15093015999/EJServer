package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Comment;
import com.ejserver.apps.ej.service.ICommentService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author 张连硕
 * @date 2019/06/10 afternoon
 */
@RestController
@RequestMapping("comment")
public class CommentController {

    @Resource
    private ICommentService commentService;

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public ActionResult findAll() {
        return ActionResultUtil.success("success", commentService.findAll());
    }

    @ApiOperation("通过ID查询数据")
    @GetMapping("/findById")
    public ActionResult findById(Long id) {
        return ActionResultUtil.success("success", commentService.findById(id));
    }

    @ApiOperation("通过ID删除数据")
    @PostMapping("/deleteById")
    public ActionResult deleteById(Long id) {
        try {
            commentService.deleteById(id);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
        
    }

    @ApiOperation("插入数据")
    @PostMapping("/insert")
    public ActionResult insert(Comment comment) {
        try {
            commentService.insert(comment);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation("增加或更新评论信息")
    @PostMapping("/saveOrUpdate")
    public ActionResult saveOrUpdate(Comment comment) {
        if(comment.getId()!=null){
            try {
                comment.setCommentTime(new Date());
                commentService.saveOrUpdate(comment);
                return ActionResultUtil.success("success");
            } catch (Exception e) {
                e.printStackTrace();
                return ActionResultUtil.error(e.getMessage());
            }
        }
            return insert(comment);


    }
    @ApiOperation("批量删除Comment")
    @PostMapping("/batchDelete")
    public ActionResult batchDelete(Long[] ids){
        if (ids==null){
            return ActionResultUtil.error("失败!");
        }
        try {
            commentService.batchDelete(ids);
            return ActionResultUtil.success("成功!");
        } catch (Exception e) {
            return ActionResultUtil.error("失败!");
        }

    }

}