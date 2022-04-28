package com.jian.service;

import com.jian.entity.Tag;

import java.util.List;

public interface TagService {

    /**
     * 新建一个标签
     * @param tag
     * @return 影响行数
     */
    void add(Tag tag);

    /**
     * 修改一个标签
     * @param tag
     * @return 影响行数
     */
    void update(Tag tag);

    /**
     * 删除一个标签
     * @param tid
     * @return 影响行数
     */
    void delete(String tid);


    /**
     * 查询所有标签
     * @return
     */
    List<Tag> findAll();
}
