package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.FoodCatalog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodCatalogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FoodCatalog record);

    int insertSelective(FoodCatalog record);

    FoodCatalog selectByPrimaryKey(Long id);

    List<FoodCatalog> list(Long storeId);

    int updateByPrimaryKeySelective(FoodCatalog record);

    int updateByPrimaryKey(FoodCatalog record);
}