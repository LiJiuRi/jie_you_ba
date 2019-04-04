package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.UserCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCoupon record);

    int insertSelective(UserCoupon record);

    UserCoupon check(@Param("couponId") Long couponId, @Param("userId") String userId);

    List<UserCoupon> list(@Param("id")Long id,@Param("couponStatus") String couponStatus,@Param("userId") String userId);

    UserCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCoupon record);

    int updateByPrimaryKey(UserCoupon record);
}