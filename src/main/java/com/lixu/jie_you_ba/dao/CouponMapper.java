package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}