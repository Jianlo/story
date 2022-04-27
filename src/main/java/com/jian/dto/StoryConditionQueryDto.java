package com.jian.dto;

import lombok.Data;

@Data
public class StoryConditionQueryDto {

    //页码
    private int pageIndex;
    //页大小
    private int PageSize;
    //查询条件
    private String condition;
}
