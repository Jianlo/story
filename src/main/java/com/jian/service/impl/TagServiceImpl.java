package com.jian.service.impl;

import com.jian.entity.Tag;
import com.jian.mapper.TagMapper;
import com.jian.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void add(Tag tag) {
        tagMapper.add(tag);
    }

    @Override
    public void update(Tag tag) {
        tagMapper.update(tag);
    }

    @Override
    public void delete(String tid) {
        tagMapper.delete(tid);
    }

    @Override
    public List<Tag> findAll() {
        return tagMapper.findAll();
    }
}
