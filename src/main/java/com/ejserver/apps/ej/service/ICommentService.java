package com.ejserver.apps.ej.service;

import java.util.List;

import com.ejserver.apps.ej.bean.Comment;

/**
 * ICommentService
 */
public interface ICommentService {

    
    List<Comment> findAll();
    Comment findById(Long id);
    int deleteById(Long id) throws Exception;
    int insert(Comment comment) throws Exception;
    int saveOrUpdate(Comment comment) throws Exception;
}