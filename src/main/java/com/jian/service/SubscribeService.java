package com.jian.service;

import com.jian.dto.SubscribeDto;
import com.jian.entity.Subscribe;

import java.util.List;

public interface SubscribeService {

    /**
     * 添加一条关注记录
     * @param subscribe
     * @return 影响行数
     */
    void add(Subscribe subscribe);

    /**
     * 删除一条关注记录
     * @param subscribeDto
     * @return 影响行数
     */
    void delete(SubscribeDto subscribeDto);

    /**
     * 查询该用户所有的关注
     * @param owner
     * @return List<Subscribe>
     */
    List<Subscribe> findAll(String owner);

    /**
     * 查询该用户指定的关注
     * @param subscribeDto
     * @return Subscribe
     */
    Subscribe findByMember(SubscribeDto subscribeDto);
}
