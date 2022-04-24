package com.jian.service;

import com.jian.dto.SignUpDto;
import com.jian.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 用户登录
     * @param username
     * @return User
     */
    String signIn(String username,String password);

    /**
     * 用户注册
     * @param signUpDto
     */
    String signUp(SignUpDto signUpDto);

    /**
     * 用户注销
     * @param uid
     */
    String delete(String uid);

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
     * 修改密码
     * @param password
     */
    String update(String password);

}
