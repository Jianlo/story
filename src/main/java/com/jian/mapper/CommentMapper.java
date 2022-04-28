package com.jian.mapper;

import com.jian.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 添加一条评论
     * @param comment
     * @return 影响行数
     */
    int add(Comment comment);

    /**
     * 删除一条评论
     * @param commentId
     * @return 影响行数
     */
    int delete(String commentId);

    /**
     * 删除该故事下的所有评论
     * @param sid
     * @return 影响行数
     */
    int deleteAll(String sid);

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
