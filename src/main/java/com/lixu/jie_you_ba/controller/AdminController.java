package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dao.StoreApplyMapper;
import com.lixu.jie_you_ba.dto.AdminDto;
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
import java.util.List;

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
     * 根据账号id或姓名参数获取所有未关联店铺的账号
     * @return
     */
    @ApiOperation(value="根据账号id或姓名参数获取所有未关联店铺的账号", notes="根据账号id或姓名参数获取所有未关联店铺的账号")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Admin> list(AdminDto adminDto){
        Long userIdSearch = adminDto.getUserIdSearch();
        String userNameSearch = adminDto.getUserNameSearch();
        List<Admin> adminList = adminService.listByIdOrName(userIdSearch,userNameSearch);
        return adminList;
    }

    @ApiOperation(value="获取个人信息详情", notes="获取个人信息详情")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Admin get(@CookieValue(value = "token", required = false) String token){
        String personId = readCookie(token);
        Admin admin = adminService.select(Long.valueOf(personId));
        return admin;
    }

    /**
     * 修改个人信息
     * @return
     */
    @ApiOperation(value="修改个人信息", notes="修改个人信息")
    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public boolean updateAdmin(Admin admin,@CookieValue(value = "token", required = false) String token){
        String personId = readCookie(token);
        if(admin.getName() == ""){
            admin.setName(null);
        }
        if(admin.geteMail() == ""){
            admin.seteMail(null);
        }
        if(admin.getPhone() == ""){
            admin.setPhone(null);
        }
        admin.setId(Long.valueOf(personId));
        admin.setUpdatePerson(personId);
        adminService.update(admin);
        return true;
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
        admin.setId(Long.valueOf(personId));
        if(null != id && id != ""){
            admin.setStoreId(Long.valueOf(id));
        }
        admin.setUpdatePerson(personId);

        adminService.update(admin);

        //将该申请记录对应的店铺插入店铺表中，如果没有applyPersonId传过来，则代表是普通管理员通过店铺管理员邀请其成为店铺管理员的，此时不用插入店铺表中
        if(null != applyPersonId && applyPersonId != ""){
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
        }

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
