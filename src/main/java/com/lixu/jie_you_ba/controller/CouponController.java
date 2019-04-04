package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Coupon;
import com.lixu.jie_you_ba.service.CouponService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public Coupon insert(Coupon coupon, @CookieValue(value = "token", required = false) String token){
        logger.info("coupon={}",coupon);
        //获取操作人
        String personId = readCookie(token);
        if(null != personId){
            coupon.setCreatePerson(personId);
        }
        couponService.insert(coupon);
        return coupon;
    }

    /**
     * 超级管理员查询优惠卷
     * @return
     */
    @ApiOperation(value="超级管理员查询优惠卷", notes="超级管理员查询优惠卷")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Coupon> insert(HttpServletRequest request){
        String couponType = request.getParameter("couponType");
        String couponStatus = request.getParameter("couponStatus");
        if(couponType == ""){
            couponType = null;
        }
        if(couponStatus == ""){
            couponStatus = null;
        }
        List<Coupon> coupons = couponService.list(couponType,couponStatus);
        return coupons;
    }

    /**
     * 超级管理员置优惠卷无效
     * @return
     */
    @ApiOperation(value="超级管理员置优惠卷无效", notes="超级管理员置优惠卷无效")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(HttpServletRequest request,@CookieValue(value = "token", required = false) String token){
        String couponId = request.getParameter("couponId");
        Coupon coupon = new Coupon();
        String personId = readCookie(token);
        if(null != personId){
            coupon.setUpdatePerson(personId);
        }
        coupon.setId(Long.valueOf(couponId));
        couponService.update(coupon);
        return true;
    }

}
