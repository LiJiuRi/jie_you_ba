package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.service.StoreApplyService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname JspPageController
 * @Description 提供jsp页面间的跳转控制
 * @Date 2019-03-20 17:28
 * @Created by lixu
 */
@Controller
@RequestMapping("/jsp")
public class JspPageController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(JspPageController.class);

    @Autowired
    private StoreApplyService storeApplyService;

    /**
     * 普通用户确认店铺申请审核通过
     * @return
     */
    @ApiOperation(value="普通用户确认店铺申请审核通过", notes="普通用户确认店铺申请审核通过")
    @RequestMapping(value = "/pass", method = RequestMethod.POST)
    public String pass(HttpServletRequest request, @CookieValue(value = "token", required = false) String token){
        String storeId = request.getParameter("storeId");
        String personId = readCookie(token);
        storeApplyService.pass(Long.valueOf(personId),Long.valueOf(storeId));
        return "index";
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    /**
     * 跳转到login页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {

        return "login";
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

        return "admin";
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
