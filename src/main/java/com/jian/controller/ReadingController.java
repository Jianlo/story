package com.jian.controller;

import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.dto.ReadingDto;
import com.jian.entity.Reading;
import com.jian.entity.Story;
import com.jian.service.ReadingService;
import com.jian.service.StoryService;
import com.jian.utils.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @Autowired
    private StoryService storyService;

    //阅读故事
    @PostMapping("/read/readStory")
    public ResultData<Story> readStory(@RequestBody ReadingDto readingDto){

        Reading reading = readingService.findBySidAndReader(readingDto);
        //查找阅读记录是否存在
        if (reading != null){
            //修改最近阅读时间
            reading.setReadTime(new Date());
            readingService.update(reading);
        }
        else {
            //新增一条阅读记录
            Reading new_reading = new Reading();
            //生成记录编号
            String readId = IdGenerate.readId();
            new_reading.setReadId(readId);
            new_reading.setSid(readingDto.getSid());
            new_reading.setReader(readingDto.getReader());
            new_reading.setReadTime(new Date());

            readingService.add(new_reading);

            //故事的阅读量加1
            Story story = storyService.findBySid(readingDto.getSid());
            story.setReadNum(story.getReadNum()+1);
            storyService.updateStory(story);
        }

        return ResultData.of(storyService.findBySid(readingDto.getSid()));
    }

    @GetMapping("/read/deleteByReadId")
    //删除一条阅读记录
    public ResultData<Void> deleteByReadId(@RequestParam String readId){
        readingService.deleteByReadId(readId);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "该条记录已被删除");
    }

    @GetMapping("/read/deleteByReader")
    //删除用户所有阅读记录
    public ResultData<Void> deleteByReader(@RequestParam String reader){
        readingService.deleteAll(reader);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "所有记录已被删除");
    }

    @GetMapping("/read/findByReader")
    //查询用户所有的阅读记录
    public ResultData<Void> findByReader(@RequestParam String reader){
        readingService.findAll(reader);
        return ResultData.of();
    }

    @PostMapping("/read/findBySidAndReader")
    //查询用户指定的阅读记录
    public ResultData<Reading> findBySidAndReader(@RequestBody ReadingDto readingDto){
        Reading reading = readingService.findBySidAndReader(readingDto);
        return ResultData.of(reading);
    }
}
