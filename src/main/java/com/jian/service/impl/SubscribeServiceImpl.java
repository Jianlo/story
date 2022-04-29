package com.jian.service.impl;

import com.jian.dto.SubscribeDto;
import com.jian.entity.Subscribe;
import com.jian.mapper.SubscribeMapper;
import com.jian.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private SubscribeMapper subscribeMapper;

    @Override
    public void add(Subscribe subscribe) {
        subscribeMapper.add(subscribe);
    }

    @Override
    public void delete(SubscribeDto subscribeDto) {
        subscribeMapper.delete(subscribeDto);
    }

    @Override
    public List<Subscribe> findAll(String owner) {
        return subscribeMapper.findAll(owner);
    }

    @Override
    public Subscribe findByMember(SubscribeDto subscribeDto) {
        return subscribeMapper.findByMember(subscribeDto);
    }
}
