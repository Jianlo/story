package com.jian.service;

import com.jian.entity.Letter;

import java.util.List;

public interface LetterService {


    /**
     * 添加一条私信记录
     * @param letter
     * @return 影响行数
     */
    void add(Letter letter);


    /**
     * 查询所有私信
     * @param sender
     * @param receiver
     * @return List<Letter>
     */
    List<Letter> findAll(String sender,String receiver);

}
