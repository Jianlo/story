package com.jian.controller;

import com.jian.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class PageController {

    //登录界面
    @RequestMapping("/")
    public String login(){
        return "signIn";
    }

    //注册界面
    @RequestMapping("/register")
    public String register(){
        return "signUp";
    }

    //写故事界面
    @RequestMapping("/write")
    public String write(){
        return "editor";
    }

    //主页
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //获取Session中存的user
    @GetMapping("/getSession")
    @ResponseBody
    public User getSession(HttpSession session){
        return (User) session.getAttribute("user");
    }
}
