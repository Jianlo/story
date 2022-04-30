package com.jian.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Letter {

    private int id;
    private String sender;
    private String receiver;
    private String content;
    private Date sendTime;
}
