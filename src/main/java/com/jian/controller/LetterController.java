package com.jian.controller;


import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.dto.LetterDto;
import com.jian.entity.Letter;
import com.jian.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class LetterController {

    @Autowired
    private LetterService letterService;

    //发送私信
    @PostMapping("/letter/sendLetter")
    public ResultData<Void> sendLetter(@RequestBody LetterDto letterDto){

        //新建一条私信记录
        Letter letter = new Letter();
        letter.setSender(letterDto.getSender());
        letter.setReceiver(letterDto.getReceiver());
        letter.setContent(letterDto.getContent());
        letter.setSendTime(new Date());

        letterService.add(letter);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "私信已发出");
    }

    //查询私信
    @GetMapping("/letter/findAll")
    public ResultData<List<Letter>> findAll(@RequestParam String sender, @RequestParam String receiver){
        return ResultData.of(letterService.findAll(sender,receiver));
    }


}
