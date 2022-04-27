package com.jian.dto;

import lombok.Data;


@Data
public class StoryDto {

    //故事编号
    private String sid;
    //故事作者
    private String author;
    //故事标题
    private String title;
    //故事内容
    private String content;
    //故事标签
    private String storyTag;
}
