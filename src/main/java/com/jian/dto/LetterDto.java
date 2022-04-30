package com.jian.dto;

import lombok.Data;

@Data
public class LetterDto {

    //发送者
    private String sender;
    //接收者
    private String receiver;
    //私信内容
    private String content;
}
