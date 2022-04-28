package com.jian.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Reading {

    private int id;
    private String readId;
    private String sid;
    private String reader;
    private Date readTime;
}
