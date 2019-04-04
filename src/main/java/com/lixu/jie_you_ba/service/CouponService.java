package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.Coupon;

import java.util.List;

/**
 * @Classname CouponService
 * @Description TODO
 * @Date 2019-04-03 22:41
 * @Created by lixu
 */
public interface CouponService {
    Coupon insert(Coupon coupon);
    List<Coupon> list(String couponType,String couponStatus);
    int update(Coupon coupon);
}
