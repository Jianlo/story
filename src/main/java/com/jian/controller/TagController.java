package com.jian.controller;


import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.entity.Tag;
import com.jian.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    //新建一个标签
    @GetMapping("/tag/addTag")
    public ResultData<Void> addTag(@RequestParam String tagName){

        //生成标签编号
        String tid = "66663443";
        Tag tag = new Tag();
        tag.setTid(tid);
        tag.setTagName(tagName);

        tagService.add(tag);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "标签创建成功");
    }

    //修改一个标签
    @PostMapping("/tag/update")
    public ResultData<Void> update(@RequestBody Tag tag){
        tagService.update(tag);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "标签修改成功");
    }


    //删除一个标签
    @GetMapping("/tag/deleteByTid")
    public ResultData<Void> deleteByTid(@RequestParam String tid){
        tagService.delete(tid);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "标签删除成功");
    }

    //获取所有标签
    @GetMapping("/tag/findAll")
    public ResultData<List<Tag>> findAll(){
        return ResultData.of(tagService.findAll());
    }
}
