package com.jian.controller;

import com.github.pagehelper.PageInfo;
import com.jian.base.ResultData;
import com.jian.dto.PageDto;
import com.jian.entity.Story;
import com.jian.service.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StoryController {

    StoryService storyService;


    //根据发布日期、阅读量、评论量、点赞量查询所有故事
    @GetMapping("/story/findAllByActionId")
    public ResultData<PageInfo<Story>> findAllByActionId(PageDto pageDto,int actionId){
        return ResultData.of(storyService.findAllByActionId(pageDto,actionId));
    }
}
