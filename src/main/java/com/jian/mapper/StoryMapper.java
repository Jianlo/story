package com.jian.mapper;

import com.jian.entity.Story;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StoryMapper {

    /**
     * 新增一个故事
     * @param story
     * @return 影响行数
     */
    int addStory(Story story);

    /**
     * 删除一个故事
     * @param sid
     * @return 影响行数
     */
    int deleteBySid(String sid);

    /**
     * 修改一个故事
     * @param story
     * @return 影响行数
     */
    int update(Story story);

    /**
     * 按故事sid查询故事
     * @param sid
     * @return Story
     */
    Story findBySid(String sid);

    /**
     * 根据发布日期、阅读量、评论量、点赞量查询所有故事
     * @param actionId (1:阅读量；2：评论量；3：点赞量）
     * @return List<Story>
     */
    List<Story> findAllByActionId(int actionId);

    /**
     * 按作者uid查询故事
     * @param uid
     * @return List<Story>
     */
    List<Story> findByUid(String uid);

    /**
     * 按故事标题查询故事，支持模糊查询
     * @param title
     * @return List<Story>
     */
    List<Story> findByTitle(String title);

    /**
     * 按标签查询故事
     * @param storyTag
     * @return
     */
    List<Story> findByTag(String storyTag);

}
