package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dto.FoodDto;
import com.lixu.jie_you_ba.entity.Store;
import com.lixu.jie_you_ba.service.StoreService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
