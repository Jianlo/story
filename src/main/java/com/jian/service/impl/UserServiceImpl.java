package com.jian.service.impl;

import com.jian.dto.SignUpDto;
import com.jian.entity.User;
import com.jian.mapper.UserMapper;
import com.jian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delete(String uid) {
        userMapper.deleteByUid(uid);
    }

    @Override
    public User findByUid(String uid) {
        return userMapper.findByUid(uid);
    }


    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }


}
