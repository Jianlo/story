package com.jian.controller;

import com.jian.base.ResultData;
import com.jian.base.StatusCode;
import com.jian.dto.ProfileDto;
import com.jian.dto.SignUpDto;
import com.jian.entity.User;
import com.jian.service.UserService;
import com.jian.utils.IdGenerate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    //用户登录
    @PostMapping("/user/signIn")
    public String signIn(@RequestParam String username, @RequestParam String password, String rememberMe, HttpServletRequest request, HttpServletResponse response){

        User user = userService.findByUsername(username);
        if (user != null){
            if (user.getPassword().equals(password)){

                logger.info("登录成功");

                //把用户信息存储在Session中
                HttpSession session = request.getSession();
                session.setAttribute("user",user);

                //如果勾选了记住密码
                if (rememberMe !=null){
                    Cookie cookie1 = new Cookie("username",user.getUsername());
                    Cookie cookie2 = new Cookie("password",user.getPassword());

                    cookie1.setPath("/");
                    cookie2.setPath("/");

                    cookie1.setMaxAge(3*24*60*60);
                    cookie2.setMaxAge(3*24*60*60);

                    response.addCookie(cookie1);
                    response.addCookie(cookie2);

                }
                //未勾选记住密码则删除用户的cookie
                else {
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null){
                        for (Cookie cookie:cookies) {
                            if (cookie.getName().equals("username") || cookie.getName().equals("password")){
                                cookie.setMaxAge(0);
                                cookie.setPath("/");
                                response.addCookie(cookie);
                            }
                        }
                    }
                }
                return "redirect:/index";
            }
            else {
                logger.info("密码错误");
                return "signIn";
            }
        }
        else {
            logger.info("用户名不存在");
            return "signIn";
        }

    }

    //用户注册
    @PostMapping("/user/signUp")
    public String signUp(SignUpDto signUpDto){

        //判断该用户名是否已被注册
        if (userService.findByUsername(signUpDto.getUsername()) != null){
            logger.info("该用户名已被注册");
            return "signUp";
        }
        else {
            User user = new User();
            //新用户的默认头像地址
            String defaultPhotoUrl = "images/profile.jpg";

            //为新用户生成唯一uid
            String uid = IdGenerate.uid();
            user.setUid(uid);
            //设置用户名
            user.setUsername(signUpDto.getUsername());
            //设置密码
            user.setPassword(signUpDto.getPassword());
            //设置邮箱
            user.setEmail(signUpDto.getEmail());
            //设置头像
            user.setPhotoUrl(defaultPhotoUrl);

            userService.addUser(user);
            logger.info("注册成功");
            return "signIn";
        }

    }

    //修改用户信息
    @PostMapping("/user/update")
    public ResultData<Void> update(@RequestBody ProfileDto profileDto){

        User user = new User();
        user.setUid(profileDto.getUid());
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
    @ResponseBody
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
