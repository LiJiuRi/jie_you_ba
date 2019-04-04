package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.UserCoupon;

import java.util.List;

/**
 * @Classname UserCouponService
 * @Description TODO
 * @Date 2019-04-04 23:13
 * @Created by lixu
 */
public interface UserCouponService {
    boolean check(Long coupon,String userId);
    UserCoupon insert(UserCoupon userCoupon);
    List<UserCoupon> list(Long id,String couponStatus,String userId);
}
