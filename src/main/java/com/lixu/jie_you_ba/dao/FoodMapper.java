package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Food record);

    int insertSelective(Food record);

    int remove(Long foodCatalogId);

    List<Food> list(Long foodCatalogId);

    List<Food> listByStoreId(@Param("foodCatalogId") Long foodCatalogId, @Param("storeId") Long storeId);

    Food selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}