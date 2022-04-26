package com.jian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.dto.PageDto;
import com.jian.entity.Story;
import com.jian.mapper.StoryMapper;
import com.jian.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryMapper storyMapper;

    @Override
    public void addStory(Story story) {

    }

    @Override
    public void deleteBySid(String sid) {

    }

    @Override
    public void updateStory(Story story) {

    }

    @Override
    public Story findBySid(String sid) {
        return null;
    }

    @Override
    public PageInfo<Story> findAllByActionId(PageDto pageDto, int actionId) {
        PageHelper.startPage(pageDto.getPageIndex(),pageDto.getPageSize());
        return new PageInfo<>(storyMapper.findAllByActionId(actionId));

    }

    @Override
    public PageInfo<Story> findByUid(PageDto pageDto, String uid) {
        return null;
    }

    @Override
    public PageInfo<Story> findByTitle(PageDto pageDto, String title) {
        return null;
    }

    @Override
    public PageInfo<Story> findByTag(PageDto pageDto, String storyTag) {
        return null;
    }


}
