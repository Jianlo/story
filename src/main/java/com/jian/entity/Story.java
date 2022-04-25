package com.jian.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Story implements Serializable {


    private static final long serialVersionUID = -1487446500687887410L;

    private String id;
    private String sid;
    private String author;
    private String title;
    private String content;
    private String createTime;
    private String updateTime;
    private String storyTag;
    private int readNum;
    private int commentNum;
    private int loveNum;
}
