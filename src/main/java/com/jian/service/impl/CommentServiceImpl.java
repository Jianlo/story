package com.jian.service.impl;

import com.jian.entity.Comment;
import com.jian.mapper.CommentMapper;
import com.jian.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }

    @Override
    public void delete(String commentId) {
        commentMapper.delete(commentId);
    }

    @Override
    public void deleteAll(String sid) {
        commentMapper.deleteAll(sid);
    }

    @Override
    public Comment findByCommentId(String commentId) {
        return commentMapper.findByCommentId(commentId);
    }

    @Override
    public List<Comment> findAll(String sid) {
        return commentMapper.findAll(sid);
    }
}
