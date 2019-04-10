package com.lixu.jie_you_ba.controller;

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
     * 超级管理员新建一个店铺
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
     * 超级管理员根据店铺id或店铺名获取一个店铺
     * @param
     * @return
     */
    @ApiOperation(value="超级管理员根据店铺id或店铺名获取一个店铺", notes="超级管理员根据店铺id或店铺名获取一个店铺")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Store> list(StoreDto storeDto){
        Long storeIdSearch = storeDto.getStoreIdSearch();
        String storeNameSearch = storeDto.getStoreNameSearch();
        String storeTypeSearch = storeDto.getStoreTypeSearch();
        List<Store> storeList  = storeService.list(storeIdSearch,storeNameSearch,storeTypeSearch);
        return storeList;
    }


    /**
     * 微信小程序端调用获取店铺，因为小程序调用post方式会出现问题，所以复制一份单独给小程序用
     * @param
     * @return
     */
    @ApiOperation(value="微信小程序端调用获取店铺", notes="微信小程序端调用获取店铺")
    @RequestMapping(value = "/storeList", method = RequestMethod.GET)
    public List<Store> storeList(HttpServletRequest request){
        String storeNameSearch = request.getParameter("storeNameSearch");
        Long storeIdSearch = null;
        String storeTypeSearch = request.getParameter("storeTypeSearch");
        List<Store> storeList  = storeService.list(storeIdSearch,storeNameSearch,storeTypeSearch);
        return storeList;
    }

    /**
     * 根据店铺id获取一个店铺
     * @param
     * @return
     */
    @ApiOperation(value="根据店铺id获取一个店铺", notes="根据店铺id获取一个店铺")
    @RequestMapping(value = "/get", method = {RequestMethod.POST,RequestMethod.GET})
    public Store get(HttpServletRequest request){
        String storeId = request.getParameter("storeId");
        Store store = storeService.get(Long.valueOf(storeId));
        return store;
    }

    /**根据店铺管理员id获取一个店铺
     * @param
     * @return
     */
    @ApiOperation(value="根据店铺管理员id获取一个店铺", notes="根据管理员id过去一个店铺")
    @RequestMapping(value = "/getStoreByAdminId", method = RequestMethod.POST)
    public Store getStoreByAdminId(@CookieValue(value = "token", required = false) String token){
        String adminId = readCookie(token);
        Admin admin = adminService.select(Long.valueOf(adminId));
        Store store = storeService.get(admin.getStoreId());
        return store;
    }

    /**
     * 根据店铺id删除一个店铺
     * @param
     * @return
     */
    @ApiOperation(value="根据店铺id删除一个店铺", notes="根据店铺id删除一个店铺")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(HttpServletRequest request,@CookieValue(value = "token", required = false) String token){
        String storeId = request.getParameter("storeId");
        //获取操作人
        String personId = readCookie(token);
        adminService.setStoreIdNull(Long.valueOf(storeId),personId);

        return storeService.delete(Long.valueOf(storeId));
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
        String storeType = request.getParameter("storeType");
        String storePhone = request.getParameter("storePhone");
        String storeAddress = request.getParameter("storeAddress");
        String storeDescription = request.getParameter("storeDescription");
        String adminName = request.getParameter("adminName");

        //新建店铺
        Store store = new Store();
        if(null != storeName && storeName != "")
            store.setName(storeName);
        if(null != storeType && storeType != "")
            store.setType(storeType);
        if(null != storePhone && storePhone != "")
            store.setPhone(storePhone);
        if(null != storeAddress && storeAddress != "")
            store.setAddress(storeAddress);
        if(null != storeDescription && storeDescription != "")
            store.setDescription(storeDescription);
        String personId = readCookie(token);
        if(null != personId) {
            store.setCreatePerson(personId);
        }
        storeService.insert(store);

        //新建一个管理员
        Admin admin = new Admin();
        admin.setStoreId(store.getId());
        if(null != adminName && adminName != "")
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

    /**
     * 超级管理员修改一个店铺
     * @param
     * @return
     */
    @ApiOperation(value="超级管理员修改一个店铺", notes="超级管理员修改一个店铺")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Store modify(HttpServletRequest request, @CookieValue(value = "token", required = false) String token){

        String storeName = request.getParameter("storeName");
        String storeType = request.getParameter("storeType");
        String storePhone = request.getParameter("storePhone");
        String storeAddress = request.getParameter("storeAddress");
        String storeDescription = request.getParameter("storeDescription");
        String storeBusStop = request.getParameter("storeBusStop");
        String storeBusStopDistance = request.getParameter("storeBusStopDistance");
        String storeSubwayStation = request.getParameter("storeSubwayStation");
        String storeSubwayStationDistance = request.getParameter("storeSubwayStationDistance");
        String storeDeliveryTime = request.getParameter("storeDeliveryTime");
        String storeDeliveryType = request.getParameter("storeDeliveryType");
        String storeDeliveryInitPrice = request.getParameter("storeDeliveryInitPrice");
        String storeDeliveryCost = request.getParameter("storeDeliveryCost");
        String storeWifiName = request.getParameter("storeWifiName");
        String storeWifiPassword = request.getParameter("storeWifiPassword");
        String storeOpenTime = request.getParameter("storeOpenTime");
        String storeId = request.getParameter("storeId");


        //新建店铺
        Store store = new Store();
        store.setId(Long.valueOf(storeId));
        if(null != storeName && storeName != "")
            store.setName(storeName);
        if(null != storeType && storeType != "")
            store.setType(storeType);
        if(null != storePhone && storePhone != "")
            store.setPhone(storePhone);
        if(null != storeAddress && storeAddress != "")
            store.setAddress(storeAddress);
        if(null != storeDescription && storeDescription != "")
            store.setDescription(storeDescription);
        if(null != storeBusStop && storeBusStop != "")
            store.setBusStop(storeBusStop);
        if(null != storeBusStopDistance && storeBusStopDistance != "")
            store.setBusStopDistance(storeBusStopDistance);
        if(null != storeSubwayStation && storeSubwayStation != "")
            store.setSubwayStation(storeSubwayStation);
        if(null != storeSubwayStationDistance && storeSubwayStationDistance != "")
            store.setSubwayStationDistance(storeSubwayStationDistance);
        if(null != storeDeliveryTime && storeDeliveryTime != "")
            store.setDeliveryTime(storeDeliveryTime);
        if(null != storeDeliveryType && storeDeliveryType != "")
            store.setDeliveryType(storeDeliveryType);
        if(null != storeDeliveryInitPrice && storeDeliveryInitPrice != "")
            store.setDeliveryInitPrice(storeDeliveryInitPrice);
        if(null != storeDeliveryCost && storeDeliveryCost != "")
            store.setDeliveryCost(storeDeliveryCost);
        if(null != storeWifiName && storeWifiName != "")
            store.setWifiName(storeWifiName);
        if(null != storeWifiPassword && storeWifiPassword != "")
            store.setWifiPassword(storeWifiPassword);
        if(null != storeOpenTime && storeOpenTime != "")
            store.setOpenTime(storeOpenTime);


        String personId = readCookie(token);
        if(null != personId) {
            store.setUpdatePerson(personId);
        }

        storeService.update(store);

        Store store1 = storeService.get(Long.valueOf(storeId));

        return store1;
    }
}
