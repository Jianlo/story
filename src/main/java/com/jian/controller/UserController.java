package com.jian.controller;

import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.dto.ProfileDto;
import com.jian.dto.SignUpDto;
import com.jian.entity.User;
import com.jian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @GetMapping("/user/signIn")
    @ResponseBody
    public ResultData<Void> signIn(@RequestParam(value = "username", defaultValue = "罗健") String username, @RequestParam(value = "password", defaultValue = "123456") String password){

        User user = userService.findByUsername(username);
        if (user != null){
            if (user.getPassword().equals(password)){
                return ResultData.of(StatusCode.SUCCESS.getCode(), "登录成功");
            }
            else {
                return ResultData.of(StatusCode.ERROR.getCode(), "密码错误");
            }
        }
        else {
            return ResultData.of(StatusCode.ERROR.getCode(), "用户名不存在");
        }

    }

    //用户注册
    @GetMapping("/user/signUp")
    public ResultData<Void> signUp(@RequestBody SignUpDto signUpDto){

        //判断该用户名是否已被注册
        if (userService.findByUsername(signUpDto.getUsername()) != null){
            return ResultData.of(StatusCode.ERROR.getCode(),"该用户名已被注册");
        }
        else {
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

            userService.addUser(user);
            return ResultData.of(StatusCode.SUCCESS.getCode(), "注册成功");
        }

    }

    //修改用户信息
    @GetMapping("/user/update")
    public ResultData<Void> update(@RequestBody ProfileDto profileDto){

        User user = new User();
        user.setUsername(profileDto.getUsername());
        user.setPassword(profileDto.getPassword());
        user.setEmail(profileDto.getEmail());
        user.setPhotoUrl(profileDto.getPhotoUrl());

        userService.update(user);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "修改成功");
    }

    //用户注销
    @GetMapping("/user/delete")
    public ResultData<Void> delete(@RequestParam String uid){
        userService.delete(uid);
        return ResultData.of(StatusCode.SUCCESS.getCode(), "注销成功");
    }

    //按uid查询用户
    @GetMapping("/user/findByUid")
    public ResultData<User> findByUid(@RequestParam String uid){
        return ResultData.of(userService.findByUid(uid));
    }

    //按用户名查询用户
    @GetMapping("/user/findByUsername")
    public ResultData<User> findByUsername(@RequestParam String username){
        return ResultData.of(userService.findByUsername(username));
    }

    //查询所有用户
    @GetMapping("/user/findAll")
    public ResultData<List<User>> findAll(){
        return ResultData.of(userService.findAll());
    }


}
