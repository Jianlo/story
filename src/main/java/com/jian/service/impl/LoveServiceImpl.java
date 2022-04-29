package com.jian.service.impl;

import com.jian.dto.LoveDto;
import com.jian.entity.Love;
import com.jian.mapper.LoveMapper;
import com.jian.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoveServiceImpl implements LoveService {

    @Autowired
    private LoveMapper loveMapper;

    @Override
    public void add(Love love) {
        loveMapper.add(love);
    }

    @Override
    public void delete(LoveDto loveDto) {
        loveMapper.delete(loveDto);
    }


}
