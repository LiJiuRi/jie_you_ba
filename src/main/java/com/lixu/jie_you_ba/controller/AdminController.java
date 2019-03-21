package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 增加一个管理员账号
     * @param admin
     * @return
     */
    @ApiOperation(value="增加一个管理员账号", notes="增加一个管理员账号")
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
}
