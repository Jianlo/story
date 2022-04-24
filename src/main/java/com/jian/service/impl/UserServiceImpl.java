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

    //用户登录
    @Override
    public String signIn(String username,String password) {
        User user = userMapper.findByUsername(username);
        if (user != null){
            if (user.getPassword().equals(password)){
                return "登录成功";
            }
            else {
                return "密码错误";
            }
        }
        else {
            return "用户名不存在";
        }
    }

    //用户注册
    @Override
    public String signUp(SignUpDto signUpDto) {

        User user = new User();
        //新用户的默认头像地址
        String defaultPhotoUrl = "http://photo.com/default.jpg";

        //为新用户生成唯一uid
        user.setUid("322342");
        //设置用户名
        user.setUsername(signUpDto.getUsername());
        //设置密码
        user.setPassword(signUpDto.getPassword());
        //设置邮箱
        user.setEmail(signUpDto.getEmail());
        //设置头像
        user.setPhotoUrl(defaultPhotoUrl);

        if (userMapper.addUser(user) > 0){
            return "注册成功";
        }
        else {
            return "注册失败";
        }

    }

    //用户注销
    @Override
    public String delete(String uid) {
        if (userMapper.deleteByUid(uid) > 0){
            return "注销成功";
        }
        else {
            return "注销失败";
        }
    }

    //根据uid查询用户
    @Override
    public User findByUid(String uid) {
        return userMapper.findByUid(uid);
    }

    //根据用户名查询用户
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    //查询所有用户
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    //修改密码
    @Override
    public String update(String password) {
        User user = new User();
        user.setPassword(password);
        if (userMapper.update(user) > 0){
            return "密码修改成功";
        }
        else {
            return "密码修改失败";
        }
    }


}
