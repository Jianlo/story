package com.jian.service;

import com.jian.dto.LoveDto;
import com.jian.entity.Love;

public interface LoveService {

    /**
     * 添加一条点赞记录
     * @param love
     * @return 影响行数
     */
    void add(Love love);

    /**
     * 删除一条点赞记录
     * @param loveDto
     * @return 影响行数
     */
    void delete(LoveDto loveDto);
}
