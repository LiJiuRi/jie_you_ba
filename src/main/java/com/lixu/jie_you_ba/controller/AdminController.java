package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname AdminController
 * @Description 管理员
 * @Date 2019-03-21 09:36
 * @Created by lixu
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    /**
     * 此时为超级管理员新建店铺的时候增加的一个管理员账号，与自己注册方式增加的管理员账号不一样
     * @param admin
     * @return
     */
    @ApiOperation(value="此时为超级管理员新建店铺的时候增加的一个管理员账号", notes="此时为超级管理员新建店铺的时候增加的一个管理员账号")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Admin insert(@RequestBody Admin admin, @CookieValue(value = "token", required = false) String token){
        logger.info("admin={}",admin);
        //获取操作人
        String personId = readCookie(token);
        if(null != personId){
            admin.setCreatePerson(personId);
        }
        adminService.insert(admin);
        return admin;
    }

    /**
     * 超级管理员审核店铺申请时，检查该账号是否已被注册过商家
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public boolean check(HttpServletRequest request) {
        String applyPersonId = request.getParameter("applyPersonId");
        // 确定是否可以审核通过
        boolean isRegister = adminService.check(Long.valueOf(applyPersonId));
        return isRegister ;
    }
}
