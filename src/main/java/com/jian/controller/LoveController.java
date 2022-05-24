package com.jian.controller;

import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.dto.LoveDto;
import com.jian.entity.Love;
import com.jian.entity.Story;
import com.jian.service.LoveService;
import com.jian.service.StoryService;
import com.jian.utils.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoveController {

    @Autowired
    private LoveService loveService;
    @Autowired
    private StoryService storyService;


    //点赞
    @PostMapping("/love/addLove")
    public ResultData<Void> addLove(@RequestBody LoveDto loveDto){

        //新建一条点赞记录
        Love love = new Love();
        //生成记录编号
        String loveId = IdGenerate.loveId();
        love.setLoveId(loveId);
        love.setSid(loveDto.getSid());
        love.setFans(loveDto.getFans());
        love.setLoveTime(new Date());
        loveService.add(love);

        //故事的点赞量加1
        Story story = storyService.findBySid(loveDto.getSid());
        story.setLoveNum(story.getLoveNum()+1);
        storyService.updateStory(story);

        return ResultData.of(StatusCode.SUCCESS.getCode(), "点赞成功");
    }

    //取消点赞
    @PostMapping("/love/deleteLove")
    public ResultData<Void> deleteLove(@RequestBody LoveDto loveDto){

        //删除点赞记录
        loveService.delete(loveDto);

        //故事的点赞量减1
        Story story = storyService.findBySid(loveDto.getSid());
        story.setLoveNum(story.getLoveNum()-1);
        storyService.updateStory(story);

        return ResultData.of(StatusCode.SUCCESS.getCode(), "点赞已取消");

    }

}
