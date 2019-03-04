package com.lixu.jie_you_ba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Classname Test
 * @Description TODO
 * @Date 2019-03-03 12:18
 * @Created by lixu
 */
@Controller
@RequestMapping(value = {"/hello"})
public class TestController {

    @RequestMapping(value = {"/springboot"})
    public String hello(){
        return "index";
    }
}
