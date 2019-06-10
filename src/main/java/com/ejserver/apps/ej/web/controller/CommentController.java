package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Comment;
import com.ejserver.apps.ej.service.ICommentService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CommentController
 */
@RestController
@RequestMapping("comment")
public class CommentController {

    @Resource
    private ICommentService commentService;

    @GetMapping("/findAll")
    @Async
    public ActionResult findAll() {
        return ActionResultUtil.success("success", commentService.findAll());
    }

    @GetMapping("/findById")
    @Async
    public ActionResult findById(Long id) {
        return ActionResultUtil.success("success", commentService.findById(id));
    }

    @PostMapping("/deleteById")
    @Async
    public ActionResult deleteById(Long id) {
        try {
            commentService.deleteById(id);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
        
    }

    @PostMapping("/insert")
    @Async
    public ActionResult insert(Comment comment) {
        try {
            commentService.insert(comment);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    @PostMapping("/saveOrUpdate")
    @Async
    public ActionResult saveOrUpdate(Comment comment) {

        try {
            commentService.saveOrUpdate(comment);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

}