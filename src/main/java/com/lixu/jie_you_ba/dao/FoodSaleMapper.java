package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.FoodSale;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodSaleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FoodSale record);

    int insertSelective(FoodSale record);

    FoodSale selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodSale record);

    int updateByPrimaryKey(FoodSale record);
}