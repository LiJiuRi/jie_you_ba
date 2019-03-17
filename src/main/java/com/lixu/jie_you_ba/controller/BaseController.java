package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dto.LoginUserVo;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname BaseController
 * @Description 用于获取后台管理员的基本信息
 * @Date 2019-03-15 13:46
 * @Created by lixu
 */
public class BaseController {

    /**
     * 获取管理员ID
     *
     * @param httpServletRequest
     * @return
     */
    protected LoginUserVo getLoginUserInfo(HttpServletRequest httpServletRequest) {


        Object adminId = httpServletRequest.getAttribute("admin_id");

        LoginUserVo userVo = new LoginUserVo();

        String adminIdNew = adminId+"";

        if (null != adminId && !adminIdNew.isEmpty()) {
            userVo.setAdminId(Long.valueOf("" + adminId));
        } else {
            return null;
        }

        return userVo;
    }
}
