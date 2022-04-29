package com.jian.mapper;

import com.jian.dto.SubscribeDto;
import com.jian.entity.Subscribe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscribeMapper {

    /**
     * 添加一条关注记录
     * @param subscribe
     * @return 影响行数
     */
    int add(Subscribe subscribe);

    /**
     * 删除一条关注记录
     * @param subscribeDto
     * @return 影响行数
     */
    int delete(SubscribeDto subscribeDto);

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
