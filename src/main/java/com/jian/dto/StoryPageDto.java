package com.jian.dto;


import lombok.Data;

@Data
public class StoryPageDto {

    //页码
    private int pageIndex;
    //页大小
    private int pageSize;

    //操作id，默认按发布时间查询；1:按阅读量查询；2：按评论量查询；3：按点赞量查询
    private int actionId;
}
