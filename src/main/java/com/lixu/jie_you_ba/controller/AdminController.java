package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dao.StoreApplyMapper;
import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.entity.Store;
import com.lixu.jie_you_ba.entity.StoreApply;
import com.lixu.jie_you_ba.service.AdminService;
import com.lixu.jie_you_ba.service.StoreService;
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

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreApplyMapper storeApplyMapper;

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
     * 普通账号更换为店铺管理员账号
     * @return
     */
    @ApiOperation(value="普通账号更换为店铺管理员账号", notes="普通账号更换为店铺管理员账号")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(HttpServletRequest request,@CookieValue(value = "token", required = false) String token){

        String personId = readCookie(token);
        String id = request.getParameter("id");
        String applyPersonId = request.getParameter("applyPersonId");

        //更改对应账号的状态
        Admin admin = new Admin();
        if(null != applyPersonId && applyPersonId != ""){
            admin.setId(Long.valueOf(applyPersonId));
        }
        if(null != id && id != ""){
            admin.setStoreId(Long.valueOf(id));
        }
        admin.setUpdatePerson(personId);

        adminService.update(admin);

        //将该申请记录对应的店铺插入店铺表中
        StoreApply storeApply = storeApplyMapper.selectByPrimaryKey(Long.valueOf(id));
        Store store = new Store();
        store.setId(storeApply.getId());
        store.setName(storeApply.getName());
        store.setType(storeApply.getType());
        store.setPhone(storeApply.getPhone());
        store.setAddress(storeApply.getAddress());
        store.setDescription(storeApply.getDescription());
        store.setCreatePerson(personId);

        storeService.add(store);

        return true;
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
