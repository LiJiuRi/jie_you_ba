package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.UserCouponMapper;
import com.lixu.jie_you_ba.entity.UserCoupon;
import com.lixu.jie_you_ba.service.UidService;
import com.lixu.jie_you_ba.service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname UserCouponServiceImpl
 * @Description TODO
 * @Date 2019-04-04 23:14
 * @Created by lixu
 */
@Service
public class UserCouponServiceImpl implements UserCouponService {

    @Autowired
    private UserCouponMapper userCouponMapper;

    @Autowired
    private UidService uidService;

    @Override
    public boolean check(Long coupon, String userId) {
        UserCoupon userCoupon = userCouponMapper.check(coupon,userId);
        if(null == userCoupon){
            return false;
        }
        return true;
    }

    @Override
    public UserCoupon insert(UserCoupon userCoupon) {
        userCoupon.setId(uidService.genId());
        userCoupon.setCreateTime(new Date());
        userCoupon.setCreatePerson(userCoupon.getUserId());
        userCoupon.setUpdateTime(null);
        userCoupon.setUpdatePerson(null);
        userCoupon.setStatus("未使用");
        userCouponMapper.insertSelective(userCoupon);
        return userCoupon;
    }

    @Override
    public List<UserCoupon> list(Long id,String couponStatus,String userId) {
        return userCouponMapper.list(id,couponStatus,userId);
    }
}
