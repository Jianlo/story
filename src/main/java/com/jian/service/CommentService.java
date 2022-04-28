package com.jian.service;

import com.jian.entity.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 添加一条评论
     * @param comment
     * @return 影响行数
     */
    void add(Comment comment);

    /**
     * 删除一条评论
     * @param commentId
     * @return 影响行数
     */
    void delete(String commentId);

    /**
     * 删除该故事下的所有评论
     * @param sid
     * @return 影响行数
     */
    void deleteAll(String sid);

    /**
     * 根据评论编号查询评论记录
     * @param commentId
     * @return Comment
     */
    Comment findByCommentId(String commentId);

    /**
     * 查询该故事下的所有评论
     * @param sid
     * @return List<Comment>
     */
    List<Comment> findAll(String sid);
}
