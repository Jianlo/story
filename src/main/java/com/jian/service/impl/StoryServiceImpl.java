package com.jian.service.impl;

import com.jian.entity.Story;
import com.jian.service.StoryService;

import java.util.List;

public class StoryServiceImpl implements StoryService {
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
    public List<Story> findAllByActionId(int actionId) {
        return null;
    }

    @Override
    public List<Story> findByUid(String uid) {
        return null;
    }

    @Override
    public List<Story> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Story> findByTag(String storyTag) {
        return null;
    }
}
