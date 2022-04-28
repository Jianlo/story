package com.jian.dto;


import lombok.Data;

@Data
public class CommentDto {

    //故事编号
    private String sid;
    //评论人
    private String commenter;
    //评论内容
    private String commentContent;
}
