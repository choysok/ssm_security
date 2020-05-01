package com.page.ssm.controller;


import com.page.ssm.domain.UserInfo;
import com.page.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/findAll.do")
    public ModelAndView  findAll() throws Exception {
        List<UserInfo> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        System.out.println("控制层————查询所有用户");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String   save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        System.out.println("控制层————保存用户");
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("/toSavePage.do")
    public String toSavePage(){
        return "user-add";
    }


    @RequestMapping("/findById.do?${userId}")
    public ModelAndView findById(@PathVariable String userId) throws Exception {
        UserInfo user = userService.findById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user-show");

        return modelAndView;
    }
}
