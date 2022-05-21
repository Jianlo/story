package com.jian.controller;


import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.dto.CommentDto;
import com.jian.entity.Comment;
import com.jian.entity.Story;
import com.jian.service.CommentService;
import com.jian.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {


    @Autowired
    private StoryService storyService;
    @Autowired
    private CommentService commentService;


    //添加一条评论
    @PostMapping("/comment/addComment")
    public ResultData<List<Comment>> addComment(@RequestBody CommentDto commentDto){

        Comment comment = new Comment();
        //生成评论编号
        String commentId = "890708";
        comment.setCommentId(commentId);
        comment.setSid(commentDto.getSid());
        comment.setCommenter(commentDto.getCommenter());
        comment.setCommentContent(commentDto.getCommentContent());
        comment.setCommentTime(new Date());
        commentService.add(comment);

        //故事评论量加1
        Story story = storyService.findBySid(commentDto.getSid());
        story.setCommentNum(story.getCommentNum()+1);
        storyService.updateStory(story);

        List<Comment> commentList = commentService.findAll(commentDto.getSid());

        return ResultData.of(commentList);

    }

    //删除一条评论
    @GetMapping("/comment/deleteByCommentId")
    public ResultData<Void> deleteByCommentId(@RequestParam String commentId){

        //获取该条评论记录
        Comment comment = commentService.findByCommentId(commentId);

        //故事评论量减1
        //查询到该条评论所属的故事
        Story story = storyService.findBySid(comment.getSid());
        story.setCommentNum(story.getCommentNum()-1);
        storyService.updateStory(story);

        //删除评论
        commentService.delete(commentId);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "该记录已被删除");
    }

    //删除所有评论
    @GetMapping("/comment/deleteBySid")
    public ResultData<Void> deleteBySid(@RequestParam String sid){

        //故事评论量清零
        Story story = storyService.findBySid(sid);
        story.setCommentNum(0);
        storyService.updateStory(story);

        //删除所有评论
        commentService.deleteAll(sid);

        return ResultData.of(StatusCode.SUCCESS.getCode(), "所有评论已被删除");
    }

    //查询所有评论
    @GetMapping("/comment/findBySid")
    public ResultData<List<Comment>> findBySid(@RequestParam String sid){
        List<Comment> commentList = commentService.findAll(sid);
        return ResultData.of(commentList);
    }
}
