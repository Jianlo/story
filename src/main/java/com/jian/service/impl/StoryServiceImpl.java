package com.jian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.dto.StoryConditionQueryDto;
import com.jian.dto.StoryPageDto;
import com.jian.entity.Story;
import com.jian.mapper.StoryMapper;
import com.jian.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryMapper storyMapper;

    @Override
    public void addStory(Story story) {
        storyMapper.addStory(story);

    }

    @Override
    public void deleteBySid(String sid) {
        storyMapper.deleteBySid(sid);

    }

    @Override
    public void updateStory(Story story) {
        storyMapper.update(story);

    }

    @Override
    public Story findBySid(String sid) {
        return storyMapper.findBySid(sid);
    }

    @Override
    public PageInfo<Story> findAllByActionId(StoryPageDto storyPageDto) {
        PageHelper.startPage(storyPageDto.getPageIndex(), storyPageDto.getPageSize());
        return new PageInfo<>(storyMapper.findAllByActionId(storyPageDto.getActionId()));

    }

    @Override
    public PageInfo<Story> findByUsername(StoryConditionQueryDto storyConditionQueryDto) {
        PageHelper.startPage(storyConditionQueryDto.getPageIndex(),storyConditionQueryDto.getPageSize());
        return new PageInfo<>(storyMapper.findByUsername(storyConditionQueryDto.getCondition()));
    }

    @Override
    public PageInfo<Story> findByInput(StoryConditionQueryDto storyConditionQueryDto) {
        PageHelper.startPage(storyConditionQueryDto.getPageIndex(),storyConditionQueryDto.getPageSize());
        return new PageInfo<>(storyMapper.findByInput(storyConditionQueryDto.getCondition()));
    }

    @Override
    public PageInfo<Story> findByTag(StoryConditionQueryDto storyConditionQueryDto) {
        PageHelper.startPage(storyConditionQueryDto.getPageIndex(),storyConditionQueryDto.getPageSize());
        return new PageInfo<>(storyMapper.findByTag(storyConditionQueryDto.getCondition()));
    }


}
