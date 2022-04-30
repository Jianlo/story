package com.jian.mapper;


import com.jian.entity.Letter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LetterMapper {


    /**
     * 添加一条私信记录
     * @param letter
     * @return 影响行数
     */
    int add(Letter letter);


    /**
     * 查询所有私信
     * @param sender
     * @param receiver
     * @return List<Letter>
     */
    List<Letter> findAll(@Param("sender") String sender, @Param("receiver") String receiver);

}
