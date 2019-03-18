package com.lixu.jie_you_ba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2019-03-18 14:42
 * @Created by lixu
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    // index.jsp重定向到登陆界面
    @RequestMapping("/login")
    public String toLoginjsp() {

        return "login";
    }

}
