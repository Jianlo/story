package com.jian.service;

import com.jian.dto.SignUpDto;
import com.jian.entity.User;

import java.util.List;

public interface UserService {


    /**
     * 新增一个用户
     * @param user
     */
    void addUser(User user);

    /**
     * 删除一个用户
     * @param uid
     */
    void delete(String uid);

    /**
     * 根据uid查询用户
     * @param uid
     * @return User
     */
    User findByUid(String uid);

    /**
     * 根据username查询用户
     * @param username
     * @return User
     */
    User findByUsername(String username);

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);

}
