package com.lixu.jie_you_ba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname JspPageController
 * @Description 提供jsp页面间的跳转控制
 * @Date 2019-03-20 17:28
 * @Created by lixu
 */
@Controller
@RequestMapping("/jsp")
public class JspPageController {

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register() {

        return "register";
    }

    /**
     * 跳转到超级管理员页面
     * @return
     */
    @RequestMapping("/manager")
    public String manager() {

        return "manager";
    }

    /**
     * 跳转到店铺管理员页面
     * @return
     */
    @RequestMapping("/user")
    public String user() {

        return "user";
    }

}
