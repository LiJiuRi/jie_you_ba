package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    List<Order> list(@Param("status") Integer status, @Param("personId") String personId);

    List<Order> listOrder(@Param("status")Integer status, @Param("storeId")Long storeId, @Param("updatePerson")String updatePerson);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}