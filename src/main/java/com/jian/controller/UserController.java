package com.jian.controller;

import com.jian.entity.User;
import com.jian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @GetMapping("/user/signIn")
    @ResponseBody
    public String signIn(@RequestParam(value = "username", defaultValue = "罗健") String username, @RequestParam(value = "password", defaultValue = "123456") String password){
        return userService.signIn(username,password);
    }


}
