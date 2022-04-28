package com.jian.mapper;

import com.jian.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TagMapper {

    /**
     * 新建一个标签
     * @param tag
     * @return 影响行数
     */
    int add(Tag tag);

    /**
     * 修改一个标签
     * @param tag
     * @return 影响行数
     */
    int update(Tag tag);

    /**
     * 删除一个标签
     * @param tid
     * @return 影响行数
     */
    int delete(String tid);


    /**
     * 查询所有标签
     * @return
     */
    List<Tag> findAll();
}
