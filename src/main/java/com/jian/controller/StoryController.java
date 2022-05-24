package com.jian.controller;

import com.github.pagehelper.PageInfo;
import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.dto.StoryConditionQueryDto;
import com.jian.dto.StoryDto;
import com.jian.dto.StoryPageDto;
import com.jian.entity.Story;
import com.jian.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class StoryController {

    @Autowired
    StoryService storyService;


    //发布新故事
    @PostMapping("/story/addStory")
    public ResultData<Void> addStory(StoryDto storyDto){

        //生成故事编号
        String sid = "2222234";
        //获取故事发布时间
        Date createTime = new Date();
        Date updateTime = new Date();
        Story story = new Story();

        story.setSid(sid);
        story.setAuthor(storyDto.getAuthor());
        story.setTitle(storyDto.getTitle());
        story.setContent(storyDto.getContent());
        story.setStoryTag(storyDto.getStoryTag());
        story.setCreateTime(createTime);
        story.setUpdateTime(updateTime);

        //初始化故事的阅读量、评论量、点赞量
        story.setReadNum(0);
        story.setCommentNum(0);
        story.setLoveNum(0);

        storyService.addStory(story);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "发布故事成功");
    }

    //删除故事
    @GetMapping("/story/deleteBySid")
    public ResultData<Void> deleteBySid(@RequestParam String sid){
        storyService.deleteBySid(sid);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "故事已删除");
    }

    //修改故事标题、内容、标签
    @PostMapping("/story/update")
    public ResultData<Void> update(@RequestBody StoryDto storyDto){

        Story story = new Story();
        story.setSid(storyDto.getSid());
        story.setTitle(storyDto.getTitle());
        story.setContent(storyDto.getContent());
        story.setStoryTag(storyDto.getStoryTag());
        //更新修改时间
        story.setUpdateTime(new Date());

        storyService.updateStory(story);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "故事修改成功");

    }

    //根据故事编号查询故事
    @GetMapping("/story/findBySid")
    public ResultData<Story> findBySid(@RequestParam String sid){
        return ResultData.of(storyService.findBySid(sid));
    }


    //根据发布日期、阅读量、评论量、点赞量查询所有故事
    @PostMapping("/story/findAllByActionId")
    public ResultData<PageInfo<Story>> findAllByActionId(@RequestBody StoryPageDto storyPageDto){
        return ResultData.of(storyService.findAllByActionId(storyPageDto));
    }

    //根据用户名查询所有故事
    @PostMapping("/story/findByUsername")
    public ResultData<PageInfo<Story>> findByUsername(@RequestBody StoryConditionQueryDto storyConditionQueryDto){
        return ResultData.of(storyService.findByInput(storyConditionQueryDto));
    }

    //根据标题或用户名查询所有故事
    @PostMapping("/story/findByInput")
    public ResultData<PageInfo<Story>> findByInput(@RequestBody StoryConditionQueryDto storyConditionQueryDto){
        return ResultData.of(storyService.findByInput(storyConditionQueryDto));
    }

    //根据标签查询所有故事
    @PostMapping("/story/findByTag")
    public ResultData<PageInfo<Story>> findByTag(@RequestBody StoryConditionQueryDto storyConditionQueryDto){
        return ResultData.of(storyService.findByTag(storyConditionQueryDto));
    }
}
