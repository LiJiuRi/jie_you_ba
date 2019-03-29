package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dto.LoginUserVo;
import com.lixu.jie_you_ba.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname BaseController
 * @Description 用于获取后台管理员的基本信息
 * @Date 2019-03-15 13:46
 * @Created by lixu
 */
public class BaseController {

    private static Logger logger = LoggerFactory.getLogger(FoodController.class);

    @Autowired
    private JwtService jwtService;

    /**
     * 创建token并写入cookie
     *
     * @param response
     * @param personId
     */
    protected void writeCookie(HttpServletResponse response, String personId) {
        String token = null;
        token = jwtService.create(personId);
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(1 * 24 * 60 * 60);// 设置时间为1天
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 读取cookie中的token并解析为personId
     *
     * @param token
     * @return
     */
    protected String readCookie(String token) {
        if (token == null) {
            return null;
        }
        String personId = jwtService.getPersonId(token);
        return personId;
    }
}
