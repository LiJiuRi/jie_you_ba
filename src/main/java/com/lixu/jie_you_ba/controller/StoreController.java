package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dto.FoodDto;
import com.lixu.jie_you_ba.dto.StoreDto;
import com.lixu.jie_you_ba.entity.Account;
import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.entity.Store;
import com.lixu.jie_you_ba.service.AccountService;
import com.lixu.jie_you_ba.service.AdminService;
import com.lixu.jie_you_ba.service.StoreService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname StoreController
 * @Description 店铺管理
 * @Date 2019-03-20 21:13
 * @Created by lixu
 */
@RestController
@RequestMapping("/store")
public class StoreController extends BaseController{
    
    private static Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private StoreService storeService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AccountService accountService;

    /**
     * 新建一个店铺
     * @param store
     * @return
     */
    @ApiOperation(value="新建一个店铺", notes="新建一个店铺")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Store insert(@RequestBody Store store, @CookieValue(value = "token", required = false) String token){
        logger.info("store={}",store);
        //获取操作人
        String personId = readCookie(token);
        if(null != personId){
            store.setCreatePerson(personId);
        }
        storeService.insert(store);
        return store;
    }

    /**
     * 根据店铺id或店铺名一个店铺
     * @param
     * @return
     */
    @ApiOperation(value="根据店铺id或店铺名一个店铺", notes="根据店铺id或店铺名一个店铺")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Store> list(StoreDto storeDto){
        Long storeIdSearch = storeDto.getStoreIdSearch();
        String storeNameSearch = storeDto.getStoreNameSearch();
        List<Store> storeList  = storeService.list(storeIdSearch,storeNameSearch);
        return storeList;
    }

    /**
     * 根据店铺id获取一个店铺
     * @param
     * @return
     */
    @ApiOperation(value="根据店铺id获取一个店铺", notes="根据店铺id获取一个店铺")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Store get(HttpServletRequest request){
        String storeId = request.getParameter("storeId");
        Store store = storeService.get(Long.valueOf(storeId));
        return store;
    }

    /**
     * 超级管理员新建一个店铺
     * @param
     * @return
     */
    @ApiOperation(value="超级管理员新建一个店铺", notes="超级管理员新建一个店铺")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(HttpServletRequest request, @CookieValue(value = "token", required = false) String token){
        String storeName = request.getParameter("storeName");
        String storePhone = request.getParameter("storePhone");
        String storeAddress = request.getParameter("storeAddress");
        String storeDescription = request.getParameter("storeDescription");
        String adminName = request.getParameter("adminName");

        //新建店铺
        Store store = new Store();
        if(null != storeName)
            store.setName(storeName);
        if(null != storePhone)
            store.setPhone(storePhone);
        if(null != storeAddress)
            store.setAddress(storeAddress);
        if(null != storeDescription)
            store.setDescription(storeDescription);
        String personId = readCookie(token);
        if(null != personId) {
            store.setCreatePerson(personId);
        }
        storeService.insert(store);

        //新建一个管理员
        Admin admin = new Admin();
        admin.setStoreId(store.getId());
        if(null != adminName)
            admin.setName(adminName);
        admin.setType(0);
        if(null != personId) {
            admin.setCreatePerson(personId);
        }
        adminService.insert(admin);

        //新建一个账号
        Account account = new Account();
        account.setPersonId(admin.getId());
        //默认密码为123456
        account.setPassword("123456");
        account.setType(1);
        if(null != personId) {
            account.setCreatePerson(personId);
        }
        accountService.insert(account);

        Map map = new HashMap();
        map.put("store",store);
        map.put("admin",admin);

        return map;
    }
}
