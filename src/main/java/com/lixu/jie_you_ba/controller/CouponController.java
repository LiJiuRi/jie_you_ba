package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Coupon;
import com.lixu.jie_you_ba.entity.Store;
import com.lixu.jie_you_ba.service.CouponService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname CouponController
 * @Description TODO
 * @Date 2019-04-03 22:35
 * @Created by lixu
 */
@RestController
@RequestMapping("/coupon")
public class CouponController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private CouponService couponService;

    /**
     * 超级管理员发放一个优惠卷
     * @param coupon
     * @return
     */
    @ApiOperation(value="新建一条优惠卷", notes="新建一条优惠卷")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Coupon insert(@RequestBody Coupon coupon, @CookieValue(value = "token", required = false) String token){
        logger.info("coupon={}",coupon);
        //获取操作人
        String personId = readCookie(token);
        if(null != personId){
            coupon.setCreatePerson(personId);
        }
        couponService.insert(coupon);
        return coupon;
    }

}
