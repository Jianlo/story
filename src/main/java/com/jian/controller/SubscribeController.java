package com.jian.controller;


import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.dto.SubscribeDto;
import com.jian.entity.Subscribe;
import com.jian.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    //添加关注
    @PostMapping("/subscribe/add")
    public ResultData<List<Subscribe>> add(@RequestBody SubscribeDto subscribeDto){

        //新建关注记录
        Subscribe subscribe = new Subscribe();
        subscribe.setOwner(subscribeDto.getOwner());
        subscribe.setMember(subscribeDto.getMember());
        subscribe.setSubscribeTime(new Date());

        subscribeService.add(subscribe);
        List<Subscribe> subscribeList = subscribeService.findAll(subscribeDto.getOwner());

        return ResultData.of(subscribeList);
    }

    //取消关注
    @PostMapping("/subscribe/delete")
    public ResultData<Void> delete(@RequestBody SubscribeDto subscribeDto){

        subscribeService.delete(subscribeDto);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "已取消关注");
    }

    //查询所有关注
    @GetMapping("/subscribe/findAll")
    public ResultData<List<Subscribe>> findAll(@RequestParam String owner){
        return ResultData.of(subscribeService.findAll(owner));
    }

    //查询指定关注
    @PostMapping("/subscribe/findByMember")
    public ResultData<Subscribe> findByMember(@RequestBody SubscribeDto subscribeDto){
        return ResultData.of(subscribeService.findByMember(subscribeDto));
    }
}
