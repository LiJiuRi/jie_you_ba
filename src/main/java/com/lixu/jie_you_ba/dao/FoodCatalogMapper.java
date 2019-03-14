package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.FoodCatalog;

public interface FoodCatalogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FoodCatalog record);

    int insertSelective(FoodCatalog record);

    FoodCatalog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodCatalog record);

    int updateByPrimaryKey(FoodCatalog record);
}