package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.CouponMapper;
import com.lixu.jie_you_ba.entity.Coupon;
import com.lixu.jie_you_ba.service.CouponService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Classname CouponServiceImpl
 * @Description TODO
 * @Date 2019-04-03 22:43
 * @Created by lixu
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private UidService uidService;

    @Override
    public Coupon insert(Coupon coupon) {
        coupon.setId(uidService.genId());
        coupon.setCreateTime(new Date());
        coupon.setStatus("可用");
        couponMapper.insertSelective(coupon);
        return coupon;
    }
}
