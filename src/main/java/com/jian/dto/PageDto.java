package com.jian.dto;


import lombok.Data;

@Data
public class PageDto {

    //页码
    private int pageIndex;
    //页大小
    private int pageSize;
}
