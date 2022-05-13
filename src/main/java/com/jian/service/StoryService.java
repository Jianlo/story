package com.jian.service;

import com.github.pagehelper.PageInfo;
import com.jian.dto.StoryConditionQueryDto;
import com.jian.dto.StoryPageDto;
import com.jian.entity.Story;

import java.util.List;

public interface StoryService {


    /**
     * 新增一个故事
     * @param story
     * @return 影响行数
     */
    void addStory(Story story);

    /**
     * 删除一个故事
     * @param sid
     * @return 影响行数
     */
    void deleteBySid(String sid);

    /**
     * 修改一个故事
     * @param story
     * @return 影响行数
     */
    void updateStory(Story story);

    /**
     * 按故事sid查询故事
     * @param sid
     * @return Story
     */
    Story findBySid(String sid);

    /**
     * 根据发布日期、阅读量、评论量、点赞量查询所有故事
     * @param storyPageDto
     * @return List<Story>
     */
    PageInfo<Story> findAllByActionId(StoryPageDto storyPageDto);

    /**
     * 按作者username查询故事
     * @param storyConditionQueryDto
     * @return List<Story>
     */
    PageInfo<Story> findByUsername(StoryConditionQueryDto storyConditionQueryDto);

    /**
     * 按故事标题查询故事，支持模糊查询
     * @param storyConditionQueryDto
     * @return List<Story>
     */
    PageInfo<Story> findByTitle(StoryConditionQueryDto storyConditionQueryDto);

    /**
     * 按标签查询故事
     * @param storyConditionQueryDto
     * @return List<Story>
     */
    PageInfo<Story> findByTag(StoryConditionQueryDto storyConditionQueryDto);

}
