package com.jian.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Subscribe {

    private int id;
    private String owner;
    private String member;
    private Date subscribeTime;

}
