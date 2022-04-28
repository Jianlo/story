package com.jian.mapper;


import com.jian.dto.ReadingDto;
import com.jian.entity.Reading;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReadingMapper {

    /**
     * 添加一条阅读记录
     * @param reading
     * @return 影响行数
     */
    int add(Reading reading);

    /**
     * 修改阅读记录
     * @param reading
     * @return 影响行数
     */
    int update(Reading reading);

    /**
     * 删除一条阅读记录
     * @param readId
     * @return 影响行数
     */
    int deleteByReadId(String readId);

    /**
     * 删除该读者的所有阅读记录
     * @param reader
     * @return 影响行数
     */
    int deleteAll(String reader);

    /**
     * 查找该读者的所有阅读记录
     * @param reader
     * @return List<Reading>
     */
    List<Reading> findAll(String reader);

    /**
     * 根据故事编号和读者查询阅读记录
     * @param readingDto
     * @return Reading
     */
    Reading findBySidAndReader(ReadingDto readingDto);
}
