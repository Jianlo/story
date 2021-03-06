package com.jian.controller;

import com.github.pagehelper.PageInfo;
import com.jian.dto.StoryPageDto;
import com.jian.entity.Story;
import com.jian.entity.Subscribe;
import com.jian.entity.User;
import com.jian.service.StoryService;
import com.jian.service.SubscribeService;
import com.jian.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PageController {

    @Autowired
    private StoryService storyService;
    @Autowired
    private SubscribeService subscribeService;

    @Autowired
    private TagService tagService;

    //登录界面
    @RequestMapping("/")
    public String login(){
        return "signIn";
    }

    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "signIn";
    }

    //注册界面
    @RequestMapping("/register")
    public String register(){
        return "signUp";
    }

    //写故事界面
    @RequestMapping("/write")
    public String write(Model model){
        //获取标签列表
        model.addAttribute("tagList",tagService.findAll());
        return "editor";
    }

    //主页
    @GetMapping("/index")
    public String index(Model model,HttpSession session){

        //分页查询所有故事
        StoryPageDto storyPageDto = new StoryPageDto();
        storyPageDto.setPageSize(5);
        storyPageDto.setPageIndex(1);
        storyPageDto.setActionId(1);
        PageInfo<Story> storyPage = storyService.findAllByActionId(storyPageDto);

        //获取结果集长度
        int length = storyPage.getSize();

        //新建一个List用于获取PageInfo里面的结果集
        List<Story> storyList = new ArrayList<Story>();
        for (int i = 0;i < length;i++){

            //由于storyPage.getList()得到的并不是一个List而是一个PageInfo对象，所以采取这样的方法
            storyList.add(storyPage.getList().get(i));
        }

        model.addAttribute("storyList",storyList);

        //查询用户所有的好友
        User user = (User) session.getAttribute("user");
        String owner = user.getUsername();
        List<Subscribe> subscribeList = subscribeService.findAll(owner);
        model.addAttribute("subscribeList",subscribeList);

        //查询标签列表
        model.addAttribute("tagList",tagService.findAll());

        return "index";
    }

    //获取Session中存的user
    @GetMapping("/getSession")
    @ResponseBody
    public User getSession(HttpSession session){
        return (User) session.getAttribute("user");
    }
}
