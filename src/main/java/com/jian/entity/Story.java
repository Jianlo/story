package com.jian.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Story implements Serializable {


    private static final long serialVersionUID = -1487446500687887410L;

    private int id;
    private String sid;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private Date updateTime;
    private String storyTag;
    private int readNum;
    private int commentNum;
    private int loveNum;
}
