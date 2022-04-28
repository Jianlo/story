package com.jian.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    private int id;
    private String commentId;
    private String sid;
    private String commenter;
    private String commentContent;
    private Date commentTime;
}
