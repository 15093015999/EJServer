package com.ejserver.apps.ej.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Comment;
import com.ejserver.apps.ej.bean.CommentExample;
import com.ejserver.apps.ej.dao.CommentMapper;
import com.ejserver.apps.ej.service.ICommentService;

import org.springframework.stereotype.Service;

/**
 * CommentServiceImpl
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findAll() {
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment findById(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) throws Exception {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment comment) throws Exception {
        return commentMapper.insert(comment);
    }

    @Override
    public int saveOrUpdate(Comment comment) throws Exception {
        return commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    public List<Comment> findByOrderId(Long id) {
        CommentExample example =new CommentExample();
        example.createCriteria().andOrderIdEqualTo(id);
        return commentMapper.selectByExample(example);
    }

    @Override
    public void batchDelete(Long[] ids){
        for (Long id:
                ids ) {
            commentMapper.deleteByPrimaryKey(id);
        }
    }


}