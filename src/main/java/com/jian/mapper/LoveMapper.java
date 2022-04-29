package com.jian.mapper;

import com.jian.dto.LoveDto;
import com.jian.entity.Love;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LoveMapper {


    /**
     * 添加一条点赞记录
     * @param love
     * @return 影响行数
     */
    int add(Love love);

    /**
     * 删除一条点赞记录
     * @param loveDto
     * @return 影响行数
     */
    int delete(LoveDto loveDto);
}
