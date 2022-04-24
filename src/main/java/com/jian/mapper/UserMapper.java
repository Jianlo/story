package com.jian.mapper;

import com.jian.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

    /**
     * 根据username查询用户
     * @param username
     * @return User
     */
    User findByUsername(String username);

    /**
     * 根据uid查询用户
     * @param uid
     * @return User
     */
    User findByUid(String uid);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> findAll();

    /**
     * 添加一个用户
     * @param user
     * @return 影响行数
     */
    int addUser(User user);

    /**
     * 根据uid删除用户
     * @param uid
     * @return 影响行数
     */
    int deleteByUid(String uid);

    /**
     * 修改用户信息
     * @param user
     * @return 影响行数
     */
    int update(User user);
}
