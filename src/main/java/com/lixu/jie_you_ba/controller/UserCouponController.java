package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Coupon;
import com.lixu.jie_you_ba.entity.UserCoupon;
import com.lixu.jie_you_ba.service.CouponService;
import com.lixu.jie_you_ba.service.UserCouponService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname UserCouponController
 * @Description TODO
 * @Date 2019-04-04 23:08
 * @Created by lixu
 */
@RestController
@RequestMapping("/userCoupon")
public class UserCouponController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(UserCouponController.class);

    @Autowired
    private UserCouponService userCouponService;

    @Autowired
    private CouponService couponService;

    /**
     * 用户查询优惠卷
     * @return
     */
    @ApiOperation(value="用户查询优惠卷", notes="用户查询优惠卷")
    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
    public List<UserCoupon> list(HttpServletRequest request, @CookieValue(value = "token", required = false) String token){
        String couponStatus = request.getParameter("couponStatus");
        String id = request.getParameter("id");
        //获取操作人
        String personId = readCookie(token);
        if(couponStatus == ""){
            couponStatus = null;
        }
        List<UserCoupon> coupons;
        if(id == "" || null == id){
            coupons= userCouponService.list(null,couponStatus,personId);
            return coupons;
        }
        coupons = userCouponService.list(Long.valueOf(id),couponStatus,personId);
        return coupons;
    }

    /**
     * 用户领取优惠卷
     * @return
     */
    @ApiOperation(value="用户领取优惠卷", notes="用户领取优惠卷")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST,RequestMethod.GET})
    public boolean insert(HttpServletRequest request, @CookieValue(value = "token", required = false) String token){
        String couponId = request.getParameter("couponId");
        //获取操作人
        String personId = readCookie(token);
        //判断用户是否已经领去过该优惠卷
        boolean flag = userCouponService.check(Long.valueOf(couponId),personId);
        if(flag){
            return true;
        }
        Coupon coupon = couponService.select(Long.valueOf(couponId));
        UserCoupon userCoupon = new UserCoupon();
        BeanUtils.copyProperties(coupon,userCoupon);
        userCoupon.setUserId(personId);
        userCoupon.setCouponId(Long.valueOf(couponId));
        userCouponService.insert(userCoupon);
        return false;
    }

    /**
     * 用户取消订单，同时要修改对应优惠卷状态为未使用状态。
     * @return
     */
    @ApiOperation(value="用户领取优惠卷", notes="用户领取优惠卷")
    @RequestMapping(value = "/update", method = {RequestMethod.POST,RequestMethod.GET})
    public boolean update(@RequestParam(required = false,value = "couponId") Long couponId){
        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setId(couponId);
        userCoupon.setStatus("未使用");
        userCouponService.update(userCoupon);
        return false;
    }

}
